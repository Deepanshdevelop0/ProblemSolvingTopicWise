package Trees.BinaryTrees.Problems;

import Trees.BinaryTrees.Utility.TreeNode;

public class lowestCommonAncestor {

/*

DFS Recursive Approach

TC : O(N) : no of nodes

SC : O(N) : recursive stack space for (balanced trees O(H)), (worst case, for skewed trees O(N))

*/

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);

        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);

        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        System.out.println(lowestCommonAncestor(root, root.left, root.left.right.right).val);

    }


    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) {
            return null;
        }

        /* if the node matches any of p or q return it */
        if (root == p || root == q) {
            return root;
        }

        /* move to left and right from each node */
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);


        /* From each node, return whatever is found not null : left or right,
            if both found from left and right path means the current node contains the p,q nodes on its left,right : return root */
        if (left != null && right != null) {
            return root;
        }
        else if (left != null) {
            return left;
        }
        else { /* if (right != null) */
            return right;
        }
        
    }


}
