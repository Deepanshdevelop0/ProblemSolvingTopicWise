package Trees.BinaryTrees.Traversal.DFS;

import org.w3c.dom.Node;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class PreOrderTraversal {


    public static void main(String[] args) {
        // Creating a sample binary tree
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        TreeNode seven = new TreeNode(7);
        TreeNode eight = new TreeNode(8);
        TreeNode nine = new TreeNode(9);

        one.left = two;
        one.right = three;

        two.left = four;
        two.right = five;

        /*four.left = null;
        four.right = null;*/

        five.left = six;
        five.right = seven;

//        three.left = null;
        three.right = eight;

        eight.left = nine;


        // Getting preorder traversal
        List<Integer> result = preorderTraversal(one);

        // Displaying the preorder traversal result
        System.out.print("Preorder Traversal: ");
        // Output each value in the
        // preorder traversal result
        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        preorderTraversalDfs(root, res);

        return res;

    }

    public static void preorderTraversalDfs(TreeNode root, List<Integer> res) {

        res.add(root.val);

        if (root.left != null) {
            preorderTraversalDfs(root.left, res);
        }

        if (root.right != null) {
            preorderTraversalDfs(root.right, res);
        }

    }


    static public class TreeNode {
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
