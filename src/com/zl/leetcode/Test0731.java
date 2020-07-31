package com.zl.leetcode;

/**
 * Create by zhanglong on 2020/7/31
 */
public class Test0731 {

    public static void main(String[] args) {
        Test0731 test = new Test0731();

    }

    public boolean isBalanced(TreeNode root) {
        return maxDepth(root) != -1;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int left = maxDepth(root.left);
        if (left == -1) return -1;
        int right = maxDepth(root.right);
        if (right == -1) return -1;
        return Math.abs(left - right) > 1 ? -1 : Math.max(left, right) + 1;
    }


}
