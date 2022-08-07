package InfySamples;

import java.util.HashMap;
import java.util.Map;

public class InterestingString {
    public static void main(String[] args) {
        String text = "aaaaaaaabbbbcc";
        System.out.println(interestingString(text));
    }

    public static int interestingString(String text) {
        int smallest = text.length();

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < text.length(); i++) {
            if (map.containsKey(text.charAt(i))) {
                int value = map.get(text.charAt(i));
                map.put(text.charAt(i), value + 1);
            }
            else {
                map.put(text.charAt(i), 1);
            }
        }
        for (Map.Entry<Character, Integer> set: map.entrySet()) {
            // if (set.getValue() > largest) {
            //     largest = set.getValue();
            // }
            if (set.getValue() < smallest) {
                smallest = set.getValue();
            }
        }
        
        // if (smallest == largest) {
        //     smallest = 1;
        //     return largest / smallest;
        // }

        return smallest;
    }
}
