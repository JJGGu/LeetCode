package Hot100;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: LeetCode
 * @description: 对称二叉树
 * @author: JJGGu
 * @create: 2020-11-08 16:42
 **/
public class LC101 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }
        return fun1(root, root);
    }

    // 方法1.递归法
    private boolean fun1(TreeNode left, TreeNode right) {
        if (left == null && left != right) {
            return false;
        }
        if (right == null && right != left) {
            return false;
        }
        if (right == null && left == null) {
            return true;
        }
        return  (left.val == right.val) && fun1(left.left, right.right) && fun1(left.right, right.left);
    }
    // 方法2.迭代法 使用层序遍历
    private boolean fun2(TreeNode root1, TreeNode root2) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root1);
        queue.offer(root2);
        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if (left == null && right == null) {
                continue;
            }
            if (left == null || right == null || left.val != right.val) {
                return false;
            }
            queue.offer(root1.left);
            queue.offer(root2.right);

            queue.offer(root1.right);
            queue.offer(root2.left);
        }
        return true;
    }
}
