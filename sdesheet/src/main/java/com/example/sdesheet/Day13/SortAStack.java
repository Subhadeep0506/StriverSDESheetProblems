package com.example.sdesheet.Day13;

import java.util.Stack;

public class SortAStack {
    public static void sortStack(Stack<Integer> stack) {
        Stack<Integer> temp = new Stack<>();

        while (!stack.isEmpty()) {
            int num = stack.pop();

            while (!temp.isEmpty() && temp.peek() < num)
                stack.push(temp.pop());
                
            temp.push(num);
        }
        
        while (!temp.isEmpty())
            stack.push(temp.pop());
	}
}
