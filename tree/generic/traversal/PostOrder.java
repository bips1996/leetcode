package tree.generic.traversal;

import tree.TreeNode;

import java.util.Arrays;

public class PostOrder {
    public void postOrder(TreeNode root) {
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }

    public static void main(String[] args) {
        PostOrder postOrder = new PostOrder();
        TreeNode root = new TreeNode().createTreeFromList(Arrays.asList(1, 2, 3, 4, 5, null, 6));
        postOrder.postOrder(root);
    }
}
