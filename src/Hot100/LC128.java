package Hot100;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: LeetCode
 * @description: 最长连续序列
 * @author: JJGGu
 * @create: 2020-11-09 10:52
 **/
public class LC128 {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        return fun1(nums);
    }
    // 方法1.使用hashset
    private int fun1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = 1;
        for (int x: nums) {
            set.add(x);
        }
        for (int x: nums) {
            if (set.contains(x)) {
                int tempMax = 1;
                int temp = 1;
                while (set.contains(x + temp)) {
                    tempMax++;
                    temp++;
                }
                max = Math.max(max, tempMax);
            }
        }
        return max;
    }
}
