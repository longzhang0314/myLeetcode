package com.zl.leetcode.tree;

import com.zl.leetcode.TreeNode;

/**
 * 104.
 * Create by zhanglong on 2020/7/30
 */
public class MaximuDepthofBinaryTree_104 {

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

}
