package Trees.BinarySearchTrees.Problems;

import Trees.BinaryTrees.Utility.TreeNode;
import Trees.BinaryTrees.Utility.TreeUtils;

import java.util.HashSet;
import java.util.Set;

public class BST_TwoSum_V2 {

    public static void main(String[] args) {
        // Sample binary search tree: 7 3 15 -1 -1 9 20
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);

        TreeUtils.printTree(root);

        test_bst_twosum testBstTwosum = new test_bst_twosum();

        boolean exists = testBstTwosum.findTarget(root, 22);

        System.out.println(exists);
    }

    boolean findTarget(TreeNode root, int k) {

        return false;
    }



}
