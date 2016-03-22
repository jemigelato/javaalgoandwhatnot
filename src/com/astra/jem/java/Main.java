package com.astra.jem.java;

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

}


