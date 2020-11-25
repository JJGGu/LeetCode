package Hot100;

/**
 * @program: LeetCode
 * @description: 搜索二维矩阵
 * @author: JJGGu
 * @create: 2020-11-16 09:12
 **/
public class LC240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        int r = matrix.length - 1;
        int c = 0;
        // 从左下角开始找
        while (c < matrix[0].length && r >= 0) {
            if (matrix[r][c] == target) {
                return true;
            } else if (matrix[r][c] < target) {
                // 在上面
                c++;
            } else {
                r--;
            }
        }
        return false;
    }

}
