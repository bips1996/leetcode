package tree;

public class MaxDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        return height(root,0)+1;
    }

    public int height(TreeNode node, int height) {
        if(node == null) return -1;
        int lheight = height(node.left,height);
        int rheight = height(node.right, height);
        height = Math.max(lheight,rheight)+1;
        return height;
    }
}
