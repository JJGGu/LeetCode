package Hot100;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @program: LeetCode
 * @description: 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * @author: JJGGu
 * @create: 2020-10-13 19:59
 **/
public class LC003 {
    public static void main(String[] args) {
        int length = lengthOfLongestSubstring(" ");
        System.out.println(length);
    }
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }

        int max = 0;
        char[] chars = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            // 窗口扩大
            if (!map.containsKey(chars[right])) {
                map.put(chars[right], right);
            }else {
                // 窗口缩小
                int index = map.get(chars[right]);
                left = index + 1;
                map.clear();
                for (int i = left; i <= right; i++) {
                    map.put(chars[i], i);
                }
            }
            max = Math.max(right - left + 1, max);

            right++;
        }
        return max;
    }

    // 方法2. 每次从下一个下标开始，判断从该下标起的最长子串
    public int lengthOfLongestSubstring2(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }

}
