package LeetCode.Trees.BinarySearchTrees.Problems;

import LeetCode.Trees.BinaryTrees.Utility.TreeNode;
import LeetCode.Trees.BinaryTrees.Utility.TreeUtils;

import java.util.ArrayList;
import java.util.List;

public class Kth_Smallest_Element_in_a_BST {



/*

Optimal Inorder Traversal using Counter (kthSmallestOptimal)

TC : O(h + k)
i. We traverse down the left spine of the tree's height (h) to reach the smallest element.
ii. We then visit exactly k nodes in ascending order, stopping the traversal immediately once our counter reaches k.
iii. Worst case is O(N) for a heavily right-skewed tree where k is the last element.

SC : O(h)
i. We use O(1) auxiliary variables (count and res), so space is purely determined by the recursive call stack.
ii. The recursion depth goes up to the height of the tree, which is O(log N) for a balanced tree and O(N) for a skewed tree.

===========================================================

Inorder Traversal using List (kthSmallest)

TC : O(h + k)
i. Similar to the optimal approach, it takes O(h) to reach the starting node and processes nodes until k elements are found.
ii. Adding elements to an ArrayList takes O(1) time per element.
iii. Worst case remains O(N) for skewed trees.

SC : O(h + k)
i. The recursive call stack takes O(h) space.
ii. The List explicitly stores up to k elements, taking O(k) additional space.
iii. In the worst-case scenario (like returning the Nth smallest element in a skewed tree), this takes O(N) space.

*/


    public static void main(String[] args) {
        TreeNode root = TreeUtils.buildTree(new Integer[]{5,3,6,2,4,null,null,1});

        TreeUtils.printTree(root);

        System.out.println(new Kth_Smallest_Element_in_a_BST().kthSmallestOptimal(root, 3));
    }


    int count = 0, res = -1;

    public int kthSmallestOptimal(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }

        inorderBSTOptimal(root, k);

        return res;
    }


    public void inorderBSTOptimal(TreeNode root, int k) {
        if (root == null) return;

        inorderBSTOptimal(root.left, k);

        if (count >= k) return;

        count++;
        if (count == k) {
            res = root.val;
            return;
        }

        inorderBSTOptimal(root.right, k);

    }


    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }

        List<Integer> res = new ArrayList<>();

        inorderBST(root, res, k);

        return res.get(k-1);
    }

    public void inorderBST(TreeNode root, List<Integer> res, int k) {
        if (root == null) return;
        if (res.size() >= k) return;

        inorderBST(root.left, res, k);

        if (res.size() >= k) return;

        res.add(root.val);

        inorderBST(root.right, res, k);

    }


}
