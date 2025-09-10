package Trees.BinaryTrees.Traversal.DFS;

import Trees.BinaryTrees.Utility.TreeNode;
import Trees.BinaryTrees.Utility.TreeUtils;

import java.util.ArrayList;
import java.util.List;

public class MorrisInorderTraversal {

    public static void main(String[] args) {
        TreeNode root = TreeUtils.buildTree(new Integer[]{1,2,3,4,5,null,null,null ,null,null,6});

        inorderTraversal(root).forEach(i -> {
            System.out.print(i + ", ");
        });

    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        TreeNode curr = root;

        while (curr != null) {

            if (curr.left == null) {
                inorder.add(curr.val);
                curr = curr.right;
            } else {
                TreeNode prev = curr.left;

                while (prev.right != null && prev.right != curr) {
                    prev = prev.right;
                }

                if (prev.right == null) {
                    prev.right = curr;
                    curr = curr.left;
                } else {
                    prev.right = null;
                    inorder.add(curr.val);
                    curr = curr.right;
                }
            }
        }

        return inorder;
    }


}
