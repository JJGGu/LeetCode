package Hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetCode
 * @description: 不同路径
 * @author: JJGGu
 * @create: 2020-11-04 13:50
 **/
public class LC062 {
    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 2));
    }

    // 动态规划
    public static int uniquePaths(int m, int n) {
        int[][] result = new int[m][n];

        for (int i = 0; i < m; i++) {
            // 初始化行
            result[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            // 初始化列
            result[0][i] = 1;
        }
        return fun1(result, m, n);
    }

    private static int fun1(int[][] result, int m, int n) {
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                result[i][j] = result[i - 1][j] + result[i][j - 1];
            }
        }
        return result[m - 1][n - 1];
    }

}
