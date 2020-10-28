package Hot100;

/**
 * @program: LeetCode
 * @description: 下一个排列,按字典序排列的下一个排列
 * @author: JJGGu
 * @create: 2020-10-25 14:36
 **/
public class LC031 {
    public static void main(String[] args) {
        int[] x = new int[]{1, 2, 3, 4, 6, 5};
        nextPermutation(x);
        for (int a: x) {
            System.out.println(a);
        }
    }


    public static void nextPermutation(int[] nums) {
        //1. 从右向左找到第一个升序对
        int i = nums.length - 1;
        while (i > 0 && nums[i - 1] > nums[i]) {
            i--;
        }
        // 表示整个序列是降序排列，返回最小值,即进行翻转
        if (i == 0) {
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
            return;
        }
        // 2.将找到的升序对后面的序列按升序排序
        for (int j = i + 1; j < nums.length; j++) {
            for (int k = j + 1; k < nums.length; k++) {
                if (nums[k] < nums[k - 1]) {
                    int temp = nums[k];
                    nums[k] = nums[k - 1];
                    nums[k - 1] = temp;
                }
            }
        }
        // 3.将升序对左边的值与拍好序的最后一个值交换
        int length = nums.length;
        int temp = nums[length - 1];
        nums[length - 1] = nums[i - 1];
        nums[i - 1] = temp;
    }

}
