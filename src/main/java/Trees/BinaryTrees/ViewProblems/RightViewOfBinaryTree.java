package Trees.BinaryTrees.ViewProblems;

import Trees.BinaryTrees.Problems.verticalTraversalOfBinaryTree;

import java.util.ArrayList;
import java.util.List;

public class RightViewOfBinaryTree {

    public static void main(String[] args) {

    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if (root == null) {
            return res;
        }


        return res;
    }


    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
