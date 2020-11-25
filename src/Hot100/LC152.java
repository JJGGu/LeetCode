package Hot100;

/**
 * @program: LeetCode
 * @description: 乘积最大子数组
 * @author: JJGGu
 * @create: 2020-11-10 15:13
 **/
public class LC152 {
    public int maxProduct(int[] nums) {
        return fun1(nums);
    }
    // 方法1.动态规划
    private int fun1(int[] nums) {
        int length = nums.length;
        int[] maxF = new int[length];
        int[] minF = new int[length];
        System.arraycopy(nums, 0, maxF, 0, length);
        System.arraycopy(nums, 0, minF, 0, length);
        for (int i = 1; i < length; ++i) {
            maxF[i] = Math.max(maxF[i - 1] * nums[i], Math.max(nums[i], minF[i - 1] * nums[i]));
            minF[i] = Math.min(minF[i - 1] * nums[i], Math.min(nums[i], maxF[i - 1] * nums[i]));
        }
        int ans = maxF[0];
        for (int i = 1; i < length; ++i) {
            ans = Math.max(ans, maxF[i]);
        }
        return ans;
    }
    // 方法1空间优化
    private int fun2(int[] nums) {
        int maxF = nums[0], minF = nums[0], ans = nums[0];
        int length = nums.length;
        for (int i = 1; i < length; ++i) {
            int max = maxF, min = minF;
            maxF = Math.max(max * nums[i], Math.max(nums[i], min * nums[i]));
            minF = Math.min(min * nums[i], Math.min(nums[i], max * nums[i]));
            ans = Math.max(maxF, ans);
        }
        return ans;
    }

    // 对比一下 53.最大子序和
    private int fun3(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }
}
