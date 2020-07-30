package com.zl.leetcode.tree;

import com.zl.leetcode.TreeNode;

/**
 * 110.
 * Create by zhanglong on 2020/7/30
 */
public class BalancedBinaryTree_110 {

    public boolean isBalanced(TreeNode root) {
        return maxDepth(root) != -1;
    }

    /**
     * 求树最大深度，如果左右子树高度差大于1，返回-1
     * @param root
     * @return
     */
    private int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int left = maxDepth(root.left);
        if (left == -1) return -1;
        int right = maxDepth(root.right);
        if (right == -1) return -1;
        return Math.abs(left - right) > 1 ? -1 : Math.max(left, right) + 1;
    }


}
