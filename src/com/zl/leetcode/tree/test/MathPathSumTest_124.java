package com.zl.leetcode.tree.test;

import com.zl.leetcode.TreeNode;

/**
 * Create by zhanglong on 2020/8/24
 */
public class MathPathSumTest_124 {

    int max = 0;
    public int maxPathSum(TreeNode root) {
        if (root != null) {
            max = Math.max(max, root.val);
        }
        process(root);
        return max;
    }

    // 返回单条路径最大值
    private int process(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(process(root.left), 0);
        int right = Math.max(process(root.right), 0);
        max = Math.max(max, root.val + left + right);
        return root.val + Math.max(left, right);
    }
}
