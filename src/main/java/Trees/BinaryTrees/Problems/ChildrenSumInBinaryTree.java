package Trees.BinaryTrees.Problems;

import Trees.BinaryTrees.Utility.TreeNode;
import org.w3c.dom.Node;

public class ChildrenSumInBinaryTree {

/*

DFS

TC : O(n), where n is the number of nodes

SC : O(h), recursive stack space, O(h) height of tree in average case, O(n) in worst case

*/

    public static void main(String[] args) {
        TreeNode root = new TreeNode(35);
        root.left = new TreeNode(20);
        root.right = new TreeNode(15);

        root.left.left = new TreeNode(15);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);

        TreeNode root1 = new TreeNode(10);
        root1.left = new TreeNode(5);
        root1.right = new TreeNode(4);

        root1.right.left = new TreeNode(1);


        System.out.println(isSumProperty(root));

    }

    public static boolean isSumProperty(TreeNode root) {
        //  code here
        return isSumPropertyValid(root) != -1;
    }

    public static long isSumPropertyValid(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return root.val;
        }

        long left = isSumPropertyValid(root.left);

        if (left == -1) return -1;


        long right = isSumPropertyValid(root.right);

        if (right == -1) return -1;

        return root.val == left + right ? root.val : -1;
    }

}
