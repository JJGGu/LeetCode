package Hot100;

import java.util.Arrays;

/**
 * @program: LeetCode
 * @description: 最大人工岛
 * @author: JJGGu
 * @create: 2020-11-13 09:28
 **/
public class LC827 {
    public int largestIsland(int[][] grid) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // 复制数组
                int[][] array = new int[grid.length][grid[0].length];
                for (int k = 0; k < grid.length; k++) {
                    array[k] = Arrays.copyOf(grid[k], grid[0].length);
                }
                if (array[i][j] == 0) {
                    array[i][j] = 1;
                }
                int x = dfs(array, i, j);
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
