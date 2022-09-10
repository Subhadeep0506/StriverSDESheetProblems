package sdesheet;

import java.util.*;

class Test {
    public static void main(String args[]) {
        int[][] properties = {{2, 2}, {4, 3}, {3, 3}, {1, 3}};
        Arrays.sort(properties, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] < b[0]) {
                    if (a[1] < b[1])
                        return -1;
                    else
                        return 0;
                }
                else {
                    return 1;
                }
            }
        });

        for (int[] row : properties)
            System.out.println(row[0] + " " + row[1]);
    }
}
