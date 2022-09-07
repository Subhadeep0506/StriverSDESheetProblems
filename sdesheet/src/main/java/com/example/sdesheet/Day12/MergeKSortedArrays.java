package com.example.sdesheet.Day12;

import java.util.*;

class Pair {
    int list;
    int index;
    int val;
    public Pair(int list, int index, int val) {
        this.list = list;
        this.index = index;
        this.val = val;
    }
}

public class MergeKSortedArrays {
    public ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> kArrays, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        
        if (kArrays == null || kArrays.size() == 0)
            return res;
        
        PriorityQueue<Pair> queue = new PriorityQueue<>((a, b) -> (a.val - b.val));
        for (int list = 0; list < k; list++) {
            if (kArrays.get(list) != null)
                queue.offer(new Pair(list, 0, kArrays.get(list).get(0)));
        }
        
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            res.add(pair.val);

            int listNo = pair.list;
            int listSize = kArrays.get(listNo).size();
            
            if (pair.index + 1 < listSize) {
                queue.offer(new Pair(listNo, pair.index + 1, kArrays.get(listNo).get(pair.index + 1)));
            }
        }
        
        return res;
	}
}
