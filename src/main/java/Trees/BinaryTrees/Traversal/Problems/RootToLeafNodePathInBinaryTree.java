package Trees.BinaryTrees.Traversal.Problems;

import java.util.ArrayList;

public class RootToLeafNodePathInBinaryTree {


/*

DFS Approach

TC : O(N) + O(H * L) = O(N + H*L) ~ O(NlogN)
i. No of nodes
ii. max depth x no of leaves

SC : O(L*H) + O(H) = O(N * L*H) ~ O(NlogN)

i. Result storage res = number of paths (L) × length of each path (H)
ii. No of nodes in recursive stack O(H), in worst case O(N) for skewed tree

*/

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        Paths(root).forEach(i -> {
            System.out.print(i + ", ");
        });

    }


    public static ArrayList<ArrayList<Integer>> Paths(TreeNode root) {

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        getPathsDfs(root, new ArrayList<>(), res);

        return res;

    }

    public static void getPathsDfs(TreeNode root, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> res) {

        if (root == null) {
            return;
        }

        path.add(root.data);

        getPathsDfs(root.left, path, res);
        getPathsDfs(root.right, path, res);

        if (root.left == null && root.right == null) {
            res.add(new ArrayList<>(path));
        }

        path.remove(path.size() - 1);

    }




    private static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int data) {
            this.data = data;
        }

        TreeNode(int data, TreeNode left, TreeNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}
