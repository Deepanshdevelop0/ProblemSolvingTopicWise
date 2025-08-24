package Trees.BinaryTrees.Problems;

import Trees.BinaryTrees.Utility.TreeNode;
import Trees.BinaryTrees.Utility.TreeUtils;

import java.util.*;

public class verticalTraversalOfBinaryTree {

/*

BFS (Level Order Traversal) + Priority Queue

TC : O(N) + O(log N) + O(N log N) ~ O(N log N)
i. traverse all N nodes
ii. insertion per node into map structure = O(log V + log H + log K) ≈ O(log N)
iii. sort each pq before adding treemap to resList :
    sorting takes O(M log M) where M = size of that PQ : in total collecting to resList : O(N log N).

SC : O(N) + O(W) + O(N) ~ O(N)
i. res list of list → stores all nodes once = O(N)
ii. Queue space of O(N) or O(W)
iii. TreeMap to store all nodes in key val, and priority queues

-------------------------------------------------------------------------

BFS (Level Order Traversal) + ArrayList (Optimized)

TC : O(N) + O(N log N) + O( N log N) ~ O(N log N)
i. traverse all N nodes
ii. insertion per node into map structure = O(log V + log H + 1) ≈ O(N log N) worst case
iii. sorting list at the collection in resList : O(M log M), where M is size of that list.


SC : O(W) + O(N) + O(N) ~ O(N)
i. Queue (BFS) → up to O(W) nodes at a time (W = tree width). Worst case = O(N)
ii. Map structure → stores all nodes once = O(N)
iii. Result list → also stores all nodes once = O(N)

*/

    public static void main(String[] args) {

        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode ten = new TreeNode(10);
        TreeNode nine = new TreeNode(9);
        TreeNode eleven = new TreeNode(11);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);

        // Build the tree according to array mapping
        one.left = two;
        one.right = three;

        two.left = four;
        two.right = ten;

        three.left = nine;
        three.right = eleven;

        four.right = five;

        five.right = six;

        Integer[] nodes = new Integer[]{0,2,1,3,null,5,22,9,4,12,25,null,null,13,14,8,6,null,null,null,null,null,27,24,26,null,17,7,null,28,null,null,null,null,null,19,null,11,10,null,null,null,23,16,15,20,18,null,null,null,null,null,21,null,null,29};
        TreeNode root = TreeUtils.buildTree(nodes);

        verticalTraversalOptimal(root).forEach(list -> {
            list.forEach(i -> {
                System.out.print(i + ", ");
            });
            System.out.println();
        });

    }


    /* using the arrayList and custom sorting and adding the nodes in list behaviour */
    /* More efficient */
    public static List<List<Integer>> verticalTraversalOptimal(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        record NodeDetail(TreeNode currNode, int vertLevel, int horLevel){};

        Queue<NodeDetail> queue = new ArrayDeque<>();
        TreeMap<Integer, TreeMap<Integer, ArrayList<Integer>>> map = new TreeMap<>();

        queue.add(new NodeDetail(root, 0, 0));

        while (!queue.isEmpty()) {

            TreeNode currNode = queue.peek().currNode();
            int vertLevel = queue.peek().vertLevel;
            int horLevel = queue.peek().horLevel;

            queue.remove();

            if (currNode.left != null) {
                queue.add(new NodeDetail(currNode.left, vertLevel-1, horLevel+1));
            }

            if (currNode.right != null) {
                queue.add(new NodeDetail(currNode.right, vertLevel+1, horLevel+1));
            }

            /* initialize map with keys */
            if (!map.containsKey(vertLevel)) {
                map.put(vertLevel, new TreeMap<>());
            }
            if (!map.get(vertLevel).containsKey(horLevel)) {
                map.get(vertLevel).put(horLevel, new ArrayList<>());
            }

            /* add the removed node into map */
            map.get(vertLevel).get(horLevel).add(currNode.val);

        }

        for (TreeMap<Integer, ArrayList<Integer>> innerMap : map.values()) { // for sorted vertical Levels in main map
            List<Integer> tempList = new ArrayList<>();
            for (ArrayList<Integer> list : innerMap.values()) { // for sorted horizontal levels in innerMap
                /* first sort the inner list of coordinate (verticalLevel, horizontalLevel) as the
                order of addition could clash order of node values */
                Collections.sort(list);
                tempList.addAll(list);
            }

            /* add to resList */
            res.add(tempList);
        }

        return res;
    }

    /* using the priorityQueue and sorting each pq before adding to SubResList */
    /* Less efficient */
    public static List<List<Integer>> verticalTraversal(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        record NodeDetail(TreeNode currNode, int vertLevel, int horLevel){};

        Queue<NodeDetail> queue = new ArrayDeque<>();
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

        queue.add(new NodeDetail(root, 0, 0));

        while (!queue.isEmpty()) {

            TreeNode currNode = queue.peek().currNode();
            int vertLevel = queue.peek().vertLevel;
            int horLevel = queue.peek().horLevel;

            queue.remove();

            if (currNode.left != null) {
                queue.add(new NodeDetail(currNode.left, vertLevel-1, horLevel+1));
            }

            if (currNode.right != null) {
                queue.add(new NodeDetail(currNode.right, vertLevel+1, horLevel+1));
            }

            /* initialize map with keys */
            if (!map.containsKey(vertLevel)) {
                map.put(vertLevel, new TreeMap<>());
            }
            if (!map.get(vertLevel).containsKey(horLevel)) {
                map.get(vertLevel).put(horLevel, new PriorityQueue<>());
            }

            /* add the removed node into map */
            map.get(vertLevel).get(horLevel).add(currNode.val);

        }

        for (TreeMap<Integer, PriorityQueue<Integer>> innerMap : map.values()) { // for sorted vertical Levels in main map
            List<Integer> tempList = new ArrayList<>();
            for (PriorityQueue<Integer> pq : innerMap.values()) { // for sorted horizontal levels in innerMap
                tempList.addAll(pq.stream().sorted().toList());
            }

            /* add to resList */
            res.add(tempList);
        }

        return res;
    }


}
