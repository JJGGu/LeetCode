package Hot100;

import java.util.HashMap;

/**
 * @program: LeetCode
 * @description: 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * @author: JJGGu
 * @create: 2020-10-13 19:56
 **/
public class LC001 {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            Integer a = map.get(target - nums[i]);
            if (a != null && a != i) {
                ans[0] = i;
                ans[1] = a;
                return ans;
            }
        }
        return ans;
    }
}
