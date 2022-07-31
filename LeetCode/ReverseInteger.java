package LeetCode;

public class ReverseInteger {
    public static void main(String[] args) {
        int x = -2147483648;

        // System.out.println(Math.abs((long)x));
        System.out.println(reverse(x));
    }
    public static int reverse(int x) {
        if (x == 0)
            return 0;
        
        boolean isNegative = x < 0;
        
        StringBuffer sb = new StringBuffer("" + Math.abs(x));
        
        sb.reverse();
        
        Long temp = Long.valueOf(sb.toString());
        if (isNegative)
            temp = 0 - temp;
        
        if (temp > Integer.MAX_VALUE || temp < Integer.MIN_VALUE)
            return 0;
        
        return temp.intValue();
    }
}
