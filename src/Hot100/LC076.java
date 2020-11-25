package Hot100;

import java.util.*;

/**
 * @program: LeetCode
 * @description: 最小覆盖子串
 * @author: JJGGu
 * @create: 2020-11-04 17:31
 **/
// 未做完
public class LC076 {
    // 滑动窗口
    public String minWindow(String s, String t) {
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();

        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;

        int left1 = 0;
        int right1 = 0;

        while (right < s1.length) {
            // 包含则左指针右移
            if (check(map, t1)){
                left1 = left;
                map.put(s1[left], map.get(s1[left]) - 1);
                left++;
            } else {
                if (map.containsKey(s1[right])) {
                    map.put(s1[right], map.get(s1[right]) + 1);
                } else {
                    map.put(s1[right], 0);
                }
                right++;
            }
        }
        return "";
    }
    private boolean check(Map<Character, Integer> map, char[] t) {
        Map<Character, Integer> map1 = new HashMap<>(map);
        for (char c: t) {
            Integer integer = map1.get(t);
            if (integer == null || integer <= 0) {
                return false;
            }
            map1.put(c, map1.get(t) - 1);
        }
        return true;
    }
}
