package Hot100;

/**
 * @program: LeetCode
 * @description: 旋转矩阵 旋转90度
 * @author: JJGGu
 * @create: 2020-10-30 14:01
 **/
public class LC048 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {5, 1, 9,11},
                {2, 4, 8,10},
                {13, 3, 6, 7},
                {15,14,12,16}
        };
        rotate(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.println(matrix[i][j]);
            }
        }
    }
    public static void rotate(int[][] matrix) {
        fun1(matrix);
    }
    // 方法一，转置后反转每一行
    private static void fun1(int[][] matrix) {
        // 转置,只需要考虑矩阵的上三角或者下三角
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // 反转每一行
        for (int i = 0; i < matrix.length; i++) {
            int left = 0;
            int right = matrix[0].length - 1;
            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }

    // 方法2.

}
