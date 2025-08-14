package Trees.BinaryTrees.Traversal.BFS;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class DepthOrHeightOfTheTree {


/*
BFS (queue / level order)

TC: O(n) – visit each node exactly once

SC: O(w) – where w = maximum width of the tree
Worst case O(n) for a completely full level at the bottom
*/

/*
DFS (recursion)

TC: O(n) – visit each node exactly once

SC: O(h) – where h = height of the tree (recursion stack space)
Worst case O(n) for a skewed tree, O(log n) for balanced tree
*/


    static int ans;
    public static void main(String[] args) {
        // Creating a sample binary tree
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        TreeNode seven = new TreeNode(7);
        TreeNode eight = new TreeNode(8);

        one.left = two;
        one.right = three;

        two.left = four;
        two.right = five;

        three.left = six;
        three.right = seven;

        five.left = eight;


        // Getting preorder traversal
        System.out.println("height of the tree: " + maxDepth(one));
    }

    public static int maxDepth(TreeNode root) {
        ans = 0;
        maxDepthDfs(root,1);
        return ans;
    }


    public static void maxDepthDfs(TreeNode root, int level) {
        if (root == null) return;
        ans = Math.max(ans, level);
        maxDepthDfs(root.left, level+1);
        maxDepthDfs(root.right, level+1);
    }

    public static int maxDepthBfs(TreeNode root) {

        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();

        queue.add(root);

        int level = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            // increment level on adding a complete level as below for loop
            level++;

            for (int i = 0; i < size; i++) {

                TreeNode currNode = queue.remove();

                if (currNode.left != null) {
                    queue.add(currNode.left);
                }

                if (currNode.right != null) {
                    queue.add(currNode.right);
                }

            }

        }

        return level;
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
