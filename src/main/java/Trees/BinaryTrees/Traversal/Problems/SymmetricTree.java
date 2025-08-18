package Trees.BinaryTrees.Traversal.Problems;

import java.util.ArrayList;
import java.util.List;

public class SymmetricTree {

/*

i. DFS Brute force

TC : O(N) + O(N) + O(N) ~ O(N)

1. leftTraversal can have O(n) in worst case in skewed tree
2. rightTraversal can have O(n) in worst case in skewed tree
3. left equals right takes O(n) for comparison

SC : O(N) + O(N) ~ O(N)

1. for left and right lists (having all nodes and nulls)
2. for recursive stack with n nodes


ii. DFS Optimal

TC : O(N) : traversing no of nodes

SC : O(H) ~ O(log N)
1. recursive stack space, in worst case skewed tree O(N) can be there on either sides

*/

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        /*root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(3);*/

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);



        /*[1,2,2,3,4,4,3]*/
        if (isSymmetricOptimal(root)) {
            System.out.println("The tree is symmetric.");
        } else {
            System.out.println("The tree is not symmetric.");
        }

    }


    public static boolean isSymmetric(TreeNode root) {

        List<Integer> left = new ArrayList<>(), right = new ArrayList<>();

        leftTraversal(root.left, left);
        rightTraversal(root.right, right);

        return left.equals(right);
    }

    public static void leftTraversal(TreeNode root, List<Integer> left) {

        if (root == null) {
            left.add(null);
            return;
        }

        left.add(root.val);

        leftTraversal(root.left, left);

        leftTraversal(root.right, left);

    }

    public static void rightTraversal(TreeNode root, List<Integer> right) {
        if (root == null) {
            right.add(null);
            return;
        }

        right.add(root.val);

        rightTraversal(root.right, right);

        rightTraversal(root.left, right);

    }


    public static boolean isSymmetricOptimal(TreeNode root) {


        return isSymmetricOptimalDfs(root.left, root.right);
    }

    public static boolean isSymmetricOptimalDfs(TreeNode root, TreeNode root1) {

        if (root == null || root1 == null) {
            return root == root1;
        }

        return (root.val == root1.val &&
                isSymmetricOptimalDfs(root.left, root1.right) &&
                isSymmetricOptimalDfs(root.right, root1.left));
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
