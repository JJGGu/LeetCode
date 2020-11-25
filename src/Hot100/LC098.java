package Hot100;

/**
 * @program: LeetCode
 * @description: 验证二叉搜索树
 * @author: JJGGu
 * @create: 2020-11-08 11:07
 **/
public class LC098 {
    public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
    }

    long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        return fun1(root);
    }
    // 方法1.中序遍历 根据大小判断
    private boolean fun1(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (fun1(root.left) == false) {
            return false;
        }
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        return fun1(root.right);
    }
}
