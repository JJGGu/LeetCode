package Hot100;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: LeetCode
 * @description: 单词拆分
 * @author: JJGGu
 * @create: 2020-11-09 14:40
 **/
public class LC139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        return fun1(s, wordDict);
    }
    // 方法1.动态规划
    private boolean fun1(String s, List<String> wordDict) {
        Map<String, Boolean> map = new HashMap<>();
        for (String str: wordDict) {
            map.put(str, true);
        }
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && map.containsKey(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
