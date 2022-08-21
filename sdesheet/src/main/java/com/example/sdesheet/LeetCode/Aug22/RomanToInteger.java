/*
 * https://leetcode.com/problems/roman-to-integer/
 */

package com.example.sdesheet.LeetCode.Aug22;

public class RomanToInteger {
    public int romanToInt(String s) {
        int len = s.length();
        int sum = 0;
        for (int i = len - 1; i >= 0; i--) {
            int num = 0;
            switch(s.charAt(i)) {
                case 'I':
                    num = 1;
                    break;
                case 'V':
                    num = 5;
                    break;
                case 'X':
                    num = 10;
                    break;
                case 'L':
                    num = 50;
                    break;
                case 'C':
                    num = 100;
                    break;
                case 'D':
                    num = 500;
                    break;
                case 'M':
                    num = 1000;
                    break;
            }
            
            if (4 * num < sum)
                sum = sum - num;
            else 
                sum = sum + num;
        }
        
        return sum;
    }
}
