package com.zl.leetcode.tree;

import com.zl.leetcode.TreeNode;

/**
 * 404.
 * Create by zhanglong on 2020/7/31
 */
public class SumofLeftLeaves_404 {

    int res = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        process(root.left, 0);
        process(root.right, 1);
        return res;
    }

    private void process(TreeNode root, int flag) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            if (flag == 0) {
                res += root.val;
            }
            return;
        }
        process(root.left, 0);
        process(root.right,  1);
    }


}
