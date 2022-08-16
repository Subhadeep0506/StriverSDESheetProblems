package com.example.sdesheet.Misc;

public class StringContainsSubstring {
    public static void main(String[] args) {
        String s1 = "Subhadeep";
        String s2 = "123";
        System.out.println(containsSubstring(s1, s2));
    }

    public static boolean containsSubstring(String s1, String s2) {
        boolean contains = false;
        int j = 0; 
        int i = 0;
        // Run while s2 has not exhausted
        while (j < s2.length() && i < s1.length()) {
            if (s1.charAt(i) == s2.charAt(j)) {
                i++;
                j++;
            }
            else {
                i++;
            }
        }
        if (j == s2.length()) 
            return true;
        if (i == s1.length())
            return false;
        return contains;
    }
}
