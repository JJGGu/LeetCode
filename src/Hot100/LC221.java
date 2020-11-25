package Hot100;

/**
 * @program: LeetCode
 * @description: 最大正方形
 * @author: JJGGu
 * @create: 2020-11-13 20:19
 **/
public class LC221 {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        return fun1(matrix);
    }
    // 方法1.动态规划
    private int fun1(char[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        int maxLength = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = matrix[i][j] - 48;
                } else if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(dp[i- 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                } else if (matrix[i][j] == '0') {
                    dp[i][j] = 0;
                }
                maxLength = Math.max(maxLength, dp[i][j]);
            }
        }
        return maxLength * maxLength;
    }
}
