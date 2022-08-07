// https://leetcode.com/problems/mirror-reflection/

package LeetCode.Aug22;

public class MirrorReflection {
    public int mirrorReflection(int p, int q) {
        int m = q, n = p;
        // While m and n are even, divide them by 2
        while (m % 2 == 0 && n % 2 == 0) {
            m /= 2;
            n /= 2;
        }
        
        if (m % 2 == 0 && n % 2 == 1)
            return 0;
        if (m % 2 == 1 && n % 2 == 1)
            return 1;
        if (m % 2 == 1 && n % 2 == 0)
            return 2;
        return -1;
    }
}
