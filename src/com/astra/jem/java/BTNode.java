package com.astra.jem.java;

/**
 * Created by Jem on 2016/03/18.
 */
public class BTNode {
    BTNode left;
    BTNode right;
    int data;

    public BTNode(int d) {
        this.data = d;
        left = null;
        right = null;
    }

    @Override
    public String toString() {
        return "" + this.data;
    }
}
