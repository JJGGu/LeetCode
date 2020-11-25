package Hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetCode
 * @description: 全排列
 * @author: JJGGu
 * @create: 2020-10-29 14:46
 **/
public class LC046 {
    public static void main(String[] args) {
        List<List<Integer>> permute = permute(new int[]{1, 2, 3});
        for (List list: permute) {
            System.out.println(list.toString());
        }
    }

    static List<List<Integer>> result = new ArrayList<>();
    public static List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        dfs(nums, nums.length, 0, new ArrayList<>(), used);
        return result;
    }

    private static void dfs(int[] nums, int n,  int index, List<Integer> path, boolean[] used) {
        if (index == n) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;

                dfs(nums, n, index + 1, path, used);

                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
}
