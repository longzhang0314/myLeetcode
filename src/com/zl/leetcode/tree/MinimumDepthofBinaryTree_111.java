package com.zl.leetcode.tree;

import com.zl.leetcode.TreeNode;

/**
 * 111.
 * Create by zhanglong on 2020/7/31
 */
public class MinimumDepthofBinaryTree_111 {

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return left == 0 || right == 0 ? left + right + 1 : Math.min(left, right) + 1;
    }
}
