package LeetCode.Trees.BinaryTrees.Traversal.DFS;

import java.util.ArrayList;
import java.util.List;

public class InOrderTraversal {


/*

DFS approach

TC : O(N) : num of nodes
SC : O(N) : num of nodes in result list

*/

    public static void main(String[] args) {
        // Creating a sample binary tree
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        TreeNode seven = new TreeNode(7);

        one.left = two;
        one.right = three;

        two.left = four;
        two.right = five;

//        five.left = six;
//        five.right = seven;

        three.left = six;
        three.right = seven;


        // Getting preorder traversal
        List<Integer> result = inorderTraversal(one);

        // Displaying the preorder traversal result
        System.out.print("Inorder Traversal: ");
        // Output each value in the
        // preorder traversal result
        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        inorderTraversalDfs(root, res);

        return res;
    }

    public static void inorderTraversalDfs(TreeNode curr, List<Integer> res) {

        if (curr.left != null) {
            inorderTraversalDfs(curr.left, res);
        }

        res.add(curr.val);

        if (curr.right != null) {
            inorderTraversalDfs(curr.right, res);
        }

    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


}
