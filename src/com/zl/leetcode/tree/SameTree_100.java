package com.zl.leetcode.tree;


import com.zl.leetcode.TreeNode;

/**
 * 100. 给定两个二叉树，编写一个函数来检验它们是否相同。
 */
public class SameTree_100 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if ((p != null && q == null) || (p == null && q != null)) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
