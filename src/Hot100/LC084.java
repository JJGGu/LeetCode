package Hot100;

/**
 * @program: LeetCode
 * @description: 柱状图中的最大的矩形
 * @author: JJGGu
 * @create: 2020-11-07 16:23
 **/
public class LC084 {
    public int largestRectangleArea(int[] heights) {
        return fun1(heights);
    }
    // 暴力解法
    private int fun1(int[] height) {
         int length = height.length;
         int max = 0;
         int min = Integer.MAX_VALUE;
         int area = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                if (min > height[j]) {
                    min = height[j];
                    area = (j - i + 1) * min;
                } else {
                    area += min;
                }
                max = Math.max(area, max);
            }
            min = Integer.MAX_VALUE;
            area = 0;
        }
        return max;
    }


}
