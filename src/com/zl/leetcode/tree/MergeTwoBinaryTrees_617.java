package com.zl.leetcode.tree;

import com.zl.leetcode.TreeNode;

/**
 * 617.
 * Create by zhanglong on 2020/7/31
 */
public class MergeTwoBinaryTrees_617 {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return null;
        TreeNode root = null;
        if (t1 == null) {
            return t2;
        } else if (t2 == null) {
            return t1;
        } else {
            root = new TreeNode(t1.val + t2.val);
        }
        root.left = mergeTrees(t1.left, t2.left);
        root.right = mergeTrees(t1.right, t2.right);
        return root;
    }

}
