package Trees.BinaryTrees.Problems;

import Trees.BinaryTrees.Utility.TreeNode;
import Trees.BinaryTrees.Utility.TreeUtils;

import javax.imageio.stream.IIOByteBuffer;
import java.util.*;

public class NodesAtDistanceK {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);

        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);

        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        TreeNode root1 = new TreeNode(1);

        distanceK(root, root.left, 2).forEach(i -> {
            System.out.print(i + ", ");
        });

    }

    public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        List<Integer> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        TreeNode temp = root;
        Map<Integer, List<Integer>> adjMap = getAdjMap(temp);

        Set<Integer> visitedSet = new HashSet<>();

        dfsAdjMap(target.val, k, 0, adjMap, visitedSet, res);

        return res;
    }

    public static void dfsAdjMap(int curr, int k, int gap, Map<Integer, List<Integer>> adjMap, Set<Integer> visitedSet, List<Integer> res) {

        if (gap == k) {
            res.add(curr);
            return;
        }

        /* new arrayList just in case of the curr is not in the map will cause NullPointerException
         example root = TreeNode(1), will not create a arrayList in adjMap and cause NullPointerException */
        List<Integer> currAdjList = adjMap.getOrDefault(curr, new ArrayList<>());

        for (int i : currAdjList) {
            if (!visitedSet.contains(i)) {
                visitedSet.add(curr);
                dfsAdjMap(i, k, gap + 1, adjMap, visitedSet, res);
            }
        }

    }

    public static Map<Integer, List<Integer>> getAdjMap(TreeNode root) {
        Map<Integer, List<Integer>> adjMap = new HashMap<>();

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            TreeNode currNode = queue.poll();

            if (currNode.left != null) {
                queue.add(currNode.left);
                adjMap.computeIfAbsent(currNode.val, k -> new ArrayList<>()).add(currNode.left.val);
                adjMap.computeIfAbsent(currNode.left.val, k -> new ArrayList<>()).add(currNode.val);
            }

            if (currNode.right != null) {
                queue.add(currNode.right);
                adjMap.computeIfAbsent(currNode.val, k -> new ArrayList<>()).add(currNode.right.val);
                adjMap.computeIfAbsent(currNode.right.val, k -> new ArrayList<>()).add(currNode.val);
            }
        }

        return adjMap;
    }

}
