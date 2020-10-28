package Hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @program: LeetCode
 * @description: 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。  注意：答案中不可以包含重复的三元组。
 * @author: JJGGu
 * @create: 2020-10-20 22:22
 **/
public class LC015 {

    public static void main(String[] args) {
        List<List<Integer>> lists = threeSum(new int[]{-4, -1, -1, 0, 1, 2});
        for (List<Integer> list: lists) {
            for (Integer i: list) {
                System.out.println(i);
            }
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            // 确保第一个值选取的不是重复的
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            while (left < right) {
                // 确保第二个值选取的不是重复的
                if (left > i  + 1 && nums[left] == nums[left - 1]) {
                    left++;
                    continue;
                }
                if (nums[i] + nums[left] + nums[right] < 0) {
                    left++;
                } else if (nums[i] + nums[left] + nums[right] > 0) {
                    right--;
                } else {
                    List<Integer> list1 = new ArrayList<>();
                    list1.add(nums[i]);
                    list1.add(nums[left]);
                    list1.add(nums[right]);
                    list.add(list1);
                    left++;
                }
            }
        }
        return list;
    }
}
