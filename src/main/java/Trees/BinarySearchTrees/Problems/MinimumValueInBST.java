package Trees.BinarySearchTrees.Problems;


import Trees.BinaryTrees.Utility.TreeNode;
import Trees.BinaryTrees.Utility.TreeUtils;

public class MinimumValueInBST {

/*

Iterative Approach

Time Complexity: O(h), where h = height of the tree
Balanced BST: O(log n)
Skewed BST: O(n)

Space Complexity: O(1) (iterative, no recursion)

*/

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(3);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(1);

        TreeUtils.printTree(root);

        System.out.println(minValueMostOptimal(root));
    }

    public static int minValueMostOptimal(TreeNode root) {
        if (root == null) {
            return -1;
        }

        while (root.left != null) {
            root = root.left;
        }

        return root.val;
    }

}
