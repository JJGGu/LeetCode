package Hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetCode
 * @description: 二叉树展开为链表
 * @author: JJGGu
 * @create: 2020-11-09 08:52
 **/
public class LC114 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        List<TreeNode> list = new ArrayList<>();
        fun1(root, list);
        for (int i = 0; i < list.size() - 1; i++) {
            TreeNode cur = list.get(i);
            TreeNode next = list.get(i + 1);
            cur.left = null;
            cur.right = next;
        }
        list.get(list.size() - 1).right = null;
        root = list.get(0);
    }
    // 方法1.前序遍历存储到数组中
    private void fun1(TreeNode root, List<TreeNode> list) {
        if (root != null) {
            list.add(root);
            fun1(root.left, list);
            fun1(root.right, list);
        }
    }
    // 方法2.非递归，移动子树方式
    private void fun2(TreeNode root) {
        while (root != null) {
            if (root.left == null) {
                root = root.right;
            } else {
                // 先找左子树的最右节点
                TreeNode temp = root.left;
                while (temp.right != null) {
                    temp = temp.right;
                }
                // 将右子树挂到最右节点上
                temp.right = root.right;
                root.right = root.left;
                root.left = null;
                root = root.right;
            }
        }
    }
}
