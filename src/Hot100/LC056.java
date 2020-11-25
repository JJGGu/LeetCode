package Hot100;

import java.util.*;

/**
 * @program: LeetCode
 * @description: 合并区间
 * @author: JJGGu
 * @create: 2020-10-30 16:22
 **/
public class LC056 {
    public int[][] merge(int[][] intervals) {
        int[][] result = new int[intervals.length][];
        // 首先排序，然后进行合并
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        int index = -1;
        for (int[] interval : intervals) {
            // 三种情况, 其中有一种情况不用管
            if (index == -1 || result[index][1] < interval[0]) {
                result[++index] = interval;
            } else {
                result[index][1] = Math.max(result[index][1], interval[1]);
            }
        }
        return Arrays.copyOf(result, index + 1);
    }
}
