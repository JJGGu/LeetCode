package Hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetCode
 * @description: 组合总和
 * @author: JJGGu
 * @create: 2020-10-27 20:50
 **/
public class LC039 {
    static List<List<Integer>> lists = new ArrayList<>();
    public static void main(String[] args) {
        int[] x= new int[] {2,3,6,7};
        lists = combinationSum(x, 7);
        for (List list: lists) {
            list.forEach(System.out::println);
        }
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
//        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> combine = new ArrayList<Integer>();
//        dfs(candidates, target, ans, combine, 0);
        dfs2(combine, candidates, 0, 0, target);
        return lists;

    }

    public static void dfs(int[] candidates, int target, List<List<Integer>> ans, List<Integer> combine, int idx) {
        if (idx == candidates.length) {
            return;
        }
        if (target == 0) {
            ans.add(new ArrayList<Integer>(combine));
            return;
        }
        // 直接跳过
        dfs(candidates, target, ans, combine, idx + 1);
        // 选择当前数
        if (target - candidates[idx] >= 0) {
            combine.add(candidates[idx]);
            dfs(candidates, target - candidates[idx], ans, combine, idx);
            combine.remove(combine.size() - 1);
        }
    }

    public static void dfs2(List<Integer> curResult, int[] candidate, int sum, int index, int target) {
        if (sum == target) {
            lists.add(new ArrayList<>(curResult));
            return;
        }
        for (int i = index; i < candidate.length; i++) {
            sum += candidate[i];
            if (sum <= target) {
                 curResult.add(candidate[i]);
                 dfs2(curResult, candidate, sum, i, target);
                 sum -= candidate[i];
                 curResult.remove(curResult.size() - 1);
            } else {
                sum -= candidate[i];
                break;
            }
        }
    }
}
