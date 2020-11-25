package Hot100;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @program: LeetCode
 * @description: 滑动窗口的最大值
 * @author: JJGGu
 * @create: 2020-11-14 17:18
 **/
public class LC239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int length = nums.length;
        int[] ans = new int[length - k + 1];
        // 队首存储当前窗口的最大值下标
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            // 此处跟最小栈有相似之处
            // 需要维持队首到队尾是从大到小的顺序,将比当前值小的下标元素都从队尾移出去
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            // 存入下标
            deque.addLast(i);
            // 判断当前队首的元素是否在窗口内,不在的话就移出
            while (deque.peekFirst() <= i - k) {
                // 从队首移出
                deque.poll();
            }
            if (i >= k - 1) {
                ans[i + 1 - k] = nums[deque.peekFirst()];
            }
        }
        return ans;
    }
}
