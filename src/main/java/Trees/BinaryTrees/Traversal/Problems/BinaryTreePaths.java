package Trees.BinaryTrees.Traversal.Problems;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

/*

i. DFS + String Concatenation

TC : O(N x H)
1. No of nodes x creation of height size string in worst case

SC : O(N) + O(h) ~ O(N)
1. Res list + recursion stack space till height of tree

ii. DFS + StringBuilder

TC : O(N)
1. No of nodes + appending height size string gets done in O(1)

SC : O(N) + O(h) ~ O(N)
1. Res list + recursion stack space till height of tree

*/

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        binaryTreePaths(root).forEach(i -> {
            System.out.print(i + ", ");
        });


        StringBuilder st = new StringBuilder("foi");

        st.append("iufbghv");

        System.out.println(st);
        st.setLength(3);

        System.out.println(st);

        String s = new String("1->2->3");

        System.out.println(s);

        s = s.replace("->3", "");

        System.out.println(s);

    }


    public static List<String> binaryTreePaths(TreeNode root) {

        ArrayList<String> res = new ArrayList<String>();

        if (root == null) {
            return res;
        }

        binaryTreePathsDfsOptimal(root, new StringBuilder(), res);


        return res;
    }


    public static void binaryTreePathsDfs(TreeNode root, String resString, List<String> res) {

        if (root == null) {
            return;
        }

        String st = String.valueOf(root.val);
        resString += (resString.isEmpty()) ? st : ("->" + st);

        binaryTreePathsDfs(root.left, resString, res);
        binaryTreePathsDfs(root.right, resString, res);

        if (root.left == null && root.right == null) {
            res.add(resString);
            resString = resString.replace("->" + st, "");
        }
    }


    public static void binaryTreePathsDfsOptimal(TreeNode root, StringBuilder resString, List<String> res) {

        if (root == null) {
            return;
        }

        int len = resString.length();

        resString.append((resString.isEmpty()) ? root.val : ("->" + root.val));

        binaryTreePathsDfsOptimal(root.left, resString, res);
        binaryTreePathsDfsOptimal(root.right, resString, res);

        if (root.left == null && root.right == null) {
            res.add(resString.toString());
        }
        resString.setLength(len);
    }




    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


}
