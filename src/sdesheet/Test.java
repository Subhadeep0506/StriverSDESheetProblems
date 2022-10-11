package sdesheet;

import java.util.*;

class Test {
    public String helper(String s, int n, int k){
        TreeMap<Integer> map = new TreeMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        
    }
}
