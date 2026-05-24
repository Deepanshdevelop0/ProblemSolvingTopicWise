package LeetCode.Trees.BinaryTrees.ViewProblems;

import LeetCode.Trees.BinaryTrees.Utility.TreeNode;
import LeetCode.Trees.BinaryTrees.Utility.TreeUtils;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Right_View_of_Binary_Tree {

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1,2,3,null,5,null,4};
        Integer[] arr1 = new Integer[]{1,2,3,null,5,6,null,4};
        TreeNode root = TreeUtils.buildTree(arr);
        TreeUtils.printTree(root);

        rightSideView(root).forEach(i -> {
            System.out.print(i + ", ");
        });
    }

    public static List<Integer> rightSideViewBFS(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if (root == null) return res;

        Queue<TreeNode> queue = new ArrayDeque<>();

        queue.add(root);

        while (!queue.isEmpty()) {

            int size = queue.size();
            TreeNode curr = new TreeNode(0);

            for (int i = 0; i < size; i++) {

                curr = queue.poll();

                if (curr.left != null) {
                    queue.add(curr.left);
                }

                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }

            res.add(curr.val);
        }

        return res;
    }


    public static List<Integer> rightSideView(TreeNode root) {

        List<Integer> res = new ArrayList<>();

        if (root == null) return res;

        rightSideViewDFS(root, res, 0);

        return res;
    }

    public static void rightSideViewDFS(TreeNode curr, List<Integer> res, int depth) {

        if (curr == null) return;

        if (res.size() == depth) {
            res.add(curr.val);
        }

        rightSideViewDFS(curr.right, res, depth+1);
        rightSideViewDFS(curr.left, res, depth+1);
    }

}
