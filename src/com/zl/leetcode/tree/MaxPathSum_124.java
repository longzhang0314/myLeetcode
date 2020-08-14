package com.zl.leetcode.tree;

import com.zl.leetcode.TreeNode;

/**
 * 124.
 * Create by zhanglong on 2020/8/13
 */
public class MaxPathSum_124 {

    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        process(root);
        return res;
    }

    private int process(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = Math.max(process(root.left), 0);
        int rightMax = Math.max(process(root.right), 0);
        res = Math.max(res, root.val + leftMax + rightMax);
        return root.val + Math.max(leftMax, rightMax);
    }
}
