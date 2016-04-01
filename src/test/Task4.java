package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Task4 {
    // Please do not change this interface
    public static interface Node {
        int getValue();
        List<Node> getChildren();
    }


    public static List<Node> traverseTreeInDepth(Node root) {
        /*
          Please implement this method to
          traverse the tree in depth and return a list of all passed nodes.

          The method shall work optimally with large trees.
         */

        // Depth-first, inorder traversal
        List<Node> list = new ArrayList<>();
        if (root == null) return list;

//        Stack<Node> stack = new Stack<>();
        // ignore root
//        Node n = root.getChildren().get(0); // first child
//        Node n = root;

//        while (!stack.empty() || n != null) {
//            System.out.println("Getting node: " + n.getValue());
//            if (n.getChildren() != null && !n.getChildren().isEmpty()) {
////            if (n != null) {
//                stack.push(n);
//                n = n.getChildren().get(0);
//            } else {
//                Node nd = stack.pop();
//                list.add(new TreeNode(nd.getValue()));
//                n = nd.getChildren().get(1);
//            }
//        }

    	return list;
    }



    public static class TreeNode implements Node{

        private int data;
        private List<Node> children;

        public TreeNode(int d) {
            this.data = d;
            this.children = null;
        }

        @Override
        public int getValue() {
            return this.data;
        }

        @Override
        public List<Node> getChildren() {
            return this.children;
        }

        public void setChildren(List<Node> lst) {
            this.children = lst;
        }

        public Node getFirstChild() {
            return this.children.get(0);
        }

        public boolean hasChildNodes() {
            if (this.children != null && !this.children.isEmpty()) return true;
            return false;
        }
    }

    public static void main(String args[]) {
        test.Task4.TreeNode node1 = new test.Task4.TreeNode(1);
        test.Task4.TreeNode node2 = new test.Task4.TreeNode(2);
        test.Task4.TreeNode node3 = new test.Task4.TreeNode(3);
        test.Task4.TreeNode node4 = new test.Task4.TreeNode(4);
        List<Node> lst = new ArrayList<>();
        lst.add(node2);
        lst.add(node3);
        node1.setChildren(lst);
        List<Node> traverseLst = traverseTreeInDepth(node1);
        System.out.println(traverseLst.toString());
    }
}
