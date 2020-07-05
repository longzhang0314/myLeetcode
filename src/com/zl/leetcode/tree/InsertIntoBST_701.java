package com.zl.leetcode.tree;

import com.zl.leetcode.TreeNode;

/**
 * 701. 二叉搜索树中的插入操作
 */
public class InsertIntoBST_701 {


    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (root.val < val) {
            root.right = insertIntoBST(root.right, val);
        } else if (root. val > val) {
            root.left = insertIntoBST(root.left, val);
        }
        return root;
    }
}
