package sdesheet.Day14;

import java.util.*;

public class NextSmallerElement {
    public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        Stack<Integer> stack = new Stack<>();
        int len = A.size();
        
        ArrayList<Integer> res = new ArrayList<>();
        
        for (int i = 0; i < len; i++) {
            int curr = A.get(i);
            while (!stack.isEmpty() && curr <= stack.peek())
                stack.pop();
            
            if (stack.isEmpty())
                res.add(-1);
            else {
                res.add(stack.peek());
            }
            stack.push(curr);
        }
        
        return res;
    }
}
