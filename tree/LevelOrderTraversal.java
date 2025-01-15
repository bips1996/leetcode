package tree;

import java.util.ArrayList;
import java.util.List;
//https://leetcode.com/problems/binary-tree-level-order-traversal/description/

class LevelOrderTraversal {
    public void lod(TreeNode node, int level, List<List<Integer>> res) {
        if (node == null)
            return;
        if (res.size() <= level) res.add(new ArrayList<>());

        res.get(level).add(node.val);
        lod(node.left, level + 1, res);
        lod(node.right, level + 1, res);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        lod(root, 0, res);
        return res;
    }
}
