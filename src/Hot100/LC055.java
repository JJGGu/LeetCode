package Hot100;

/**
 * @program: LeetCode
 * @description: 跳跃游戏
 * @author: JJGGu
 * @create: 2020-10-30 15:36
 **/
public class LC055 {
    public static void main(String[] args) {
        boolean b = canJump(new int[]{3,2,1,0,4});
        System.out.println(b);
    }
    public static boolean canJump(int[] nums) {
        // 记录当前能跳到的最远的地方
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (max >= i) {
                max = Math.max(nums[i] + i, max);
                if (max >= nums.length - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
