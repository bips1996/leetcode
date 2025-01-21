package tree.generic.traversal;

import tree.TreeNode;

import java.util.Arrays;

public class InOrder {
    public void inOrder(TreeNode node) {
        if (node == null) return;

        inOrder(node.left);
        System.out.println(node.val);
        inOrder(node.right);
    }

    public static void main(String[] args) {
        InOrder inOrder = new InOrder();
        TreeNode root = new TreeNode().createTreeFromList(Arrays.asList(1, 2, 3, 4, 5, null, 6));
        inOrder.inOrder(root);
    }
}
