package Trees.BinarySearchTrees.Problems;

import Trees.BinaryTrees.Utility.Node;
import Trees.BinaryTrees.Utility.TreeUtils;

public class Floor_In_BST {

/*

approach 1 (recursive : floor)

TC : O(h) : O(h) in best case, worst case O(n) for skewed trees

SC : O(h) : recursive stack

-------------------------------------------------------------
approach 2 (iterative : floorIterativeMostOptimal)

TC : O(h) : O(h) in best case, worst case O(n) for skewed trees

SC : O(1) : for constant variable

*/

    public static void main(String[] args) {
        /*Node root = new Node(8);
        root.left = new Node(4);
        root.right = new Node(15);
        root.left.left = new Node(2);
        root.left.right = new Node(6);
        root.right.left = new Node(12);
        root.right.right = new Node(16);*/

        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.right.left = new Node(12);
        root.right.right = new Node(30);

        TreeUtils.printTree(root);

        System.out.println(floorIterativeMostOptimal(root, 13));

    }

    public static int floor(Node root, int x) {

        if (root == null) {
            return -1;
        }

        if (root.data == x) {
            return root.data;
        }

        if (root.data > x) {
            return floor(root.left, x);
        }

        int floor = floor(root.right, x);
        return (floor > 0 && floor <= x) ? floor : root.data;
    }


    public static int floorIterativeMostOptimal(Node root, int x) {

        int floor = -1;

        while (root != null) {
            if (root.data == x) {
                return root.data;
            }
            else if (x < root.data) {
                root = root.left;
            }
            else {
                floor = root.data;
                root = root.right;
            }
        }

        return floor;
    }

}
