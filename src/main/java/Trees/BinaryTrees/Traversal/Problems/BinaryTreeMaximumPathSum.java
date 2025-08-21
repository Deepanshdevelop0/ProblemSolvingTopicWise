package Trees.BinaryTrees.Traversal.Problems;

public class BinaryTreeMaximumPathSum {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(maxPathSum(root));

    }

    public static int maxPathSum(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int[] maxi = new int[]{Integer.MIN_VALUE};

        findMaxPathSumDfs(root, maxi);

        return maxi[0];

    }

    public static int maxPathSumDfs(TreeNode root, int[] maxi) {

        if (root == null) {
            return 0;
        }

        int leftSum = maxPathSumDfs(root.left, maxi);
        int rightSum = maxPathSumDfs(root.right, maxi);

        maxi[0] = Math.max(maxi[0], leftSum + rightSum + root.val);

        return root.val + Math.max(leftSum, rightSum);

    }

    public static int findMaxPathSumDfs(TreeNode root, int[] maxi) {

        if (root == null) {
            return 0;
        }

        // Calculate the maximum path sum
        // for the left and right subtrees
        int leftMaxPath = Math.max(0, findMaxPathSumDfs(root.left, maxi));
        int rightMaxPath = Math.max(0, findMaxPathSumDfs(root.right, maxi));

        // Update the overall maximum
        // path sum including the current node
        maxi[0] = Math.max(maxi[0], leftMaxPath + rightMaxPath + root.val);

        // Return the maximum sum considering
        // only one branch (either left or right)
        // along with the current node
        return Math.max(leftMaxPath, rightMaxPath) + root.val;

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
