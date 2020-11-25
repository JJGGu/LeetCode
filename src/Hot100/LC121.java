package Hot100;

/**
 * @program: LeetCode
 * @description: 买卖股票的最佳时机
 * @author: JJGGu
 * @create: 2020-11-09 10:04
 **/
public class LC121 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        return fun1(prices);
    }
    // 方法1
    private int fun1(int[] prices) {
        int buyMin = Integer.MAX_VALUE;
        int saleMax = 0;
        for (int i = 0; i < prices.length; i++) {
            buyMin = Math.min(buyMin, prices[i]);
            saleMax = Math.max(saleMax, prices[i] - buyMin);
        }
        return saleMax;
    }
}
