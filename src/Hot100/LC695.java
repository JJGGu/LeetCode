package Hot100;

/**
 * @program: LeetCode
 * @description: 岛屿的最大面积
 * @author: JJGGu
 * @create: 2020-11-13 09:14
 **/
public class LC695 {
    public int maxAreaOfIsland(int[][] grid) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int x = dfs(grid, i, j);
                max = Math.max(x, max);
            }
        }
        return max;
    }
    private int dfs(int[][] grid, int r, int c) {
        if (!inArea(grid, r, c)) {
            return 0;
        }
        if (grid[r][c] != 1) {
            return 0;
        }
        grid[r][c] = 2;
        return 1 + dfs(grid, r + 1, c) + dfs(grid, r - 1, c) + dfs(grid, r, c + 1) + dfs(grid, r, c - 1);
    }

    private boolean inArea(int [][] grid, int r, int c) {
        return 0 <= r && r < grid.length && 0 <= c && c < grid[0].length;
    }
}
