package Trees.BinarySearchTrees.Problems;

import Trees.BinaryTrees.Utility.TreeNode;
import Trees.BinaryTrees.Utility.TreeUtils;

public class MinimumValueInBST {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(3);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(1);

        TreeUtils.printTree(root);

        System.out.println(minValue(root));
    }

    public static int minValue(TreeNode root) {

        return findMinValue(root, Integer.MAX_VALUE);
    }

    public static int findMinValue(TreeNode root, int min) {

        if (root.left == null && root.right == null) {
            return root.val;
        }

        if (root.left != null) {
            min = Math.min(root.val, findMinValue(root.left, min));
        }
        if (root.right != null) {
            min = Math.min(root.val, findMinValue(root.right, min));
        }

        return min;
    }


}
