package tree;
// https://leetcode.com/problems/validate-binary-search-tree/

public class CheckBST {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, Long min, Long max) {
        if (root == null) return true;
        if (
                root.val > min
                        && root.val < max
                        && isValidBST(root.left, min, (long) root.val)
                        && isValidBST(root.right, (long) root.val, max)
        ) return true;

        return false;

    }
}
