package Trees.BinaryTrees.Utility;

public class Node {

        public int data;
        public Node left;
        public Node right;
        Node() {}
        public Node(int data) { this.data = data; }
        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }


}
