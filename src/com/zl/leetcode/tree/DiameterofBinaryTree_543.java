package com.zl.leetcode.tree;

import com.zl.leetcode.TreeNode;

/**
 * 543. 直径
 * Create by zhanglong on 2020/7/31
 */
public class DiameterofBinaryTree_543 {

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int routeRoot = maxDepth(root.left) + maxDepth(root.right);
        return Math.max(routeRoot, Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right)));
    }

    private int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
