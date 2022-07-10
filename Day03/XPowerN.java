/*
 * Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
 */

package Day03;

public class XPowerN {
    public double myPow(double x, int n) {
        long pow = n;
        if (pow < 0)
            pow = (-pow);
        double res = 1;
        while (pow > 0) {
            if (pow % 2 == 0) {
                x = x * x;
                pow /= 2;
            }
            else {
                res *= x;
                pow--;
            }
        }
        
        if (n < 0) {
            res = 1.0 / res;
        }
        
        return res;
    }
}
