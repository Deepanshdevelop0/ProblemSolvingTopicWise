package Trees.BinaryTrees.Problems;

import Trees.BinaryTrees.Utility.TreeNode;
import Trees.BinaryTrees.Utility.TreeUtils;
import com.sun.source.tree.Tree;

import java.util.*;

public class SerializeandDeserializeBinaryTree {


/*

Preorder DFS

TC : O(n)

i. Each node is processed once → O(n).
ii. Each StringBuilder.append is amortized O(1).

SC : O(n + h) ~ O(n)

i. StringBuilder stores n values + n "null" markers → O(n)
ii. Recursion stack, for Balanced trees : O(h) ~ O(log n), for skewed trees in worst case O(n)

*/

    public static void main(String[] args) {
        TreeNode root = TreeUtils.buildTree(new Integer[]{1,2,3,null,null,4,5});

        TreeUtils.printTree(root);

        TreeNode ans = deserialize(serialize(root));

        TreeUtils.printTree(ans);

    }

    public static String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();

        serializeDFS(root, sb);

        return sb.toString();
    }

    public static void serializeDFS(TreeNode root, StringBuilder sb) {

        if (root == null) {
            sb.append("null,");
            return;
        }

        sb.append(root.val + ",");
        serializeDFS(root.left, sb);
        serializeDFS(root.right, sb);
    }


    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        Queue<String> queue = new ArrayDeque<>(Arrays.asList(nodes));
        return deserializeDFS(queue);
    }

    public static TreeNode deserializeDFS(Queue<String> queue) {

        String node = queue.poll();

        if (node.equals("null")) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(node));

        root.left = deserializeDFS(queue);
        root.right = deserializeDFS(queue);
        return root;
    }

}
