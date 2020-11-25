package Hot100;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @program: LeetCode
 * @description: 二叉树的中序遍历
 * @author: JJGGu
 * @create: 2020-11-07 17:06
 **/
public class LC094 {
    public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          } }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return  list;
    }
    // 方法1.递归
    private void inorder(TreeNode root, List<Integer> list) {
        if (root != null) {
            inorder(root.left, list);
            list.add(root.val);
            inorder(root.right, list);
        }
    }

    private List<Integer> inorderStack(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (!stack.empty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                TreeNode pop = stack.pop();
                list.add(pop.val);
                cur = pop.right;
            }
        }
        return list;
    }
}
