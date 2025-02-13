package graph;

public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(dfsArea(grid, i, j), maxArea);
                }
            }
        }
        return maxArea;
    }

    public int dfsArea(int[][] grid, int row, int col) {
        if (
                row < 0
                        || col < 0
                        || row >= grid.length
                        || col >= grid[0].length
                        || grid[row][col] == 0
        )
            return 0;

        int area = 1;
        grid[row][col] = 0;

        area += dfsArea(grid, row + 1, col) +
                dfsArea(grid, row - 1, col) +
                dfsArea(grid, row, col + 1) +
                dfsArea(grid, row, col - 1);
        return area;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 0, 1},
                {1, 1, 1, 1, 0}
        };
        System.out.println(new MaxAreaOfIsland().maxAreaOfIsland(arr));
    }
}
