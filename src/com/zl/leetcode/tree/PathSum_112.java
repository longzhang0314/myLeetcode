package com.zl.leetcode.tree;

import com.zl.leetcode.TreeNode;

/**
 * 112.
 * Create by zhanglong on 2020/7/31
 */
public class PathSum_112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.val == sum && root.left == null && root.right == null) return true;
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

}
