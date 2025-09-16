package Trees.BinarySearchTrees.Problems;

import Trees.BinaryTrees.Utility.Node;
import Trees.BinaryTrees.Utility.TreeUtils;

public class Ceil_In_BST {

/*

approach 1 (recursive : findCeilRecursive)

TC : O(h) : O(h) in best case, worst case O(n) for skewed trees

SC : O(h) : recursive stack

-------------------------------------------------------------
approach 2 (iterative : findCeilIterativeMostOptimal)

TC : O(h) : O(h) in best case, worst case O(n) for skewed trees

SC : O(1) : for constant variable

*/

    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(4);
        root.right = new Node(15);
        root.left.left = new Node(2);
        root.left.right = new Node(6);
        root.right.left = new Node(12);
        root.right.right = new Node(16);

        TreeUtils.printTree(root);

        System.out.println(findCeilRecursive(root, 11));

    }

    public static int findCeilRecursive(Node root, int input) {

        if (root == null) {
            return -1;
        }

        if (root.data == input) {
            return root.data;
        }

        if (root.data < input) {
            return findCeilRecursive(root.right, input);
        }

        int ceil = findCeilRecursive(root.left, input);
        return (ceil >= input) ? ceil : root.data;
    }


    public static int findCeilIterativeMostOptimal(Node root, int input) {

        int ceil = -1;

        while (root != null) {
            if (root.data == input) {
                return root.data;
            }
            else if (input > root.data) {
                root = root.right;
            }
            else {
                ceil = root.data;
                root = root.left;
            }
        }

        return ceil;
    }

}
