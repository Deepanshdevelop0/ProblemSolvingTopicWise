package Trees.BinarySearchTrees.Problems;

import Trees.BinaryTrees.Utility.TreeNode;
import Trees.BinaryTrees.Utility.TreeUtils;

public class searchInBST {


/*

Search in a Binary Search Tree

Approach 1: DFS Helper (searchBSTDFS)
    - TC: O(h) → O(log n) for balanced, O(n) for skewed
    - SC: O(h) recursion stack

Approach 2: Direct Recursive
    - TC: O(h) → O(log n) for balanced, O(n) for skewed
    - SC: O(h) recursion stack (less boilerplate than Approach 1)

Approach 3: Iterative (Most Optimal)
    - TC: O(h) → O(log n) for balanced, O(n) for skewed
    - SC: O(1), no recursion stack

Summary:
    All three approaches have the same time complexity O(h).
    The iterative approach is the most space-efficient (O(1)).

*/

    public static void main(String[] args) {
        TreeNode root = TreeUtils.buildTree(new Integer[]{4,2,7,1,3});

        TreeNode target = searchBSTMostOptimal(root, 5);

        System.out.println(target.val);

    }

    /*--------------------------- Approach 3 -------------------------------*/
    public static TreeNode searchBSTMostOptimal(TreeNode root, int val) {
        while (root != null && root.val != val) {
            root = (val < root.val) ? root.left : root.right;
        }
        return root;
    }



    /*--------------------------- Approach 2 -------------------------------*/

    public static TreeNode searchBSTMoreOptimal(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }

        if (val < root.val) {
            return searchBSTMoreOptimal(root.left, val);
        }
        else {
            return searchBSTMoreOptimal(root.right, val);
        }
    }



    /*--------------------------- Approach 1 -------------------------------*/

    public static TreeNode searchBSTLessOptimal(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }

        TreeNode target = searchBSTDFS(root, val);

        return target;
    }

    public static TreeNode searchBSTDFS(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        if (root.val == val) {
            return root;
        }

        if (val < root.val && root.left != null) {
            return searchBSTDFS(root.left, val);
        }

        if (val > root.val && root.right != null) {
            return searchBSTDFS(root.right, val);
        }

        return null;
    }

}
