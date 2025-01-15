package tree;

//https://leetcode.com/problems/binary-tree-right-side-view/description/

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        rightView(root, res, 0);
        return res;
    }

    public void rightView(TreeNode node, List<Integer> res, int depth) {
        if (node == null) return;

        if (depth == res.size()) {
            res.add(node.val);
        }

        rightView(node.right, res, depth + 1);
        rightView(node.left, res, depth + 1);

    }
}
