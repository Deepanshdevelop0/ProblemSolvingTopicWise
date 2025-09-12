package Trees.BinarySearchTrees.Problems;

import Trees.BinaryTrees.Utility.TreeNode;
import Trees.BinaryTrees.Utility.TreeUtils;

public class ValidateBinarySearchTree {

/*

Approach 1 : DFS (isValidBSTDFS)
TC : O(n) - each node visited once
SC : O(h) - recursive stack, (O(log n) for balanced tree, O(n) for skewed tree in worst case)

---------------------------------------

Approach 1 : DFS (isValidBSTDFSMoreSpaceOptimal)
TC : O(n) - each node visited once
SC : O(h) - recursive stack, (O(log n) for balanced tree, O(n) for skewed tree in worst case)
(Slightly better in constants since it avoids extra local variable)

*/


    public static void main(String[] args) {
        TreeNode root = TreeUtils.buildTree(new Integer[]{Integer.MAX_VALUE});

        TreeUtils.printTree(root);

        System.out.println(isValidBST(root));
    }


    public static boolean isValidBST(TreeNode root) {

        return isValidBSTDFSMoreSpaceOptimal(root, java.lang.Long.MIN_VALUE, java.lang.Long.MAX_VALUE);
    }

    public static boolean isValidBSTDFS(TreeNode root, Long minRange, Long maxRange) {
        if (root == null) {
            return true;
        }

        if (root.val <= minRange || root.val >= maxRange) {
            return false;
        }

        boolean isBST = true;

        isBST = isValidBSTDFS(root.left, minRange, (long) root.val);

        if (isBST) {
            isBST = isValidBSTDFS(root.right, (long) root.val, maxRange);
        }

        return isBST;
    }


    public static boolean isValidBSTDFSMoreSpaceOptimal(TreeNode root, Long minRange, Long maxRange) {
        if (root == null) {
            return true;
        }

        if (root.val <= minRange || root.val >= maxRange) {
            return false;
        }

        return isValidBSTDFSMoreSpaceOptimal(root.left, minRange, (long) root.val)
                && isValidBSTDFSMoreSpaceOptimal(root.right, (long) root.val, maxRange);
    }

}
