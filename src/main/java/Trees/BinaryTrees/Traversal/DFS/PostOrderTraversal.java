package Trees.BinaryTrees.Traversal.DFS;

import java.util.ArrayList;
import java.util.List;

public class PostOrderTraversal {

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
        List<Integer> result = postorderTraversal(one);

        // Displaying the preorder traversal result
        System.out.print("postOrder Traversal: ");
        // Output each value in the
        // preorder traversal result
        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        postorderTraversalDfs(root, res);

        return res;

    }

    public static void postorderTraversalDfs(TreeNode root, List<Integer> res) {


        if (root.left != null) {
            postorderTraversalDfs(root.left, res);
        }

        if (root.right != null) {
            postorderTraversalDfs(root.right, res);
        }

        res.add(root.val);

    }


    static class TreeNode {
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
