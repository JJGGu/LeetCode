package Hot100;

import java.util.HashMap;
import java.util.Stack;

/**
 * @program: LeetCode
 * @description:
 * @author: JJGGu
 * @create: 2020-10-24 14:57
 **/
public class LC020 {
    public static void main(String[] args) {
        boolean valid = isValid("");
        System.out.println(valid);
    }

    public static boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        Stack<Character> stack = new Stack<>();

        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (stack.empty()) {
                stack.push(c);
                i++;
                continue;
            }
            Character peek = stack.peek();
            if (map.get(peek).equals(c)) {
                stack.pop();
            } else {
                stack.push(c);
            }
            i++;
        }
        return stack.empty();
    }
}
