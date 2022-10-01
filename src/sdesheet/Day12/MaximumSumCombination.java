package sdesheet.Day12;

import java.util.*;

class PairSum {
    int a;
    int b;
    int sum;

    PairSum(int a, int b, int sum) {
        this.a = a;
        this.b = b;
        this.sum = sum;
    }
}

public class MaximumSumCombination {
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
        ArrayList<Integer> res = new ArrayList<>();
        int len = A.size();

        // MaxHeap to store the pairs with max sum first
        PriorityQueue<PairSum> queue = new PriorityQueue<>((a, b) -> (b.sum - a.sum));
        // This set will store the index pair that were visited
        // (a * len of arrays) + b -> this will be the formula used
        HashSet<Integer> set = new HashSet<>();

        // Sort the given arrays in descending order
        Collections.sort(A, (a, b) -> (b - a));
        Collections.sort(B, (a, b) -> (b - a));

        // Add the first pair to the queue
        queue.offer(new PairSum(0, 0, A.get(0) + B.get(0)));
        // and the first pair index [0 * len + 0]
        set.add(0);

        // While C is not exhausted...
        while (C-- > 0) {
            // Get the top pair
            PairSum pair = queue.poll();
            // Add the sum to result array
            res.add(pair.sum);
            int a = pair.a;
            int b = pair.b;

            // try to add the pair (a, b + 1)
            if (b + 1 < len && !set.contains(a * len + (b + 1))) {
                set.add(a * len + b + 1);
                queue.add(new PairSum(a, b + 1, A.get(a) + B.get(b + 1)));
            }

            // try to add the pair (a + 1, b)
            if (a + 1 < len && !set.contains((a + 1) * len + b)) {
                set.add((a + 1) * len + b);
                queue.add(new PairSum(a + 1, b, A.get(a + 1) + B.get(b)));
            }
        }

        return res;
    }
}
