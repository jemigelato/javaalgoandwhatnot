package com.astra.jem.java;

import java.util.*;
import java.util.Queue;

/**
 * Created by Jem on 2016/03/18.
 */
public class BinaryTree {
    // I am a Binary Search Tree
    BTNode root;
    public BinaryTree() {
        root = null;
    }

    BTNode insert(BTNode node, int data) {
        if (node == null) {
            node = new BTNode(data);
        } else {
            if (data <= node.data) {
                node.left = insert(node.left, data);
            } else {
                node.right = insert(node.right, data);
            }
        }
        return node;
    }

    int countNodes(BTNode root) {
        int ct = 0;
        if (root == null) return 0;
        ct = 1 + countNodes(root.left) + countNodes(root.right);
        return ct;
    }

    static int maxDepth(BTNode node) {
        int dep = 0;
        if (node == null) return dep;
        int depL = maxDepth(node.left);
        int depR = maxDepth(node.right);
        if(depL >= depR) {
            dep = depL;
        } else {
            dep = depR;
        }
        return dep + 1;
    }

    int minVal(BTNode node) {
//        int min = node.data;
//        int minL = node.data;
//        int minR = node.data;
//        if (node.left != null) {
//            minL = smaller(minVal(node.left), node.data);
//        }
//        if (node.right != null) {
//            minR = smaller(minVal(node.right), node.data);
//        }
//        return smaller(minL, minR);
        if (node.left == null) return node.data;
        return minVal(node.left);
    }

    int maxVal(BTNode node) {
        if (node.right == null) return node.data;
        return maxVal(node.right);
    }

    int smaller(int a, int b) {
        if (a<b) return a;
        else return b;
    }

    static void printSearchTree(BTNode node) {
        if (node == null) return;
        printSearchTree(node.left);
        System.out.print(node.data + " ");
        printSearchTree(node.right);
    }

    void printPostOrder(BTNode node) {
        if (node == null) return;
        printPostOrder(node.left);
        printPostOrder(node.right);
        System.out.print(node.data + " ");
    }

    void breadthFirstSearch(java.util.Queue<BTNode> q) {
        if (q == null || q.isEmpty()) return;
        BTNode node = q.poll();
        System.out.print(node.data + " ");
        if (node.left != null) q.offer(node.left);
        if (node.right != null) q.offer(node.right);
        breadthFirstSearch(q);
    }

    void depthFirstSearch(java.util.Stack<BTNode> stack) {
        if (stack == null || stack.isEmpty()) return;
        BTNode node = stack.pop();
        System.out.print(node.data + " ");
        if (node.right != null) stack.push(node.right);
        if (node.left != null) stack.push(node.left);
        depthFirstSearch(stack);
    }

    boolean isLeafBalanced(BTNode node) {
        int ld = getLeftLeafRootDistance(node);
        System.out.println("Left Distance: " + ld);
        int rd = getRightLeafRootDistance(node);
        System.out.println("Right Distance: " + rd);
        return (Math.abs(ld - rd) <= 1);
    }

    int getLeftLeafRootDistance(BTNode node) {
        if (node == null) return 0;
        int dist = 1 + getLeftLeafRootDistance(node.left);
        return dist;
    }

    int getRightLeafRootDistance(BTNode node) {
        if (node == null) return 0;
        int dist = 1 + getRightLeafRootDistance(node.right);
        return dist;
    }

    int getMinDepth(BTNode node) {
        if (node == null) return 0;
        int minL = getMinDepth(node.left);
        int minR = getMinDepth(node.right);
        int min = 1 + Math.min(minL, minR);
        return min;
    }

    int getMaxDepth(BTNode node) {
        if (node == null) return 0;
        int max = 1 + Math.max(getMaxDepth(node.left), getMaxDepth(node.right));
        return max;
    }

    boolean isBalanced(BTNode node) {
        int min = getMinDepth(node);
        int max = getMaxDepth(node);
        System.out.println("min depth: " + min);
        System.out.println("max depth: " + max);
        return ( Math.abs( max - min ) <= 1);
    }

    /*
    Given a sorted (increasing order) array,
    write an algorithm to create a binary tree with minimal height.
     */
    static BTNode fromArray(int[] arr, int start, int end) {
        if ((end < start) || (arr.length == 0)) return null;
//        int[] subarr = new int[end-start+1];
//        for (int i = 0; i < subarr.length; i++) {
//            subarr[i] = arr[start + i];
//        }
        int mid = (end - start) / 2;
        BTNode node = new BTNode(arr[mid]);
        int leftLen = 0;
        if (end - start > 0) leftLen = mid;
        if (leftLen > 0) {
            int[] arrL = new int[leftLen];
            for (int i=0; i < arrL.length; i++) {
                arrL[i] = arr[i];
            }
            node.left = fromArray(arrL, 0, mid-1);
        }

        int rLen = 0;
        if (end - start > 0) rLen =arr.length - mid - 1;
        if (rLen > 0) {
            int[] arrR = new int[rLen];
            for (int i=0; i < arrR.length; i++) {
                arrR[i] = arr[mid+1+i];
            }

            node.right = fromArray(arrR, mid+1, arr.length);
        }

        return node;
    }

    static ArrayList<LinkedList<BTNode>> createLinkedLists(BTNode node) {
        System.out.println("Creating array of depth-based linked lists...");
        int level = 0;
        ArrayList<LinkedList<BTNode>> result = new ArrayList<>();
        LinkedList<BTNode> list = new LinkedList<>();
        list.add(node);
        result.add(level, list);
        while(true){
            list = new LinkedList<>();
            for (int i = 0; i < result.get(level).size(); i++) {
                BTNode nx = result.get(level).get(i);
                if (nx != null) {
//                    System.out.println(nx.data);
                    if (nx.left != null) list.add(nx.left);
                    if (nx.right != null) list.add(nx.right);
                }
            }
            if (list.size() > 0) result.add(level + 1, list);
            else break;
            level++;
        }
        return result;
    }

    static void printBFS(BTNode node) {
        System.out.println("Printing BFS using a while loop...");
        Queue<BTNode> list = new LinkedList<>();
        list.offer(node);
        while (!list.isEmpty()) {
            BTNode nx = list.poll();
            if (nx != null) {
                System.out.println(nx.data);
                list.offer(nx.left);
                list.offer(nx.right);
            }
        }
    }

}
