package Hot100;

/**
 * @program: LeetCode
 * @description: 接雨水
 * @author: JJGGu
 * @create: 2020-10-29 10:51
 **/
public class LC040 {
    public int trap(int[] height) {
        int i = fun1(height);
        return i;
    }

    // 方法1.按列求(暴力法)
    private int fun1(int[] height) {
        int amount = 0;
        for (int i = 1; i < height.length; i++) {
            // 找到左边最高的
            int leftMax = 0;
            for (int j = i - 1; j >= 0; j--) {
                leftMax = Math.max(height[j], leftMax);
            }
            // 找到右边最高的
            int rightMax = 0;
            for (int j = i + 1; j < height.length; j++) {
                rightMax = Math.max(height[j], rightMax);
            }
            // 计算当前列存储的水
            int x = Math.min(rightMax, leftMax) - height[i];
            amount += Math.max(x, 0);
        }
        return amount;
    }

    // 方法2.动态规划（使用数组保存当前列两边的最高列）
    private int fun2(int[] height) {
        int amount = 0;
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];

        for (int i = 1; i < height.length - 1; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i - 1]);
        }
        for (int i = height.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i + 1]);
        }

        for (int i = 1; i < height.length; i++) {
            int min = Math.min(leftMax[i], rightMax[i]);
            if (min > height[i]) {
                amount += min - height[i];
            }
        }
        return amount;
    }

    // 双指针法
    private int fun3(int[] height) {
        int sum = 0;
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        while (left < right) {
            // 只关注小的那边,另外一边就不需要关注了
            if (height[left] < height[right]) {
                // 只关注左边
                if (leftMax < height[left]) {
                    leftMax = height[left];
                } else {
                    sum += leftMax - height[left];
                }
                left++;
            }else {
                if (rightMax < height[right]) {
                    rightMax = height[right];
                } else {
                    sum += rightMax - height[right];
                }
                right--;
            }
        }
        return sum;
    }
}
