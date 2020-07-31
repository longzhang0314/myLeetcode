package com.zl.leetcode.tree;

import com.zl.leetcode.TreeNode;

/**
 * 687.
 * Create by zhanglong on 2020/7/31
 */
public class LongestUnivaluePath_687 {

    public static void main(String[] args) {
        LongestUnivaluePath_687 test = new LongestUnivaluePath_687();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(5);
        int i = test.longestUnivaluePath(root);
        System.out.println(i);
    }

    int res;
    public int longestUnivaluePath(TreeNode root) {
        res = 0;
        helper(root);
        return res;
    }

    /**
     * root节点左右子树中，与root同值的较大的一条分支的边数
     * @param root
     * @param res
     * @return
     */
    private int helper(TreeNode root) {
        if (root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);

        left = root.left != null && root.left.val == root.val ? left + 1 : 0;
        right = root.right != null && root.right.val == root.val ? right + 1 : 0;

        res = Math.max(res, left + right);
        return Math.max(left, right);
    }


}
