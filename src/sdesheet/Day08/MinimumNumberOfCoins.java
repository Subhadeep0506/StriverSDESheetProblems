package sdesheet.Day08;

import java.util.ArrayList;
import java.util.Arrays;

public class MinimumNumberOfCoins {
    public static void main(String[] args) {
        // int[] coins = {25, 10, 5};
        int[] coins = { 1, 2, 5, 10, 20, 50, 100, 500, 1000};
        int V = 49;

        System.out.println(numCoins(V, coins));
    }

    public static int numCoins(int V, int[] coins) {
        Arrays.sort(coins);
        ArrayList<Integer> res = new ArrayList<>();
        int price = V;
        int i = coins.length - 1;
        while (price != 0 && i >= 0) {
            if (price >= coins[i]) {
                price -= coins[i];
                res.add(coins[i]);
            }
            else {
                i--;
            }
        }
        if (price != 0)
            return -1;
        return res.size();
    }

    public static int minCoins(int V, int M, int[] coins) {
        int res = Integer.MAX_VALUE;

        for (int i = 0; i < M; i++) {
            if (V >= coins[i]) {
                int subRes = minCoins(V - coins[i], M, coins);

                if (subRes != Integer.MAX_VALUE && subRes + 1 < res)
                    res = subRes + 1;
            }
        }
        return res; 
    }
}
