package com.example.sdesheet;

import java.util.*;

class Test {
    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);
        // set.add(-5);
        Integer num = set.ceiling(6);
        System.out.println(num);
    }
}