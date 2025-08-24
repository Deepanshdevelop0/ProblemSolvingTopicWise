package Trees.BinaryTrees.Problems;

public class IsSameTree {


    /*

    * Optimal DFS : PostOrder Traversal

    TC : O(N) : no of nodes

    SC : O(H) : recursive stack space of height of Binary Tree


    * Brute Force DFS

    TC : O(N x N) ~ O(N2) : We cal height of each node and traverse to depth

    SC : O(N) : no of nodes, not optimal than O(H)

    */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.right = new TreeNode(6);
        root.left.right.right.right = new TreeNode(7);

        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        root1.left.right.right = new TreeNode(6);
        root1.left.right.right.right = new TreeNode(9);

//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//
//        TreeNode root1 = new TreeNode(1);
//        root1.right = new TreeNode(2);

        // Checking if the tree is balanced
        if (isSameTree(root, root1)) {
            System.out.println("The tree is balanced.");
        } else {
            System.out.println("The tree is not balanced.");
        }
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null) {
            return true;
        }

//        return isSameTreeDfs(p, q, true);

        return isSameTreeDfsOptimized(p, q);
    }

    public static boolean isSameTreeDfs(TreeNode p, TreeNode q, boolean res) {

        if (!res) {
            return res;
        }

        if (p == null && q == null) {
            return res;
        }

        if (p == null || q == null || p.val != q.val) {
            return false;
        }

        res = isSameTreeDfs(p.left, q.left, res);

        res = isSameTreeDfs(p.right, q.right, res);

        return res;
    }

    public static boolean isSameTreeDfsOptimized(TreeNode p, TreeNode q) {

        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null || p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
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
