package Trees.BinaryTrees.Problems;

import Trees.BinaryTrees.Utility.TreeNode;
import Trees.BinaryTrees.Utility.TreeUtils;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderInorderTraversal {

/*

DFS

TC : O(N) - N is the number of nodes

SC : O(N + N)
N is the number of nodes + aux stack space (recursive) O(N) in worst case skewed trees

*/

    public static void main(String[] args) {

        TreeUtils.printTree(buildTree(new int[]{1, 2, 4, 8, 3, 6, 7}, new int[]{2, 4, 8, 1, 6, 3, 7}));
        TreeUtils.printTree(buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7}));
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        TreeNode root = buildTreeDfs(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);

        return root;
    }

    public static TreeNode buildTreeDfs(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inMap) {

        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);

        int inRootIndx = inMap.get(root.val);
        int numsLeft = inRootIndx - inStart;

        root.left = buildTreeDfs(preorder, preStart + 1, preStart + numsLeft,
                inorder, inStart, inRootIndx - 1, inMap);

        root.right = buildTreeDfs(preorder, preStart + numsLeft + 1, preEnd,
                inorder, inRootIndx + 1, inEnd, inMap);

        return root;
    }


}
