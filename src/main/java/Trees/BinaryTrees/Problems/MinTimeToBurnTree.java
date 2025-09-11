package Trees.BinaryTrees.Problems;

import Trees.BinaryTrees.Utility.Node;
import Trees.BinaryTrees.Utility.TreeUtils;

import java.util.*;

public class MinTimeToBurnTree {

    public static void main(String[] args) {
        Node root = TreeUtils.buildTreeFromNode(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        TreeUtils.printTree(root);
        System.out.println(minTime(root, 2));
    }

    public static int minTime(Node root, int target) {

        Map<Node, Node> parentMap = new HashMap<>();
        Node[] targetNodeArr = new Node[1];
        createParentMap(root, target, targetNodeArr, parentMap);

        if (targetNodeArr[0] == null) {
            return 0;
        }

        return getBurnTime(targetNodeArr[0], parentMap);
    }

    private static int getBurnTime(Node targetNode, Map<Node, Node> parentMap) {

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(targetNode);

        Set<Node> visitedSet = new HashSet<>();
        visitedSet.add(targetNode);

        int burnTime = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();
            int madeNewBurns = -1;

            for (int i = 0; i < size; i++) {

                Node curr = queue.poll();

                if (curr.left != null && !visitedSet.contains(curr.left)) {
                    queue.add(curr.left);
                    visitedSet.add(curr.left);
                    madeNewBurns = 1;
                }

                if (curr.right != null && !visitedSet.contains(curr.right)) {
                    queue.add(curr.right);
                    visitedSet.add(curr.right);
                    madeNewBurns = 1;
                }

                if (parentMap.containsKey(curr) && !visitedSet.contains(parentMap.get(curr))) {
                    Node parent = parentMap.get(curr);
                    queue.add(parent);
                    visitedSet.add(parent);
                    madeNewBurns = 1;
                }
            }

            if (madeNewBurns == 1) burnTime++;
        }

        return burnTime;
    }


    /* collect the parent of each node, and find the targetNode for reference */
    private static void createParentMap(Node root, Integer target, Node[] targetNodeArr, Map<Node, Node> parentMap) {

        if (root == null) {
            return;
        }

        if (root.data == target) {
            targetNodeArr[0] = root;
        }

        if (root.left != null) {
            parentMap.put(root.left, root);
            createParentMap(root.left, target, targetNodeArr, parentMap);
        }

        if (root.right != null) {
            parentMap.put(root.right, root);
            createParentMap(root.right, target, targetNodeArr, parentMap);
        }

    }


}
