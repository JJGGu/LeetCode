package Hot100;

/**
 * @program: LeetCode
 * @description: 多数元素
 * @author: JJGGu
 * @create: 2020-11-10 17:41
 **/
public class LC169 {
    public int majorityElement(int[] nums) {
        return fun1(nums);
    }
    // 方法1.投票
    private int fun1(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int vote = 0;
        for (int x : nums) {
            if (vote == 0) {
                ans = x;
            }
            if (ans == x) {
                vote++;
            } else {
                vote--;
            }
        }
        return ans;
    }
}
