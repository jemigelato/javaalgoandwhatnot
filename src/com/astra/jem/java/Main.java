package com.astra.jem.java;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
	    System.out.println("Here we go!");
        ListNode node1 = new ListNode(1);
//        ListNode node2 = new ListNode(2);
//        ListNode node3 = new ListNode(3);
//        node1.next = node2;
//        node2.next = node3;
//        node1.appendTail(2);
//        node1.appendTail(3);

//       ListNode.printList(node1);
//       ListNode rev = reverseList(node1);
//        ListNode.printList(rev);

        // Towers of Hanoi
//        int n = 4;
//        Stack<Integer> tower1 = new Stack<>("tower1");
//        Stack<Integer> tower2 = new Stack<>("tower2");
//        Stack<Integer> tower3 = new Stack<>("tower3");
//        for (int i = n-1; i >=0; i--) {
//            tower1.push(i);
//        }
//        tower1.print();
//
//        TowersOfHanoi towers = new TowersOfHanoi();
//        towers.solveTower(n, tower1, tower3, tower2);
//
//        tower3.print();
        // ------ towers


        // Sort stack
//        Stack<Integer> st = new Stack<>("SortMe");
//
//        st.push(3);
//        st.push(1);
//        st.push(2);
//        st.print();
//        Stack newSt = sortStack(st);
//        newSt.print();

        // MyQueue
//        MyQueue que = new MyQueue();
//        que.peek();
//        que.add(1);
//
//        que.add(2);
//        que.peek();
//        que.add(3);
//        que.remove();
//        que.remove();
//        que.add(4);
//        que.remove();
//        que.remove();
//        que.remove();
//        que.peek();

        // Tree
//        int[] ar = {10, 20, 25};
        int[] ar = {5,10, 15, 20, 25, 30, 35};
        BTNode nd = BinaryTree.fromArray(ar, 0, ar.length-1);
        BinaryTree.printSearchTree(nd);
        System.out.println("\nMax depth: " + BinaryTree.maxDepth(nd));

        ArrayList<LinkedList<BTNode>> arlist = BinaryTree.createLinkedLists(nd);
        for (LinkedList<BTNode> list: arlist) {
            System.out.println(list.toString());
        }
        BinaryTree.printBFS(nd);

        BinaryTree.getNode(nd, 25).parent = BinaryTree.getNode(nd, 30);
        BinaryTree.getNode(nd, 35).parent = BinaryTree.getNode(nd, 30);
        BinaryTree.getNode(nd, 5).parent = BinaryTree.getNode(nd, 10);
        BinaryTree.getNode(nd, 15).parent = BinaryTree.getNode(nd, 10);
        BinaryTree.getNode(nd, 10).parent = BinaryTree.getNode(nd, 20);
        BinaryTree.getNode(nd, 30).parent = BinaryTree.getNode(nd, 20);
        int i = 35;
        BTNode aNode = BinaryTree.getNode(nd, i);
        System.out.println("Node info for node " + i + ": "
                + (aNode.parent != null ? aNode.parent.toString() : "NULL") + ", "
                + (aNode.left != null ? aNode.left.toString() : "NULL") + ", "
                + (aNode.right != null ? aNode.right.toString() : "NULL")  );

        BTNode next = BinaryTree.inorderSuccessor(aNode);
        System.out.println("Next node: "
                + (next != null ? next.toString() : next));

        System.out.println("Preorder traversal...");
        BinaryTree.printPreorder(nd);

        BinaryTree.printAncestors(nd, 5);

        // Equilibrium
        int[] arr = {-7, 1, 5, 2, -4, 3, 0};
        System.out.println(equi(arr, arr.length));

        // Rectangle
        Rectangle rec = new Rectangle();
        System.out.println("Area of rectangles: "
                + rec.solution(-4, 1, 2, 6, 0, -1, 4, 3)); // ans: 42
        System.out.println("Area of rectangles: "
                + rec.solution(1, 1, 3, 3, 2, 2, 5, 5)); // ans: 12
        System.out.println("Area of rectangles: "
                + rec.solution(-5, -10, -1, -4, -11, -6, -4, -1)); // ans: 57
        System.out.println("Area of rectangles: "
                + rec.solution(5, 1, 12, 6, 0, 0, 8, 3)); // ans: 53
        System.out.println("Area of rectangles: "
                + rec.solution(0, 0, 3, 4, 5, 0, 10, 4)); // ans: 32
        System.out.println("Area of rectangles: "
                + rec.solution(2, 2, 6, 6, -2, -2, 5, -1)); // ans: 23
        System.out.println("Area of rectangles: "
                + rec.solution(-2147483648, -2147483648, 2147483647, 2147483647, -2147483648, -2147483648, 2147483647, 2147483647)); // ans: -1
        System.out.println("Area of rectangles: "
                + rec.solution(0,0,0,0,0,0,0,0)); // ans: 0
        System.out.println("Area of rectangles: "
                + rec.solution(-2147483648, -2147483648, 2147483647, 2147483647, 0, 0, 1, 1)); // ans: -1
        System.out.println("Area of rectangles: "
                + rec.solution(-1, -1, 2147483647, 1, 0, 0, 1, 1)); // ans: -1
        System.out.println("Area of rectangles: "
                + rec.solution(0, 0, 2147483646, 1, 2147483645, 0, 2147483647, 1)); // ans:
    }

    public static Stack sortStack(Stack<Integer> s) {
        Stack<Integer> dest = new Stack<>("I am a stack");
        while (!s.isEmpty()) {
            SQNode<Integer> tmp = s.pop();
            while (!dest.isEmpty() && tmp.data > dest.peek()) {
                s.push(dest.pop().data);
            }
            dest.push(tmp.data);
        }
        return dest;
    }



    public static ListNode reverseList(ListNode head) {
        System.out.println("Reversing...");
        if (head == null) return null;
        ListNode n = head;
        ListNode prev = null;
        ListNode current = head;
        ListNode nxt = null;

        while (current != null) {
            //System.out.println("n1: " + n.val);
            //System.out.println("cur.next: " + current.next.val);

            nxt = current.next;
            current.next = prev;
            prev = current;
            current = nxt;

            //System.out.println("n2: " + n.val);
            //System.out.println("new cur.next: " + current.next.val);
        }

        return prev;
    }

    static int equi(int A[], int n) {
        int index = -1;
        int sum=0;
        for (int i = 0; i < n; i++) {
            sum = sum + A[i];
        }
        System.out.println("sum: " + sum);

        int sumL = 0;
        for (int i = 0; i < n; i++) {
            int sumR = sum - sumL - A[i];
            if (sumR == sumL) index = i;
            sumL = sumL + A[i];
        }
        return index;
    }

}


