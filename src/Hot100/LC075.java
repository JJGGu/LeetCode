package Hot100;

/**
 * @program: LeetCode
 * @description: 颜色分类
 * @author: JJGGu
 * @create: 2020-11-04 16:15
 **/
public class LC075 {
    public static void main(String[] args) {
        int[] x= new int[]{2, 0, 1};
        sortColors(x);
        for (int a: x) {
            System.out.println(a);
        }

    }
    public static void sortColors(int[] nums) {
        // 双指针
        if (nums.length <= 0) {
            return;
        }
        int p0 = 0;
        int p2 = nums.length - 1;
        for (int i = 0; i <= p2; i++) {
            if (nums[i] == 0) {
                nums[i] = nums[p0];
                nums[p0++] = 0;
            } else if (nums[i] == 2) {
                nums[i--] = nums[p2];
                nums[p2--] = 2;
            }
        }
    }
}
