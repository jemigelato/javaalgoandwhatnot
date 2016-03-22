package com.astra.jem.java;

/**
 * Created by jem on 2016/03/22.
 *
 * A Queue implemented using two stacks
 */
public class MyQueue {
    java.util.Stack<Integer> left = new java.util.Stack<>();
    java.util.Stack<Integer> right = new java.util.Stack<>();

    public void add(int i) {
        System.out.println("pushing to queue: " + i);
        left.push(i);
    }

    public Integer remove() {

        if (right.isEmpty()) {
            if (left.isEmpty()) {
                System.out.println("removing but queue is empty.");
                return null;
            }
            while (!left.isEmpty()) {
                right.push(left.pop());
            }
        }
        int i = right.pop();
        System.out.println("removing from queue: " + i);
        return i;
    }

    public Integer peek() {
        if (right.isEmpty()) {
            if (left.isEmpty()) {
                System.out.println("peeking but queue is empty.");
                return null;
            }
            while (!left.isEmpty()) {
                right.push(left.pop());
            }
        }
        System.out.println("peeking at queue: " + right.peek());
        return right.peek();
    }
}
