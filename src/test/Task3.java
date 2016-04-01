package test;

public class Task3 {
    // Please do not change this interface
    interface ListNode {
        int getItem();
        ListNode getNext();
        void setNext(ListNode next);
    }

    public static ListNode reverse(ListNode node) {
        /*
          Please implement this method to
          reverse a given linked list.
         */
        if (node == null) return null;

        ListNode prev = null;
        ListNode curr = node;
        ListNode next = null;
        while (curr != null) {
            next = curr.getNext();
            curr.setNext(prev);
            prev = curr;
            curr = next;
        }
        node = prev;
        return node;
    }

    public static class TestNode implements ListNode {

        private int data;
        private ListNode next;

        public TestNode(int data) {
            this.data = data;
            this.next = null;
        }

        @Override
        public int getItem() {
            return this.data;
        }

        @Override
        public ListNode getNext() {
            return this.next;
        }

        @Override
        public void setNext(ListNode next) {
            this.next = next;
        }
    }

    public static void main(String args[]) {
        test.Task3.ListNode node1 = new test.Task3.TestNode(1);
        test.Task3.ListNode node2 = new test.Task3.TestNode(2);
        test.Task3.ListNode node3 = new test.Task3.TestNode(3);
        test.Task3.ListNode node4 = new test.Task3.TestNode(4);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        printList(node1);

        test.Task3.ListNode newHead = reverse(node1);
        printList(newHead);
    }

    static void printList(ListNode head) {
        System.out.println("\nPrinting list... ");
        if (head == null) {
            System.out.println("NULL");
            return;
        }

        ListNode n = head;
        while (n != null) {
            System.out.print(" " + n.getItem());
            n = n.getNext();
        }
    }

}
