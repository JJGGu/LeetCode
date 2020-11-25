package Hot100;

/**
 * @program: LeetCode
 * @description: 打家劫舍
 * @author: JJGGu
 * @create: 2020-11-10 19:59
 **/
public class LC198 {
    public int rob(int[] nums) {
        return fun1(nums);
    }
    // 动态规划，空间未优化
    private int fun1(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        if (length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[length - 1];
    }
    // 动态规划，空间优化
    private int fun2(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        if (length == 1) {
            return nums[0];
        }
        int dp_2 = nums[0];
        int dp_1 = Math.max(nums[0], nums[1]);
        int dp = Math.max(dp_1, dp_2);
        for (int i = 2; i < length; i++) {
            dp = Math.max(dp_2 + nums[i], dp_1);
            dp_2 = dp_1;
            dp_1 = dp;
        }
        return dp;
    }
}
