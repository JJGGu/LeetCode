package Hot100;

/**
 * @program: LeetCode
 * @description: 前序与中序构造二叉树
 * @author: JJGGu
 * @create: 2020-11-08 17:50
 **/
public class LC105 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    private TreeNode build(int[] pre, int preLeft, int preRight, int[] in, int inLeft, int inRight) {
        if (preLeft > preRight) {
            return null;
        }
        int index = inLeft;
        while (in[index] != pre[preLeft]) {
            index++;
        }
        TreeNode root = new TreeNode(in[index]);
        root.left = build(pre,preLeft + 1, preLeft + (index - inLeft), in, inLeft, index - 1);
        root.right = build(pre, preLeft + (index - inLeft) + 1, preRight, in, index + 1, inRight);
        return root;
    }
}
