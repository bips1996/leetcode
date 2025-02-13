package graph;

public class NumberOfIsland {
    public int numIslands(char[][] grid) {
        int islandCount = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    islandCount += 1;
                    dfs(grid, i, j);
                }
            }
        }
        return islandCount;
    }

    public void dfs(char[][] grid, int row, int col) {
        if (row < 0
                || col < 0
                || row > grid.length - 1
                || col > grid[0].length - 1
                || grid[row][col] == '0')
            return;

        grid[row][col] = '0';

        dfs(grid, row + 1, col);
        dfs(grid, row - 1, col);
        dfs(grid, row, col + 1);
        dfs(grid, row, col - 1);
    }

    public static void main(String[] args) {
        char[][] arr = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        
        NumberOfIsland island = new NumberOfIsland();
        System.out.println(island.numIslands(arr));
    }
}
