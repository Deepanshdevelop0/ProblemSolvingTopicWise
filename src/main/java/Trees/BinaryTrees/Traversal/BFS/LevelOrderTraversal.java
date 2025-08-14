package Trees.BinaryTrees.Traversal.BFS;

import java.util.*;

public class LevelOrderTraversal {

/*

BFS approach

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
        List<List<Integer>> result = levelOrder(one);

        // Displaying the preorder traversal result
        System.out.println("levelOrder Traversal: ");
        // Output each value in the
        // preorder traversal result
        for (int i = 0; i < result.size(); i++) {
            System.out.print(i + " : ");
            result.get(i).forEach(j -> System.out.print(j + ", "));
            System.out.println();
        }
        System.out.println();
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();

        queue.add(root);

        while (!queue.isEmpty()) {

            int size = queue.size();

            List<Integer> subRes = new ArrayList<>();

            for (int i = 0; i < size; i++) {

                TreeNode currNode = queue.poll();

                subRes.add(currNode.val);

                if (currNode.left != null) {
                    queue.add(currNode.left);
                }

                if (currNode.right != null) {
                    queue.add(currNode.right);
                }

            }

            res.add(subRes);
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
