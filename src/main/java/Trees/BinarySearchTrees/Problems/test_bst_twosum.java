package Trees.BinarySearchTrees.Problems;

import Trees.BinaryTrees.Utility.TreeNode;
import Trees.BinaryTrees.Utility.TreeUtils;

import java.util.Stack;

public class test_bst_twosum {

    public static void main(String[] args) {
        // Sample binary search tree: 7 3 15 -1 -1 9 20
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);

        System.out.println("Tree Initialized: ");
        TreeUtils.printTree(root);

        test_bst_twosum testBstTwosum = new test_bst_twosum();

        int target = 22;
        boolean exists = testBstTwosum.findTarget(root, target);

        System.out.println(exists);
    }

    boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            // If the root is empty,
            // return false
            return false;
        }

        // Initialize two BSTIterators for
        // traversal in different directions

        // Left iterator
        BSTIterator l = new BSTIterator(root, false);
        // Right iterator
        BSTIterator r = new BSTIterator(root, true);

        // Get the next element from the left iterator
        int i = l.next();
        // Get the next element from the right iterator
        int j = r.next();

        // Loop to find the pair with the given sum
        while (i < j) {
            if (i + j == k) {
                // If the sum is found,
                // return true
                return true;
            } else if (i + j < k) {
                // Move to the next element
                // from the left iterator
                i = l.next();
            } else {
                // Move to the next element
                // from the right iterator
                j = r.next();
            }
        }
        // If no pair found, return false
        return false;
    }



}



// BSTIterator class for iterating through BST nodes
class BSTIterator {
    // Stack to store nodes
    private Stack<TreeNode> myStack;
    // Flag to determine traversal direction
    private boolean reverse;

    // Constructor initializing BSTIterator with the
    // root of the BST and traversal direction
    BSTIterator(TreeNode root, boolean isReverse) {
        myStack = new Stack<>();
        reverse = isReverse;
        // Initialize the stack with nodes
        pushAll(root);
    }

    // Checks if there exists a
    // next element in the BST
    boolean hasNext() {
        // Returns true if the
        // stack is not empty
        return !myStack.empty();
    }

    // Retrieves the next smallest element
    // ie. inorder successor in the BST
    int next() {
        // Retrieve the top node from the stack
        TreeNode tmpNode = myStack.pop();
        if (!reverse) {
            // If not in reverse mode,
            // add nodes from the right subtree
            pushAll(tmpNode.right);
        } else {
            // If in reverse mode,
            // add nodes from the left subtree
            pushAll(tmpNode.left);
        }
        // Return the value of the retrieved node
        return tmpNode.val;
    }

    // Helper function to push nodes into
    // the stack in a specific order
    private void pushAll(TreeNode node) {
        while (node != null) {
            // Push the node onto the stack
            myStack.push(node);
            if (reverse) {
                // Move to the right child
                // if in reverse mode
                node = node.right;
            } else {
                // Move to the left child
                // if not in reverse mode
                node = node.left;
            }
        }
    }
}

