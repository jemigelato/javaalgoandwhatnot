package com.astra.jem.java;

public class ListNode {
    int val;
    ListNode next = null;
    ListNode(int x) { val = x; }

    public static void printList(ListNode head) {
        if (head == null) {
            System.out.println("NULL");
            return;
        }

        ListNode n = head;

        while (n != null) {
            System.out.println(n.val);
            n = n.next;
        }
    }

    public void appendTail(int v) {
        ListNode end = new ListNode(v);
        ListNode node = this;
        while (node.next != null) {
            System.out.println("node: " + node.val);
            node = node.next;

        }
        node.next = end;
        System.out.println("old tail: " + node.val);
    }
}
