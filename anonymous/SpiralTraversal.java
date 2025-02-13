package anonymous;

import java.util.ArrayList;
import java.util.List;

public class SpiralTraversal {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> op = new ArrayList<>();
        int left = 0, top = 0, right = matrix[0].length - 1, bottom = matrix.length - 1;

        while (left <= right && top <= bottom) {
            //travel right
            for (int i = left; i <= right; i++) {
                op.add(matrix[top][i]);
            }
            top += 1;

            //travel bottom
            for (int i = top; i <= bottom; i++) {
                op.add(matrix[i][right]);
            }
            right -= 1;

            if (top > bottom) break;
            if (left > right) break;

            //travel left
            for (int i = right; i >= left; i--) {
                op.add(matrix[bottom][i]);
            }
            bottom -= 1;
            //travel top
            for (int i = bottom; i >= top; i--) {
                op.add(matrix[i][left]);
            }
            left += 1;
        }
        return op;
    }
}
