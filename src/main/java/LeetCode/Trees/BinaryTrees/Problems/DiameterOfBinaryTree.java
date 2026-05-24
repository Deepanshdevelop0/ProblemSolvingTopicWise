package LeetCode.Trees.BinaryTrees.Problems;

import LeetCode.Trees.BinaryTrees.Utility.TreeNode;
import LeetCode.Trees.BinaryTrees.Utility.TreeUtils;

public class DiameterOfBinaryTree {


    /*

    DFS

    TC : O(N) : no of nodes

    SC : O(H) : recursive stack space of height of tree

    */
    public static void main(String[] args) {

//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
//        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(5);
//        root.left.right.right = new TreeNode(6);
//        root.left.right.right.right = new TreeNode(7);

        TreeNode root = TreeUtils.buildTree(new Integer[]{4, -7, -3, null, null, -9, -3, 9, -7, -4, null, 6, null, -6, -6, null, null, 0, 6, 5, null, 9, null, null, -1, -4, null, null, null, -2});

        TreeUtils.printTree(root);

        // Calculate the diameter of the binary tree
        int diameter = diameterOfBinaryTree(root);

        System.out.println("The diameter of the binary tree is: " + diameter);
    }

    static int diameter = 0;

    public static int diameterOfBinaryTree(TreeNode root) {

        if (root == null) {
            return 0;
        }

        getHeightDfs(root);

        return diameter;
    }

    public static int getHeightDfs(TreeNode curr) {
        if (curr == null) return 0;

        int left = getHeightDfs(curr.left);
        int right = getHeightDfs(curr.right);

        diameter = Math.max(diameter, left + right);

        return 1 + Math.max(left, right);
    }
}
