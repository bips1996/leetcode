package tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode createTreeFromList(List<Integer> values) {
        if (values == null || values.isEmpty()) {
            return null;
        }


        TreeNode root = new TreeNode(values.get(0));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (i < values.size()) {
            TreeNode current = queue.poll();


            if (i < values.size() && values.get(i) != null) {
                assert current != null;
                current.left = new TreeNode(values.get(i));
                queue.offer(current.left);
            }
            i++;


            if (i < values.size() && values.get(i) != null) {
                assert current != null;
                current.right = new TreeNode(values.get(i));
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }
}
