package Trees.BinaryTrees.Problems;

import Trees.BinaryTrees.Utility.TreeNode;
import Trees.BinaryTrees.Utility.TreeUtils;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPostorderInorderTraversal {

/*

DFS

TC : O(N) - N is the number of nodes

SC : O(N + N)
i. N is the number of nodes + aux stack space (recursive), O(N) in worst case skewed trees

*/

    public static void main(String[] args) {

        TreeUtils.printTree(buildTree(new int[]{2, 4, 8, 1, 6, 3, 7}, new int[]{8, 4, 2, 6, 7, 3, 1}));
//        TreeUtils.printTree(buildTree(new int[]{1, 2, 4, 8, 3, 6, 7}, new int[]{2, 4, 8, 1, 6, 3, 7}));
//        TreeUtils.printTree(buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7}));
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return buildTreeDfs(inorder,0, inorder.length - 1, postorder, postorder.length - 1, 0, map);

    }

    public static TreeNode buildTreeDfs(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart,  int postEnd, Map<Integer, Integer> inMap) {

        if (inStart > inEnd || postStart < postEnd) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[postStart]);

        int inRootIndx = inMap.get(root.val);
        int numsRight = inEnd - inRootIndx;

        root.right = buildTreeDfs(inorder, inRootIndx + 1, inEnd, postorder, postStart - 1, postStart - numsRight, inMap);
        root.left = buildTreeDfs(inorder, inStart, inRootIndx - 1, postorder, postStart - numsRight - 1, postEnd, inMap);

        return root;
    }

}
