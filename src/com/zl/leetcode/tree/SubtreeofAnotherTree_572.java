package com.zl.leetcode.tree;

import com.zl.leetcode.TreeNode;

/**
 * 572.
 * Create by zhanglong on 2020/7/31
 */
public class SubtreeofAnotherTree_572 {

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return false;
        return isSubtreeStartWithRoot(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean isSubtreeStartWithRoot(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.val != t.val) return false;
        return isSubtreeStartWithRoot(s.left, t.left) && isSubtreeStartWithRoot(s.right, t.right);
    }
}
