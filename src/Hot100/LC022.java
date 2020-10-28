package Hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetCode
 * @description: 括号生成 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * @author: JJGGu
 * @create: 2020-10-24 15:52
 **/
public class LC022 {
    public static void main(String[] args) {
        List<String> list = generateParenthesis(3);
        list.forEach(System.out::println);
    }

    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        recur(list, new StringBuffer(), n, 0, 0);
        return list;
    }
    private static void recur(List<String> result, StringBuffer stringBuffer, int n, int left, int right) {
        if (stringBuffer.length() == n * 2) {
            result.add(stringBuffer.toString());
            return;
        }
        if (left < n) {
            stringBuffer.append('(');
            recur(result, stringBuffer, n, left + 1, right);
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
        if (right < left) {
            stringBuffer.append(')');
            recur(result, stringBuffer, n, left, right + 1);
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }

    }
}
