package Hot100;

/**
 * @program: LeetCode
 * @description: 最大子序和
 * @author: JJGGu
 * @create: 2020-10-30 15:13
 **/
public class LC053 {
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
    }

    public static int maxSubArray(int[] nums) {
        return fun2(nums);
    }

    // 方法1.动态规划
    private static int fun1(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        // x 存储当前最大和
        int[] x = new int[nums.length];
        x[0] = nums[0];
        int max = x[0];
        for (int i = 1; i < nums.length; i++) {
            if (x[i - 1] < 0) {
                x[i] = nums[i];
            } else {
                x[i] = x[i - 1] + nums[i];
            }
            max = Math.max(x[i], max);
        }
        return max;
    }

    // 动态规划的改进版 空间复杂度O（1）
    private static int fun2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        // 当前max
        int max = nums[0];
        // 前一个max
        int preMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (preMax < 0) {
                preMax = nums[i];
            } else {
                preMax = preMax + nums[i];
            }
            max = Math.max(preMax, max);
        }
        return max;
    }

}
