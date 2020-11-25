package Hot100;

/**
 * @program: LeetCode
 * @description: 单词搜索
 * @author: JJGGu
 * @create: 2020-11-07 15:20
 **/
public class LC079 {
    public boolean exist(char[][] board, String word) {
        boolean[][] used = new boolean[board.length][board[0].length];
        int rows = board.length;
        int cols = board[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(board, rows, cols, word.toCharArray(), i, j, 0, used)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int rows, int cols, char[] word, int row, int col, int len, boolean[][] used) {
        if (word[len] != board[row][col] || used[row][col]) {
            return false;
        }
        if (len == word.length - 1) {
            return true;
        }
        used[row][col] = true;
        // 向右探测
        if (col < cols - 1 && dfs(board, rows, cols, word, row, col + 1, len + 1, used)) {
            return true;
        }
        // 向左探测
        if (col > 0  && dfs(board, rows, cols, word, row, col - 1, len + 1, used)) {
            return true;
        }
        // 向下探测
        if (row < rows - 1 && dfs(board, rows, cols, word, row + 1, col, len + 1, used)) {
            return true;
        }
        // 向上探测
        if (row > 0 && dfs(board, rows, cols, word, row - 1, col, len + 1, used)) {
            return true;
        }
        used[row][col] = false;
        return false;
    }
}
