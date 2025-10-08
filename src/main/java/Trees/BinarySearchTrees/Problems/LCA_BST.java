package Trees.BinarySearchTrees.Problems;

import Trees.BinaryTrees.Utility.TreeNode;
import Trees.BinaryTrees.Utility.TreeUtils;

import java.nio.file.ClosedWatchServiceException;

public class LCA_BST {

    public static void main(String[] args) {

        TreeNode root = TreeUtils.buildTree(new Integer[]{6, 2, 8, 0, 4, 7, 9, null, null, 3, 5});

        System.out.println(lowestCommonAncestorRecursive(root, root.left, root.left.right).val);

    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        while (root != null) {

            if (p.val < root.val && q.val < root.val) {
                root = root.left;
            } else if (p.val > root.val && q.val > root.val) {
                root = root.right;
            } else {
                return root;
            }
        }

        return null;
    }

    /* Not much space optimal compared to iterative one */
    public static TreeNode lowestCommonAncestorRecursive(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) return null;

        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestorRecursive(root.left, p, q);
        } else if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestorRecursive(root.right, p, q);
        } else {
            return root;
        }

    }

}
