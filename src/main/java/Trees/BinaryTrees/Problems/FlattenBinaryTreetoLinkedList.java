package Trees.BinaryTrees.Problems;

import Trees.BinaryTrees.Utility.TreeNode;
import Trees.BinaryTrees.Utility.TreeUtils;
import com.sun.source.tree.Tree;

import java.util.Stack;

public class FlattenBinaryTreetoLinkedList {

/*

Approach 1 : flatten()

Recursive (DFS)

TC : O(n), where n is the number of nodes
SC : O(h), recursive stack space, O(h) = height of tree, O(n) in worst case

---------------------------------------------------------------------------------

Approach 2 : flattenIterative()

Iterative with Stack

TC : O(n), where n is the number of nodes
SC : O(h), explicit stack space, O(h) = height of tree, O(n) in worst case

---------------------------------------------------------------------------------

Approach 3 : flattenMostOptimal()

Morris Traversal

TC : O(n), where n is the number of nodes
SC : O(1), no extra stack or recursion

*/

    public static void main(String[] args) {

        TreeNode root = TreeUtils.buildTree(new Integer[]{1, 2, 5, 3, 4, null, 6});
        TreeUtils.printTree(root);
        flattenMostOptimal(root);

        for (TreeNode i = root; i != null; i = i.right) {
            System.out.println(i.val + ",");
        }

    }

    static TreeNode prev = null;

    public static void flatten(TreeNode root) {

        if (root == null) {
            return;
        }

        flatten(root.right);
        flatten(root.left);

        root.right = prev;
        root.left = null;
        prev = root;

    }

    public static void flattenIterative(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);

        TreeNode prev = null;

        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();

            if (curr.right != null) {
                stack.push(curr.right);
            }

            if (curr.left != null) {
                stack.push(curr.left);
            }

            if (prev != null) {
                prev.right = curr;
                prev.left = null;
            }

            prev = curr;

        }

    }


    /* Morris traversal (without recursion and without stack and queue) */
    public static void flattenMostOptimal(TreeNode root) {
        // Initialize a pointer
        // 'curr' to the root of the tree
        TreeNode curr = root;

        // Iterate until 'curr'
        // becomes NULL
        while (curr != null) {
            // Check if the current
            // node has a left child
            if (curr.left != null) {
                // If yes, find the rightmost
                // node in the left subtree
                TreeNode pre = curr.left;
                while (pre.right != null) {
                    pre = pre.right;
                }

                // Connect the rightmost node in
                // the left subtree to the current
                // node's right child
                pre.right = curr.right;

                // Move the entire left subtree to the
                // right child of the current node
                curr.right = curr.left;

                // Set the left child of
                // the current node to NULL
                curr.left = null;
            }

            // Move to the next node
            // on the right side
            curr = curr.right;
        }
    }
}
