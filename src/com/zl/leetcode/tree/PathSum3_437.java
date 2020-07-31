package com.zl.leetcode.tree;

import com.zl.leetcode.TreeNode;

/**
 * 437.
 * Create by zhanglong on 2020/7/31
 */
public class PathSum3_437 {

    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return pathSumRoot(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private int pathSumRoot(TreeNode root, int sum) {
        if (root == null) return 0;
        int res = 0;
        if (root.val == sum) {
            res++;
        }
        res += pathSum(root.left, sum - root.val) + pathSum(root.right, sum - root.val);
        return res;
    }
}
