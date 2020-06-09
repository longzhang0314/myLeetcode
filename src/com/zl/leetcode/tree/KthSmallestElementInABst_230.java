package com.zl.leetcode.tree;

import com.zl.leetcode.TreeNode;

/**
 * 二叉搜索树中第K小的元素
 * K从1开始计数
 * Create by zhanglong on 2020/6/9
 */
public class KthSmallestElementInABst_230 {

    int level;
    int res;
    public int kthSmallest(TreeNode root, int k) {
        pro(root, k);
        return res;
    }

    private void pro(TreeNode root, int k) {
        if (root == null) return;
        pro(root.left, k);
        if (++level == k) {
            res = root.val;
            return;
        }
        pro(root.right, k);
    }

}
