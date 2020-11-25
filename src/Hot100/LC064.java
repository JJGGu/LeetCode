package Hot100;

/**
 * @program: LeetCode
 * @description: 最小路径和
 * @author: JJGGu
 * @create: 2020-11-04 15:02
 **/
public class LC064 {
    // 动态规划
    public int minPathSum(int[][] grid) {
        // 对于每一个位置记录到给位置出的最小路径
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] result = new int[rows][cols];

        result[0][0] = grid[0][0];
        for (int i = 1; i < rows; i++) {
            result[i][0] = result[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < cols; i++) {
            result[0][i] = result[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                result[i][j] = Math.min(result[i - 1][j], result[i][j - 1]) + grid[i][j];
            }
        }
        return result[rows - 1][cols - 1];
    }
}
