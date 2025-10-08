package Trees.BinarySearchTrees.Problems;

import Trees.BinaryTrees.Utility.TreeNode;
import Trees.BinaryTrees.Utility.TreeUtils;

import javax.swing.text.GapContent;

public class InsertValueIntoBST {


/*

Approaches for Insert into BST:

1. insertIntoBST (Recursive with explicit null checks)
   Time Complexity: O(h) → O(log n) average, O(n) worst
   Space Complexity: O(h) due to recursion stack → O(log n) average, O(n) worst

2. insertIntoBSTMoreReadableRecursion (Cleaner recursive style)
   Time Complexity: O(h) → O(log n) average, O(n) worst
   Space Complexity: O(h) due to recursion stack → O(log n) average, O(n) worst

3. insertIntoBSTIterative (Iterative approach)
   Time Complexity: O(h) → O(log n) average, O(n) worst
   Space Complexity: O(1) (no recursion stack, only a few pointers)

*/

    public static void main(String[] args) {
        TreeNode root = TreeUtils.buildTree(new Integer[]{4, 2, 7, 1, 3});

        TreeUtils.printTree(root);

        TreeUtils.printTree(insertIntoBSTIterative(root, 5));
    }

    public static TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (val < root.val) {
            if (root.left != null) {
                insertIntoBST(root.left, val);
            } else {
                root.left = new TreeNode(val);
            }
        } else {
            if (root.right != null) {
                insertIntoBST(root.right, val);
            } else {
                root.right = new TreeNode(val);
            }
        }

        return root;
    }

    public static TreeNode insertIntoBSTMoreReadableRecursion(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }

        return root;
    }

    public static TreeNode insertIntoBSTIterative(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        TreeNode curr = root;

        while (true) {
            if (val < curr.val) {

                if (curr.left == null) {
                    curr.left = new TreeNode(val);
                    break;
                }
                curr = curr.left;

            } else {

                if (curr.right == null) {
                    curr.right = new TreeNode(val);
                    break;
                }
                curr = curr.right;
            }
        }

        return root;
    }

}
