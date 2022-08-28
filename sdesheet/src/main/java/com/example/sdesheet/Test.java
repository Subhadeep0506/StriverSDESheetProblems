package com.example.sdesheet;

import java.util.*;

class Test {
    public static int isMagic(int n) {
        if (n % 9 == 1)
            return 1;
        else 
            return 0;
    }

    // public static void main(String[] args) {
    //     int n = 83557;
    //     System.out.println(isMagic(n));
    // }
}

class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int  i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(distLaddoo(n, arr));
    }

    public static long distLaddoo(int n, int[] arr) {
        int[] laddoos = new int[n];
        Arrays.fill(laddoos, 1);
        for (int i = 0; i < n - 1; i++) {
            if (arr[i + 1] > arr[i]){
                laddoos[i + 1] = laddoos[i] + 1;
            }
        }
        
        for (int i = n - 1; i > 0; i--) {
            if (arr[i - 1] > arr[i] && laddoos[i - 1] <= laddoos[i])
                laddoos[i - 1] = laddoos[i] + 1;
        }

        long total = 0;

        for(int c : laddoos){
            total += (long)c;
        }
    
        return total;
    }
}