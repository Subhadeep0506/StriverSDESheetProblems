/*
    Given two numbers N and M, find the Nth root of M.

    The nth root of a number M is defined as a number X when raised to the power N equals M.

    Input: N=3 M=27

    Output: 3

    Explanation: The cube root of 27 is 3.
*/

package sdesheet.Day11;

public class NthRootOfNumber {
    public static void main(String[] args) {
        int n = 2, m = 16;
        System.out.println(nthRoot(n, m));
    }

    public static double nthRoot(int n, int m) {
        double low = 1;
        double high = m;
        double eps = Math.pow(10, -6);

        while (high - low > eps) {
            double mid = (high + low) / 2.0;
            if (multiply(mid, n) < m)
                low = mid;
            else
                high = mid;
        }

        return Math.ceil(low);
    }

    public static double multiply(double num, int times) {
        double ans = 1;

        for (int i = 0; i < times; i++) 
            ans *= num;

        return ans;
    }
}
