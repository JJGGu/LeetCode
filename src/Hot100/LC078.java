package Hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetCode
 * @description: 子集
 * @author: JJGGu
 * @create: 2020-11-04 21:29
 **/
public class LC078 {
    public static void main(String[] args) {
        List<List<Integer>> subsets = subsets(new int[]{1, 2, 3});
        for (List list: subsets) {
            System.out.println(list);
        }
    }


    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        dfs(result, temp, nums, 0);

        return result;
    }

    private static void dfs(List<List<Integer>> result, List<Integer> temp, int[] nums, int index) {
        result.add(new ArrayList<>(temp));
        for (int i = index; i < nums.length; i++) {
            temp.add(nums[i]);
            dfs(result, temp, nums, i + 1);
            temp.remove(temp.size() - 1);
        }

    }
}
