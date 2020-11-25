package Hot100;

/**
 * @program: LeetCode
 * @description: 不同的二叉搜索树
 * @author: JJGGu
 * @create: 2020-11-07 17:37
 **/
public class LC096 {
    public int numTrees(int n) {
        return fun1(n);
    }
    // 方法1.由递推得到的递归
    private int fun1(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int ans = 0;
        for (int i = 1; i < n; i++) {
            ans += fun1(i - 1) * fun1(n - i);
        }
        return ans;
    }

    // 方法2.动态规划， 使用数组记录
    private int fun2(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
