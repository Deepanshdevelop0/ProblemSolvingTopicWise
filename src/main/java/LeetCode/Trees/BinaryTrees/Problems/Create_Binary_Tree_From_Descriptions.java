package LeetCode.Trees.BinaryTrees.Problems;

import LeetCode.Trees.BinaryTrees.Utility.TreeNode;
import LeetCode.Trees.BinaryTrees.Utility.TreeUtils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Create_Binary_Tree_From_Descriptions {

    public static void main(String[] args) {

        Create_Binary_Tree_From_Descriptions classObj = new Create_Binary_Tree_From_Descriptions();

        int[][] descriptions = new int[][]{{20, 15, 1}, {20, 17, 0}, {50, 20, 1}, {50, 80, 0}, {80, 19, 1}};

        TreeNode root = classObj.createBinaryTree(descriptions);
        TreeUtils.printTree(root);
    }

    Map<Integer, TreeNode> map = new HashMap<>();
    Set<Integer> childSet = new HashSet<>();

    public TreeNode createBinaryTree(int[][] descriptions) {

        for (int[] desc : descriptions) {
            int parent = desc[0];
            int child = desc[1];
            boolean isLeft = desc[2] == 1;

            TreeNode currNode = map.getOrDefault(parent, new TreeNode(parent, null, null));
            TreeNode childNode = map.getOrDefault(child, new TreeNode(child, null, null));

            if (isLeft) {
                currNode.left = childNode;
            }
            else {
                currNode.right = childNode;
            }

            map.put(parent, currNode);
            map.put(child, childNode);

            childSet.add(child);
        }

        TreeNode root = null;

        for (Integer parent : map.keySet()) {
            if (!childSet.contains(parent)) {
                root = map.get(parent);
            }
        }

        return root;
    }


}
