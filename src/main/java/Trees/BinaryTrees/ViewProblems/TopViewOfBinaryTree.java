package Trees.BinaryTrees.ViewProblems;

import java.util.*;

public class TopViewOfBinaryTree {

/*

Level order traversal BFS

TC : O(N) + O(N) ~ O(N)
i. No of nodes
i. retrieving all values from map

SC : O(N) + O(N) + O(N) ~ O(N)
i. Queue size which can be O(N)
ii. Map space
iii. result list

*/

    public static void main(String[] args) {
        Node one = new Node(1);
        one.left = new Node(2);
        one.right = new Node(3);
        one.left.left = new Node(4);
        one.left.right = new Node(5);
        one.right.left  = new Node(6);
        one.right.right = new Node(7);

        topView(one).forEach(i -> {
            System.out.print(i + ", ");
        });
    }

    public static ArrayList<Integer> topView(Node root) {
        // code here
        ArrayList<Integer> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        record pair(Node node, int lineNo){};

        Queue<pair> queue = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();

        queue.add(new pair(root, 0));

        /* track the highest negative and positive indexes */
        int maxNeg = 0, maxPos = 0;

        while (!queue.isEmpty()) {

            Node node = queue.peek().node;
            int lineNo = queue.peek().lineNo;

            queue.remove();

            if (node.left != null) {
                queue.add(new pair(node.left, lineNo-1));
            }

            if (node.right != null) {
                queue.add(new pair(node.right, lineNo+1));
            }

            if (!map.containsKey(lineNo)) {
                map.put(lineNo, node.data);
            }

            /* maintain the most negative line no to add in res */
            maxNeg = Math.min(maxNeg, lineNo);
            /* maintain the most positive line no to add in res */
            maxPos = Math.max(maxPos, lineNo);

        }

        for (int i = maxNeg; i <= maxPos; i++) {
            res.add(map.get(i));
        }

        return res;
    }


    private static class Node {
        int data;
        Node left;
        Node right;

        Node() {
        }

        Node(int data) {
            this.data = data;
        }

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}
