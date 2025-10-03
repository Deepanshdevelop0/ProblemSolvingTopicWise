package Trees.BinarySearchTrees.Problems;

import Trees.BinaryTrees.Utility.TreeNode;
import Trees.BinaryTrees.Utility.TreeUtils;

import java.util.HashSet;
import java.util.Set;

public class BST_TwoSum {

    public static void main(String[] args) {

        TreeNode root = TreeUtils.buildTree(new Integer[]{0,-1,2,-3,null,null,4});

        TreeUtils.printTree(root);

        System.out.println(findTarget(root, -4));
    }

    public static boolean findTarget(TreeNode root, int k) {

        Set<Integer> set = new HashSet<>();

        return getPreOrderOptimal(root, k, set);

    }

    public static boolean getPreOrderOptimal(TreeNode root, int k, Set<Integer> set) {

        if (root == null) {
            return false;
        }

        if (set.contains(k-root.val)) {
            return true;
        }

        set.add(root.val);

        return getPreOrderOptimal(root.left, k, set) || getPreOrderOptimal(root.right, k, set);
    }


    public static boolean findTargetLessOptimal(TreeNode root, int k) {

        Set<Integer> set = new HashSet<>();

        getPreOrder(root, set);

        for (Integer i : set) {
            // if set contains diff of k and set element, and if the element is half of k (k=12, i=6) it may detect itself again instead of another element (k-1)
            if (set.contains(k-i) && (i != k-i)) {
                return true;
            }
        }

        return false;
    }

    public static void getPreOrder(TreeNode root, Set<Integer> set) {

        if (root == null) {
            return;
        }

        set.add(root.val);

        getPreOrder(root.left, set);

        getPreOrder(root.right, set);

    }



}
