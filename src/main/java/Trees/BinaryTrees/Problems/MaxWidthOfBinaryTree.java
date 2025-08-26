package Trees.BinaryTrees.Problems;

import Trees.BinaryTrees.Utility.TreeNode;
import Trees.BinaryTrees.Utility.TreeUtils;

import java.util.ArrayDeque;
import java.util.Queue;

public class MaxWidthOfBinaryTree {

/*

BFS

TC : O(N) : no of nodes

SC :  O(N)
i. queue space, would contain at most the complete level, width of level O(W)
for a complete binary tree last level can have upto N/2 nodes, worst case O(N)

*/


    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);

        // Level 1
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(2);

        // Level 2
        root1.left.left = new TreeNode(5);
        root1.right.right = new TreeNode(9);

        // Level 3
        root1.left.left.left = new TreeNode(6);
        // root1.left.left.right = null;
        root1.left.left.right = new TreeNode(7);

        System.out.println(widthOfBinaryTree(root1));

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(5);
        root.right.right = new TreeNode(9);

        root.left.left.left = new TreeNode(6);
        root.right.right.left = new TreeNode(7);

        System.out.println(widthOfBinaryTree(root));


        TreeNode root2 = TreeUtils.buildTree(new Integer[]{0,0,0,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null});

        System.out.println(widthOfBinaryTree(root2));

    }

    public static int widthOfBinaryTree(TreeNode root) {

        record Pair(TreeNode root, long index) {};
        Queue<Pair> queue = new ArrayDeque<>();

        queue.add(new Pair(root, 0));

        int maxWidth = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            long first = 0, last = 0;
            long minIndex = queue.peek().index;

            for (int i = 0; i < size; i++) {

                Pair curr = queue.poll();
                TreeNode currNode = curr.root;

                // to keep the start index as 0 and last as last - first node StartingIndx
                // this will ensure the first node of level as 0 and last as  first + the null between + last 1
                long currIndx = curr.index - minIndex;


                if (i == 0) first = currIndx;
                if (i == size - 1) last = currIndx;

                /* the childNode index = currIndx * 2 (left), currIndx * 2 + 1 (right),
                   level 2 : 2nd node's (indx = 1) left and right child :
                   (left : 1 * 2 = 2) and (right 1 * 2 + 1 = 3) on level 3 */

                if (currNode.left != null) {
                    queue.add(new Pair(currNode.left, currIndx * 2));
                }

                /* add for left and null for no child */
                if (currNode.right != null) {
                    queue.add(new Pair(currNode.right, currIndx * 2 + 1));
                }

            }

            maxWidth = Math.max(maxWidth, (int) (last - first) + 1);

        }

        return maxWidth;
    }

}
