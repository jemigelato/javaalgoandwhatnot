package test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Task4 {
    // Please do not change this interface
    public interface Node {
        int getValue();
        List<Node> getChildren();
    }


    public static List<Node> traverseTreeInDepth(Node root) {
        /*
          Please implement this method to
          traverse the tree in depth and return a list of all passed nodes.

          The method shall work optimally with large trees.
         */

        List<Node> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        ArrayDeque<Node>  stack = new ArrayDeque<>();
        Node node = root;

        while (true) {
            stack.push(node);
            if ( node.getChildren() != null && node.getChildren().get(0) != null ) {
                node = node.getChildren().get(0);
            } else {
                break;
            }
        }

        while (stack.size() > 0) {
            node = stack.pop();
            list.add(node);
            if (node.getChildren() != null) {
                int count = node.getChildren().size();
                for (int i = count - 1; i > 0; i--) {
                    if (node.getChildren() != null && node.getChildren().get(i) != null) {
                        Node nodex = node.getChildren().get(i);
                        while (true) {
                            stack.push(nodex);
                            if ((nodex.getChildren() != null)
                                    && (nodex.getChildren().get(0) != null)) {
                                nodex = nodex.getChildren().get(0);
                            } else {
                                break;
                            }
                        }
                    }
                }
            }
        }

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

    }

    public static void main(String args[]) {
        test.Task4.TreeNode node1 = new test.Task4.TreeNode(1);
        test.Task4.TreeNode node2 = new test.Task4.TreeNode(2);
        test.Task4.TreeNode node3 = new test.Task4.TreeNode(3);
        test.Task4.TreeNode node4 = new test.Task4.TreeNode(4);
        test.Task4.TreeNode node5 = new test.Task4.TreeNode(5);
        test.Task4.TreeNode node6 = new test.Task4.TreeNode(6);
        test.Task4.TreeNode node7 = new test.Task4.TreeNode(7);
        test.Task4.TreeNode node8 = new test.Task4.TreeNode(8);
        test.Task4.TreeNode node9 = new test.Task4.TreeNode(9);
        test.Task4.TreeNode node10 = new test.Task4.TreeNode(10);
        test.Task4.TreeNode node45 = new test.Task4.TreeNode(45);

        List<Node> lst = new ArrayList<>();
        lst.add(node2);
        lst.add(node3);
        node1.setChildren(lst);

        lst = new ArrayList<>();
        lst.add(node4);
        lst.add(node45);
        lst.add(node5);
        lst.add(node6);
        node2.setChildren(lst);

        lst = new ArrayList<>();
        lst.add(node7);
        node3.setChildren(lst);

        lst = new ArrayList<>();
        lst.add(node8);
        node4.setChildren(lst);

        lst = new ArrayList<>();
        lst.add(node9);
        lst.add(node10);
        node6.setChildren(lst);

        List<Node> traverseLst = traverseTreeInDepth(node1);
        System.out.println("Printing list...");
        for (Node nd : traverseLst) {
            System.out.print(nd.getValue() + ", ");
        }
    }
}
