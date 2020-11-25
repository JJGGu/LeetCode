package Hot100;

/**
 * @program: LeetCode
 * @description: 除自身以外数组的乘积
 * @author: JJGGu
 * @create: 2020-11-14 16:48
 **/
public class LC238 {
    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3, 4};
        productExceptSelf(nums);
    }
    public static int[] productExceptSelf(int[] nums) {
        return fun2(nums);
    }

    // 方法1.
    private static int[] fun1(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        // 初始化left
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                left[i] = 1;
                continue;
            }
            left[i] = nums[i - 1] * left[i - 1];
        }
        // 初始化right
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == nums.length - 1) {
                right[i] = 1;
                continue;
            }
            right[i] = nums[i + 1] * right[i + 1];
        }
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = left[i] * right[i];
        }
        return ans;
    }

    // 空间优化为O1
    private static int[] fun2(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                ans[i] = 1;
                continue;
            }
            ans[i] = ans[i - 1] * nums[i - 1];
        }
        int right = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            ans[i] = ans[i] * right;
            right = right * nums[i];
        }
        return ans;
    }
}
