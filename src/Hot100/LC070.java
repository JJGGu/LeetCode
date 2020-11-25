package Hot100;

/**
 * @program: LeetCode
 * @description: 爬楼梯
 * @author: JJGGu
 * @create: 2020-11-04 15:59
 **/
public class LC070 {
    public static void main(String[] args) {
        System.out.println(climbStairs(3));
    }
    public static int climbStairs(int n) {
        if (n <= 0) {
            return 0;
        }
        int a = 1, b = 2;
        int c = 0;
        if (n == 1) {
            return a;
        }
        if (n == 2) {
            return b;
        }

        for (int i = 0; i < n - 2; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}
