package com.example.sdesheet.Day13;

public class StackWithArray {
    public static void main(String[] args) {
        StackOwn stack = new StackOwn();
        stack.push(10);
        stack.push(3);
        stack.push(12);
        stack.push(2);
        stack.push(9);
        System.out.println(stack.pop());
        System.out.println(stack.top());
        stack.push(7);
        System.out.println(stack.top());
        stack.push(4);
        stack.push(6);
    }
}

class StackOwn {
    int size;
    int arr[];
    int top;

    public StackOwn() {
        this.size = 10;
        arr = new int[size];
    }

    public StackOwn(int size) {
        this.size = size;
        arr = new int[size];
    }

    public void push(int num) {
        if (size() == 10)
            size += 10;

        arr[++top] = num;
    }

    public int pop() {
        return arr[top--];
    }

    public int top() {
        return arr[top];
    }

    public int size() {
        return this.size;
    }
}