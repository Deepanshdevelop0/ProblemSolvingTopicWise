package Trees.BinaryTrees.ViewProblems;

import Trees.BinaryTrees.Utility.TreeNode;
import Trees.BinaryTrees.Utility.TreeUtils;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class RightViewOfBinaryTree {

/*

BFS Solution

TC : O(N) : no of nodes

SC : O(W) + O(log N) ~ O(N)
i. Queue space takes O(W), in worst case it may take O(N)
ii. Result List takes O(H) = O(log N) for balanced trees, worst case may take O(N) for skewed trees

----------------------------------------------------------------------------------
DFS Solution

TC : O(N) : no of nodes

SC : O(H) + O(H) ~ O(H)
i. Recursive stack space O(H) = O(logN) for balanced trees, in worst case O(N) for skewed trees
ii. Result list holds one element per level = O(H), in worst case O(N) for skewed trees

*/

    public static void main(String[] args) {

        Integer[] arr = new Integer[]{1,2,3,null,5,null,4};
        Integer[] arr1 = new Integer[]{1,2,3,null,5,6,null,4};
        TreeNode root = TreeUtils.buildTree(arr1);

        rightSideViewBFS(root).forEach(i -> {
            System.out.print(i + ", ");
        });
    }

    /* BFS Solution */
    public static List<Integer> rightSideViewBFS(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                TreeNode currNode = queue.peek();
                queue.remove();

                if (i == size-1) {
                    res.add(currNode.val);
                }

                if (currNode.left != null) {
                    queue.add(currNode.left);
                }

                if (currNode.right != null) {
                    queue.add(currNode.right);
                }
            }
        }

        return res;
    }

    /* DFS Solution */
    public static List<Integer> rightSideView(TreeNode root) {

        List<Integer> res = new ArrayList<>();

        rightSideViewDfs(root, res, 0);

        return res;
    }


    public static void rightSideViewDfs(TreeNode root, List<Integer> res, int depth) {

        if (root == null) {
            return;
        }

        if (res.size() == depth) {
            res.add(root.val);
        }

        rightSideViewDfs(root.right, res, depth+1);
        rightSideViewDfs(root.left, res, depth+1);

    }





}
