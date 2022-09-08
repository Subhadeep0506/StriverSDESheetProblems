package com.example.sdesheet.Day13;

import java.util.*;

public class QueueWithStack {
	Stack<Integer> input;
    Stack<Integer> output;
    
    public MyQueue() {
        input = new Stack<>();
        output = new Stack<>();
    }
    
    public void push(int x) {
        input.add(x);
    }
    
    public int pop() {
        if(output.isEmpty()) {
            while (!input.isEmpty())
                output.push(input.pop());
        }
        
        return output.pop();
    }
    
    public int peek() {
        if(output.isEmpty()) {
            while (!input.isEmpty())
                output.push(input.pop());
        }
        
        return output.peek();
    }
    
    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }
}