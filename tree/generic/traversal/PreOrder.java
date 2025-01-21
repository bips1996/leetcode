package tree.generic.traversal;

import tree.TreeNode;

import java.util.Arrays;

public class PreOrder {
    public void preOrder(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) {
        PreOrder preOrder = new PreOrder();
        TreeNode root = new TreeNode().createTreeFromList(Arrays.asList(1, 2, 3, 4, 5, null, 6));
        preOrder.preOrder(root);
    }
}
