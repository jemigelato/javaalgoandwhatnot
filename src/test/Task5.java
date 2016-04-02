package test;

import java.util.ArrayList;
import java.util.List;

public class Task5 {
    // Please do not change this interface
    public static interface Node {
        int getValue();
        List<Node> getChildren();
    }


    public static int getLargestRootToLeafSum(Node root) {
        /*
          A root-to-leaf path in a tree is a path from a leaf node through all its ancestors
          to the root node inclusively.
          A "root-to-leaf sum" is a sum of the node values in a root-to-leaf path.

          Please implement this method to
          return the largest root-to-leaf sum in the tree.
         */
        int maxSum = Integer.MIN_VALUE;
        int max = maxSum(root, 0, maxSum);
        return max;

    }

    static int maxSum(Node root, int sum, int maxSum) {

        if (root != null) {
            sum = sum + root.getValue();
            if (sum > maxSum && (root.getChildren() == null || root.getChildren().isEmpty())) {
                maxSum = sum;
            }
//            System.out.println("sum: " + sum);
            for (int i = 0; i < root.getChildren().size(); i ++) {
                maxSum = maxSum(root.getChildren().get(i), sum, maxSum);
            }
        }

        return maxSum;
    }



    public static class TreeNode implements Node{

        private int data;
        private List<Node> children;

        public TreeNode(int d) {
            this.data = d;
            this.children = new ArrayList<>();
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
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(-9);
        TreeNode node10 = new TreeNode(-10);
        TreeNode node11 = new TreeNode(-11);
        TreeNode node45 = new TreeNode(45);
        TreeNode node30 = new TreeNode(-30);
        TreeNode node40 = new TreeNode(-40);

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
        lst.add(node11);
        lst.add(node40);
        node6.setChildren(lst);

        lst = new ArrayList<>();
        lst.add(node30);
        node10.setChildren(lst);

        int max = getLargestRootToLeafSum(node6);
        System.out.println("Largest root to leaf sum: " + max);
    }
}
