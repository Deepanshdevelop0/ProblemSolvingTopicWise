package Trees.BinaryTrees.Problems;

public class BinaryTreeMaximumPathSum {


/*

DFS

TC : O(N) : no of nodes in the tree

SC : O(h), worst case O(N) in skewed tree
i. recursive stack space

*/

    public static void main(String[] args) {

        /* testcase 1 */
        TreeNode root1 = new TreeNode(-10);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);

        /* testcase 2 */
        TreeNode root = new TreeNode(-10);

        root.left = new TreeNode(-9);
        root.right = new TreeNode(-20);

        root.right.left = new TreeNode(-15);
        root.right.right = new TreeNode(7);

        root.right.left.left = new TreeNode(-3);
        root.right.left.right = new TreeNode(-2);

        root.right.right.left = new TreeNode(-30);
        root.right.right.right = new TreeNode(-1);


        /* testcase 3 */
        TreeNode root2 = new TreeNode(-3);

        root2.left = new TreeNode(-1);
        root2.right = new TreeNode(-2);


        System.out.println(maxPathSum(root1));

    }

    public static int maxPathSum(TreeNode root) {

        if (root == null) {
            return 0;
        }

        /* keep it min int value as if there is case [-3, -1, -2], then correct ans is -1 which can't be returned */
        int[] maxi = new int[]{Integer.MIN_VALUE};

        maxPathSumDfs(root, maxi);

        return maxi[0];

    }

/*
                   -10
                   /   \
                 -9    -20
                       /   \
                    -15     7
                   /   \    / \
                 -3   -2  -30  -1
*/

    public static int maxPathSumDfs(TreeNode root, int[] maxi) {

        if (root == null) {
            return 0;
        }

        // for the left and right subtrees, always keep left, rightsum >= 0
        // if in case any subtree return root.val + max(left + right) will return -ve val when root is negative
        // and when another positive val would be added in backtracking as max(maxi[0], leftSum + rightSum + root.val)
        // (if leftsum = -3 and rightsum = -2 and currval = 7), not 0 (-ve considered)
        // it would result in wrong ans (leftSum + rightSum + root.val) = 2
        // (if leftsum = 0 and rightsum = 0 and currval = 7), no -ve allowed
        // would correctly set the maxi[0] as 7
        int leftSum = Math.max(0, maxPathSumDfs(root.left, maxi));
        int rightSum = Math.max(0, maxPathSumDfs(root.right, maxi));


        // Update the overall maximum
        // path sum including the current node
        maxi[0] = Math.max(maxi[0], leftSum + rightSum + root.val);

        // Return the maximum sum considering only one branch (either left or right)
        // along with the current node
        return root.val + Math.max(leftSum, rightSum);

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
