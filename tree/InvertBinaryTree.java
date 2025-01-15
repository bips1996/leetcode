package tree;

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        invertTreeNode(root);
        return root;
    }

    public void invertTreeNode(TreeNode node) {
        if (node == null) return;
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
        invertTreeNode(node.left);
        invertTreeNode(node.right);
    }
}
