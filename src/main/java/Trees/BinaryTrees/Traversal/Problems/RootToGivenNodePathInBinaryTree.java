package Trees.BinaryTrees.Traversal.Problems;

import java.util.ArrayList;

public class RootToGivenNodePathInBinaryTree {


/*

DFS Approach

TC : O(N) : No of nodes

SC : O(H) : No of nodes in recursive stack, (height of tree, worst case O(N))

*/

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        solve(root, 4).forEach(i -> {
            System.out.print(i + ", ");
        });

    }


    public static ArrayList<Integer> solve(TreeNode A, int B) {
        ArrayList<Integer> path = new ArrayList<>();

        getPathsDfs(A, path, B);

        return path;
    }

    public static boolean getPathsDfs(TreeNode root, ArrayList<Integer> path, int B) {

        if (root == null) {
            return false;
        }

        path.add(root.val);

        if (root.val == B) {
            return true;
        }

        /* if any of the path will reach value B, it will return true */
        if (getPathsDfs(root.left, path, B) || getPathsDfs(root.right, path, B)) {
            return true;
        }

        path.remove(path.size() - 1);

        return false;
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
