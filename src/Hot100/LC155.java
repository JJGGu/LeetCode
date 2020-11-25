package Hot100;

import java.util.Stack;

/**
 * @program: LeetCode
 * @description: 最小栈  使用Stack实现
 * @author: JJGGu
 * @create: 2020-11-10 17:12
 **/
public class LC155 {
    // 正常栈
    Stack<Integer> stack1;
    // 存储小值栈
    Stack<Integer> stack2;
    public LC155() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        if (!stack2.isEmpty()) {
            int min = stack2.peek();
            if (x < min) {
                stack2.push(x);
            } else {
                stack2.push(min);
            }
        } else {
            stack2.push(x);
        }

        stack1.push(x);
    }

    public void pop() {
        stack1.pop();
        stack2.pop();
    }

    public int top() {
        return stack1.peek();
    }

    public int getMin() {
        return stack2.peek();
    }
}
