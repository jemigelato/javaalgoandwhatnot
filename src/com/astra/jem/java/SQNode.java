package com.astra.jem.java;

/**
 * Created by jem on 2016/03/18.
 */
public class SQNode<T> {
    T data;
    SQNode next;
    public SQNode (T d) {
        this.data = d;
        this.next = null;
    }
}
