package tree;

//https://leetcode.com/problems/subtree-of-another-tree/

public class IsSubTree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (isSameTree(root, subRoot)) return true;
        else if (root == null && subRoot != null) return false;
        else {
            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        }
    }

    public boolean isSameTree(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null)
            return true;
        if (root1 == null || root2 == null) return false;

        if (root1.val == root2.val && isSameTree(root1.left, root2.left) && isSameTree(root1.right, root2.right))
            return true;

        return false;
    }
}
