package Trees.BinarySearchTrees.Problems;

import Trees.BinaryTrees.Utility.TreeNode;
import Trees.BinaryTrees.Utility.TreeUtils;

import java.util.PriorityQueue;
import java.util.TreeSet;

public class kthSmallestElement {

/*

Optimal Inorder Traversal (kthSmallestMostOptimal)

TC : O(h + k)
i. The time is determined by traversing down the tree's height (h) to find the starting point and then visiting k nodes in the correct order.
ii. The traversal stops as soon as the kth element is found.

SC : O(h)
i. recursive stack space, height of the tree O(h) ~ O(log n)

===========================================================

Inorder Traversal (kthSmallestLessOptimal)

TC : O(n log n)
i. The approach traverses the entire tree (N nodes) in the worst case and stores each value in a TreeSet.
ii. Adding each element to a TreeSet takes O(log N) time.

SC : O(n)
i. if k is a greater number it may store n tree values
In the worst-case scenario, the TreeSet will store all N elements of the tree.

*/

    public static void main(String[] args) {

        TreeNode root = TreeUtils.buildTree(new Integer[]{5,3,6,2,4,null,null,1});

        TreeUtils.printTree(root);

        System.out.println(new kthSmallestElement().kthSmallestMostOptimal(root, 3));

    }

    int count = 0, res = -1;
    public int kthSmallestMostOptimal(TreeNode root, int k) {
        inorderBST(root, k);
        return res;
    }


    public void inorderBST(TreeNode root, int k) {

        if (root == null || res != -1) {
            return;
        }

        inorderBST(root.left, k);

        count++;

        if (count == k) {
            res = root.val;
            return;
        }

        inorderBST(root.right, k);
    }

    public static int kthSmallestLessOptimal(TreeNode root, int k) {

        TreeSet<Integer> set = new TreeSet<>();
        inorderBST(root, set, k);

        int i = 1;
        for (Integer e : set) {
            if (i == k) {
                return e;
            }
            i++;
        }

        return -1;
    }


    public static void inorderBST(TreeNode root, TreeSet<Integer> set, int k) {
        if (root == null) {
            return;
        }

        if (set.size() >= k) {
            return;
        }

        inorderBST(root.left, set, k);

        set.add(root.val);

        inorderBST(root.right, set, k);

    }


}
