package Hot100;

/**
 * @program: LeetCode
 * @description: 完全平方数
 * @author: JJGGu
 * @create: 2020-11-16 09:22
 **/
public class LC279 {
    public int numSquares(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return dfs(n);
    }
    // 方法1.回溯
    private int dfs(int n) {
        if (n == 0) {
            return 0;
        }
        int count = Integer.MAX_VALUE;
        for (int i = 1 ; i < n; i++) {
            int temp = i * i;
            count = Math.min(dfs(n - temp), count) + 1;
        }
        return count;
    }
}
