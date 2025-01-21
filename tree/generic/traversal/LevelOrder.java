package tree.generic.traversal;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LevelOrder {

    public void levelOrder(TreeNode root, int height, List<List<Integer>> result) {
        if (root == null) return;
        if (result.size() <= height) result.add(new ArrayList<>());
        result.get(height).add(root.val);
        levelOrder(root.left, height + 1, result);
        levelOrder(root.right, height + 1, result);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode().createTreeFromList(Arrays.asList(1, 2, 3, 4, 5, null, 6));
        List<List<Integer>> res = new ArrayList<>();
        new LevelOrder().levelOrder(root, 0, res);
        System.out.println(res);
    }
}
