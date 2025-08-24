package Trees.BinaryTrees.Problems;

public class DiameterOfBinaryTree {


/*

DFS

TC : O(N) : no of nodes

SC : O(H) : recursive stack space of height of tree

*/
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.right = new TreeNode(6);
        root.left.right.right.right = new TreeNode(7);

        // Calculate the diameter of the binary tree
        int diameter = diameterOfBinaryTree(root);

        System.out.println("The diameter of the binary tree is: " + diameter);
    }

    static int diameter = 0;

    public static int diameterOfBinaryTree(TreeNode root) {

        if (root == null) {
            return 0;
        }

        getHeightDfs(root);

        return diameter;
    }

    public static int getHeightDfs(TreeNode curr) {

        if (curr == null) {
            return 0;
        }

        int left = getHeightDfs(curr.left);
        int right = getHeightDfs(curr.right);

        diameter = Math.max(diameter, left + right);

        return 1 + Math.max(left, right);
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
