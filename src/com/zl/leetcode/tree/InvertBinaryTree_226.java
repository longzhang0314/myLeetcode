package com.zl.leetcode.tree;

import com.zl.leetcode.TreeNode;

/**
 * 226.
 * Create by zhanglong on 2020/7/31
 */
public class InvertBinaryTree_226 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
