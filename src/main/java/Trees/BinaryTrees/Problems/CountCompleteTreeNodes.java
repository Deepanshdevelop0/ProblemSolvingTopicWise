package Trees.BinaryTrees.Problems;

import Trees.BinaryTrees.Utility.TreeNode;
import Trees.BinaryTrees.Utility.TreeUtils;
import com.sun.source.tree.Tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class CountCompleteTreeNodes {


/*

BFS : level order traverse

TC : O(N) : no of nodes

SC : O(W) : queue size

----------------------------------------------------------------------------

DFS

TC : O(N) : no of nodes

SC : O(H) : max height of tree, in worst case O(N) for skewed trees

*/

    public static void main(String[] args) {
        Integer[] nodes = new Integer[]{1,2,3,4,5,6};
        Integer[] nodes1 = new Integer[]{1,2,3,4,5,6,7};
        TreeNode root = TreeUtils.buildTree(nodes1);

        TreeUtils.printTree(root);

        System.out.println(countNodes(root));
    }

    public static int countNodesBfs(TreeNode root) {

        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        int count = 0;

        while (!queue.isEmpty()) {

            TreeNode currNode = queue.peek();
            queue.remove();

            count++;

            if (currNode.left != null) {
                queue.add(currNode.left);
            }

            if (currNode.right != null) {
                queue.add((currNode.right));
            }

        }

        return count;
    }

    public static int countNodes(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int left = countNodes(root.left);
        int right = countNodes(root.right);

        return 1 + left + right;
    }

}
