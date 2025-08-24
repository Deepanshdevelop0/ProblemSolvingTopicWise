package Trees.BinaryTrees.Problems;

import Trees.BinaryTrees.Traversal.BFS.LevelOrderTraversal;
import org.w3c.dom.Node;

import java.util.*;

public class ZigzagLevelOrder {

/*

i. zigzagLevelOrderOptimal :

DFS

TC : O(N) : no of nodes

SC : O(N + N + W) ~ O(N)
1. result List of List size
2. Size of queuein worst case
3. subResult list max width of level

Extra work : None


ii. zigzagLevelOrder :

DFS

TC : O(N) : no of nodes

SC : O(N + N + W) ~ O(N)
1. result List of List size
2. Size of queue in worst case
3. subResult list max width of level

Extra work : Reversal per odd level

*/
    public static void main(String[] args) {
        // Creating a sample binary tree
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        TreeNode seven = new TreeNode(7);

        one.left = two;
        one.right = three;

        two.left = four;
        two.right = five;

//        five.left = six;
//        five.right = seven;

        three.left = six;
        three.right = seven;


        // Getting preorder traversal
        List<List<Integer>> result = zigzagLevelOrderOptimal(one);

        // Displaying the preorder traversal result
        System.out.println("levelOrder Traversal: ");
        // Output each value in the
        // preorder traversal result
        for (int i = 0; i < result.size(); i++) {
            System.out.print(i + " : ");
            result.get(i).forEach(j -> System.out.print(j + ", "));
            System.out.println();
        }
        System.out.println();
    }

    /* adding into list (from front and last) as per boolean flag changed on each level */
    public static List<List<Integer>> zigzagLevelOrderOptimal(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        boolean leftToRight = true;

        while (!queue.isEmpty()) {

            int size = queue.size();

            /* initialize list with 0 on indices */
            List<Integer> subRes = new ArrayList<>(Collections.nCopies(size, 0));

            for (int i = 0; i < size; i++) {

                TreeNode curr = queue.peek();
                queue.remove();

                /* start from 0 to size-1 index on leftToRight true (even levels - 0,2,4) and from size-1 to 0 on leftToRight false (odd levels - 1,3,5) */
                int index = leftToRight ? i : (size - i - 1);

                /* add to subRes to futher in res list */
                subRes.set(index, curr.val);

                if (curr.left != null) {
                    queue.add(curr.left);
                }

                if (curr.right != null) {
                    queue.add(curr.right);
                }

            }

            leftToRight = !leftToRight;
            res.add(subRes);

        }

        return res;
    }

    /* Reversing on odd levels of tree */
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        int level = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            ArrayList<Integer> subRes = new ArrayList<>();

            for (int i = 0; i < size; i++) {

                TreeNode curr = queue.peek();
                queue.remove();

                if (curr.left != null) {
                    queue.add(curr.left);
                }

                if (curr.right != null) {
                    queue.add(curr.right);
                }

                /* add to subRes to futher in res list */
                subRes.add(curr.val);
            }

            if (level % 2 != 0) {
                Collections.reverse(subRes);
            }

            res.add(subRes);
            level++; // increase level to track even or add level for reversing
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
