package LeetCode;

public class MinimumTimeToFillCups {
    public static void main(String[] args) {
        int[] amount = {5, 4, 4};

        System.out.println(fillCups(amount));
    }

    public static int fillCups(int[] amount) {
        int i = 0, j = 1; 
        int seconds = 0;
        while (j < 3) {
            if (amount[i] == 0) {
                i++;
                j++;
            }
            else if (amount[j] == 0){
                j++;
            }
            if (j == 3)
                break;
            amount[i]--;
            amount[j]--;
            seconds++;
        }
        
        i = 0;
        while (i < 3) {
            if (amount[i] == 0) {
                i++;
                if (i == 3)
                    break;
            }
            
            amount[i]--;
            seconds++;
        }
        
        return seconds;
    }
}
