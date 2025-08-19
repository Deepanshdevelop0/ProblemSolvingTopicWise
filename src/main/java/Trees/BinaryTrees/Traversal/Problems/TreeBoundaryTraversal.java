package Trees.BinaryTrees.Traversal.Problems;

import java.util.ArrayList;

public class TreeBoundaryTraversal {


/*

DFS :

TC : O(h) + O(N) + O(h) ~ O(N)
1. leftBoundary, leaves, rightBoundary

SC : O(N) + O(N) ~ O(N)
1. for result list, recursive stack (in worst case like skewed tree O(h) = O(N), in best case like balanced tree O(logN))

*/




    public static void main(String[] args) {
        /*TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);


        root.left.right.left = new TreeNode(8);
        root.left.right.right = new TreeNode(9);*/

        /*TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);

        root.left.left.left = new TreeNode(4);
        root.left.left.left.left = null;*/


        /*TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);*/

        TreeNode root1 = new TreeNode(1);
        root1.right = new TreeNode(2);

        root1.right.right = new TreeNode(3);

        root1.right.right.left = new TreeNode(4);
        root1.right.right.right = new TreeNode(5);


        ArrayList<Integer> res = new TreeBoundaryTraversal().boundaryTraversal(root1);


        System.out.println("boundaryTraversal of this graph : ");

        res.forEach(i -> {
            System.out.print(i + ", ");
        });


    }



    public ArrayList<Integer> boundaryTraversal(TreeNode root) {

        ArrayList<Integer> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        if (!isLeaf(root)) {
            res.add(root.data);
        }

        getLeftBoundary(root.left, res);

        getLeaves(root, res);

        getRightBoundary(root.right, res);

        return res;

    }

    public void getLeftBoundary(TreeNode curr, ArrayList<Integer> res) {

        if (curr == null || isLeaf(curr)) {
            return;
        }

        res.add(curr.data);

        if (curr.left != null) {
            getLeftBoundary(curr.left, res);
        }
        else if (curr.right != null) {
            getLeftBoundary(curr.right, res);
        }

    }

    public void getLeaves(TreeNode curr, ArrayList<Integer> res) {
        if (curr == null) {
            return;
        }

        if (isLeaf(curr)) {
            res.add(curr.data);
            return;
        }

        getLeaves(curr.left, res);
        getLeaves(curr.right, res);

    }

    public void getRightBoundary(TreeNode curr, ArrayList<Integer> res) {

        if (curr == null || isLeaf(curr)) {
            return;
        }

        if (curr.right != null) {
            getRightBoundary(curr.right, res);
        }
        else if (curr.left != null) {
            getRightBoundary(curr.left, res);
        }

        res.add(curr.data);

    }

    public boolean isLeaf(TreeNode curr) {
        return curr.left == null && curr.right == null;
    }


    private static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int data) {
            this.data = data;
        }

        TreeNode(int data, TreeNode left, TreeNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

}
