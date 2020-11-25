package Hot100;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @program: LeetCode
 * @description: 二叉树的最近公共祖先
 * @author: JJGGu
 * @create: 2020-11-14 11:53
 **/
public class LC236 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return dfs(root, p, q);
    }

    // 方法1.递归
    private TreeNode dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode left = dfs(root.left, p, q);
        TreeNode right = dfs(root.right, p, q);
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }

    Map<Integer, TreeNode> map = new HashMap<>();
    Set<Integer> set = new HashSet<>();
    // 方法2。存储父节点,向上找
    private TreeNode fun2(TreeNode root, TreeNode p, TreeNode q){
        saveParent(root);
        // 将p节点的所有祖先节点都放到set标记为已访问
        while (p != null) {
            set.add(p.val);
            p = map.get(p.val);
        }
        while (q != null) {
            if (set.contains(q.val)) {
                return q;
            }
            q = map.get(q.val);
        }
        return null;
    }
    private void saveParent(TreeNode root) {
        if (root.left != null) {
            map.put(root.left.val, root);
            saveParent(root.left);
        }
        if (root.right != null) {
            map.put(root.right.val, root);
            saveParent(root.right);
        }
    }
}
