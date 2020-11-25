package Hot100;

/**
 * @program: LeetCode
 * @description: 岛屿数量
 * @author: JJGGu
 * @create: 2020-11-10 20:33
 **/
public class LC200 {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int r, int c) {
        if (!inArea(grid, r, c)) {
            return;
        }
        if (grid[r][c] != '1') {
            return;
        }
        // 标记为已经遍历过的陆地格子
        grid[r][c] = 2;
        dfs(grid, r + 1, c);
        dfs(grid, r - 1, c);
        dfs(grid, r, c + 1);
        dfs(grid, r, c - 1);
    }
    private boolean inArea(char [][] grid, int r, int c) {
        return 0 <= r && r < grid.length && 0 <= c && c < grid[0].length;
    }
}
