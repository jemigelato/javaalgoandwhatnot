package com.astra.jem.java;

/**
 * Created by jem on 2016/03/18.
 */
public class Stack<T> {
    String name = null;
    SQNode<T> top;
    public Stack(String n) {this.name = n;}

    void push(T d) {
        SQNode<T> n = new SQNode<>(d);
        n.next = top;
        top = n;
    }

    SQNode<T> pop() {
        if (top != null) {
            SQNode<T> node = top;
            top = top.next;
            return node;
        }
        return null;
    }

    boolean isEmpty() {
        return (top == null);
    }

    T peek(){
        if (top == null) return null;
        return top.data;
    }

    public void print(){
        System.out.println("Contents of stack " + name);
        SQNode n = top;
        while (n != null) {
            System.out.println("   " + n.data);
            n = n.next;
        }
    }
}
