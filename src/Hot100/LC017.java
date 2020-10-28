package Hot100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: LeetCode
 * @description:
 * @author: JJGGu
 * @create: 2020-10-24 11:08
 **/
public class LC017 {
    static List<String> result = new ArrayList<>();
    static StringBuffer stringBuffer = new StringBuffer();

    public static void main(String[] args) {
        letterCombinations("23");
        for (String s: result) {
            System.out.println(s);
        }
    }

    public static List<String> letterCombinations(String digits) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");

        combine(digits, 0, map);
        return result;
    }
    private static void combine(String digits, int index, Map<Integer, String> map) {
        if (index == digits.length()) {
            result.add(stringBuffer.toString());
            return;
        }
        String s = map.get(digits.charAt(index) - 48);
        for (int i = 0; i < s.length(); i++) {
            stringBuffer.append(s.charAt(i));
            combine(digits, index + 1, map);
            // 删掉当前位置处的char
            stringBuffer.deleteCharAt(index);
        }

    }
}
