package LeetCode.Trees.BinaryTrees.Problems;

import LeetCode.Trees.BinaryTrees.Utility.TreeNode;
import LeetCode.Trees.BinaryTrees.Utility.TreeUtils;

import java.util.ArrayList;
import java.util.List;

public class Symmetric_Tree {

/*

i. DFS Brute force

TC : O(N/2) + O(N/2) + O(N/2) ~ O(1.5N) ~ O(N)

1. leftTraversal can have O(n) in worst case in skewed tree or else O(n/2)
2. rightTraversal can have O(n) in worst case in skewed tree or else O(n/2)
3. left equals right takes O(n/2) for comparison

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


        TreeUtils.printTree(root);

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

    public static void leftTraversal(TreeNode curr, List<Integer> left) {
        if (curr == null) {
            left.add(null);
            return;
        }

        left.add(curr.val);

        leftTraversal(curr.left, left);
        leftTraversal(curr.right, left);
    }

    public static void rightTraversal(TreeNode curr, List<Integer> right) {
        if (curr == null) {
            right.add(null);
            return;
        }

        right.add(curr.val);

        rightTraversal(curr.right, right);
        rightTraversal(curr.left, right);

    }

    public static boolean isSymmetricOptimal(TreeNode root) {

        return isSymmetricOptimalDFS(root.left, root.right);
    }

    public static boolean isSymmetricOptimalDFS(TreeNode root, TreeNode root1) {

        if (root == null || root1 == null) {
            return root == root1;
        }

        boolean res = isSymmetricOptimalDFS(root.left, root1.right);

        res = res && isSymmetricOptimalDFS(root.right, root1.left);

        return root.val == root1.val & res;
    }


}
