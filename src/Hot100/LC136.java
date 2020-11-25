package Hot100;

import java.util.HashMap;
import java.util.Iterator;

/**
 * @program: LeetCode
 * @description: 只出现一次的数字
 * @author: JJGGu
 * @create: 2020-11-09 14:23
 **/
public class LC136 {
    public int singleNumber(int[] nums) {
        return fun1(nums);
    }
    // 异或法
    private int fun1(int[] nums) {
        int x = 0;
        for (int i: nums) {
            x ^= i;
        }
        return x;
    }
}
