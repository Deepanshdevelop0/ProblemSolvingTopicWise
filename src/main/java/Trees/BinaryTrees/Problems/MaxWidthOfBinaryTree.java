package Trees.BinaryTrees.Traversal.Problems;

import java.util.ArrayDeque;
import java.util.Queue;

public class MaxWidthOfBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        // Level 1
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);

        // Level 2
        root.left.left = new TreeNode(5);
        // root.left.right = null; // skipped because array has null
        // root.right.left = null;
        root.right.right = new TreeNode(9);

        // Level 3
        root.left.left.left = new TreeNode(6);
        // root.left.left.right = null;
        root.left.left.right = new TreeNode(7);

        System.out.println(widthOfBinaryTree(root));

    }

    public static int widthOfBinaryTree(TreeNode root) {

        record Pair(TreeNode root, int level){};
        Queue<Pair> queue = new ArrayDeque<>();

        queue.add(new Pair(root, 0));

        int maxWidth = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            int first = 0, last = 0, nCount = 0;

            for (int i = 0; i < size; i++) {

                TreeNode currNode = queue.peek().root;
                int level = queue.peek().level;
                queue.remove();

                /* add for left and null for no child */
                if (currNode.left != null) queue.add(new Pair(currNode.left, level+1));
                else  queue.add(new Pair(new TreeNode(-200), level+1));

                /* add for left and null for no child */
                if (currNode.right != null) queue.add(new Pair(currNode.right, level+1));
                else  queue.add(new Pair(new TreeNode(-200), level+1));

                /* calculate the width */
                if (currNode.val != -200) {
                    if (first == 0) first++;
                    last = nCount + 1;
                }

                if (first > 0) {
                    nCount++;
                }

            }

            if (first > 0 && last > 0) {
                maxWidth = Math.max(maxWidth, nCount);
            }

        }

        return maxWidth;
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
