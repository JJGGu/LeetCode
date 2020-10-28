package Hot100;

/**
 * @program: LeetCode
 * @description: 在排序数组中查找元素的第一个和最后一个位置
 * @author: JJGGu
 * @create: 2020-10-26 21:05
 **/
public class LC034 {

    public static void main(String[] args) {
        int[] x= new int[] {5, 8, 8, 8, 10};
        int[] ints = searchRange(x, 10);
        System.out.println(ints[0]);
        System.out.println(ints[1]);
    }

    // 求出一个数字在数组中的上界和下界
    public static int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if (nums[left] != target) {
            return new int[] {-1, -1};
        }
        int bound1 = left;

        left = 0; right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        int bound2 = left;
        return new int[] {bound1, bound2};
    }
}
