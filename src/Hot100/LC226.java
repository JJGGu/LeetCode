package Hot100;

/**
 * @program: LeetCode
 * @description: 翻转二叉树
 * @author: JJGGu
 * @create: 2020-11-14 11:02
 **/
public class LC226 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode invertTree(TreeNode root) {
        return fun1(root);
    }
    // 方法1.递归
    private TreeNode fun1(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = fun1(root.left);
        TreeNode right = fun1(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
