package Trees.BinaryTrees.Traversal.DFS;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativePreorderTraversal {



/*

Iterative approach

TC : O(N) : num of nodes
SC : O(N) + O(N) ~ O(N) : stack size and num of nodes in result list

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

        three.left = six;
        three.right = seven;


        // Getting preorder traversal
        List<Integer> res = preorderTraversal(one);


        // Displaying the preorder traversal result
        System.out.print("Preorder Traversal: ");
        // Output each value in the
        // preorder traversal result
        for (int val : res) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();

        if (root == null) return null;

        Stack<TreeNode> st = new Stack<>();
        st.push(root);

        while (!st.isEmpty()) {

            TreeNode currNode = st.pop();

            res.add(currNode.val);

            if (currNode.right != null) {
                st.push(currNode.right);
            }

            if (currNode.left != null) {
                st.push(currNode.left);
            }

        }

        return res;
    }


    private static class TreeNode {
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
