package Hot100;

/**
 * @program: LeetCode
 * @description: 搜索旋转数组中的某个值
 * @author: JJGGu
 * @create: 2020-10-25 15:50
 **/
public class LC033 {
    public static void main(String[] args) {
        int[] x = new int[] {3, 4, 5, 1, 2};
        int search = search(x, 4);
        System.out.println(search);
    }

    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left <= right) {
            int mid = (left +right) >> 1;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] >= nums[left]) {
                // 左半是递增
                if (nums[left] <= target && target < nums[mid]) {
                    // target在左边
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }

            } else if (nums[mid] < nums[left]) {
                // 右边是递增
                if (nums[mid] < target && target <= nums[left]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
