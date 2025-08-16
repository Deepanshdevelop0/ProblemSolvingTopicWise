package Trees.BinaryTrees.Traversal.Problems;

public class BalancedBinaryTree {


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

        // Creating an instance of the Solution class

        // Checking if the tree is balanced
        if (isBalancedOptimizedIII(root)) {
            System.out.println("The tree is balanced.");
        } else {
            System.out.println("The tree is not balanced.");
        }
    }

    public static boolean isBalancedOptimizedIII(TreeNode root) {
        if (root == null) {
            return true;
        }

        return heightDfsOptimizedIII(root) != -1;
    }

    public static int heightDfsOptimizedIII(TreeNode curr) {

        if (curr == null) return 0;

        int leftHeight = heightDfsOptimizedIII(curr.left);

        // If the left subtree is unbalanced,
        // propagate the unbalance status
        if (leftHeight == -1) {
            return -1;
        }

        int rightHeight = heightDfsOptimizedIII(curr.right);

        // If the right subtree is unbalanced,
        // propagate the unbalance status
        if (rightHeight == -1) {
            return -1;
        }

        // Check if the difference in height between
        // left and right subtrees is greater than 1
        // If it's greater, the tree is unbalanced,
        // return -1 to propagate the unbalance status
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        return 1 + Math.max(leftHeight, rightHeight);
    }


    public static boolean isBalancedII(TreeNode root) {
        if (root == null) {
            return true;
        }

        int left = heightDfsII(root.left);
        int right = heightDfsII(root.right);

        return (left == -1 || right == -1 || Math.abs(left - right) > 1)
                ? false : true;
    }

    public static int heightDfsII(TreeNode curr) {

        if (curr == null) return 0;

        int left = heightDfsII(curr.left);
        int right = heightDfsII(curr.right);

        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        }

        return 1 + Math.max(left, right);
    }



    public static boolean isBalancedBruteForce(TreeNode root) {

        if(root == null){
            return true;
        }

        int lh = heightBruteForceI(root.left);
        int rh = heightBruteForceI(root.right);

        return Math.abs(lh - rh) <= 1 && isBalancedBruteForce(root.left) && isBalancedBruteForce(root.right);
    }

    public static int heightBruteForceI(TreeNode root){
        if(root == null){
            return 0;
        }

        int lh = heightBruteForceI(root.left);
        int rh = heightBruteForceI(root.right);

        return 1 + Math.max(lh,rh);
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
