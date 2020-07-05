package com.zl.leetcode.tree;

import com.zl.leetcode.TreeNode;

/**
 * 450.删除二叉搜索树中的节点
 *
 * 返回根节点的引用
 * 要求算法时间复杂度为 O(h)，h 为树的高度
 */
public class DeleteNodeInBST_450 {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val == key) {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            // 右子树的最小节点
            TreeNode minRight = getMin(root.right);
            root.val = minRight.val;
            root.right = deleteNode(root.right, minRight.val);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            root.left = deleteNode(root.left, key);
        }
        return root;
    }

    private TreeNode getMin(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }


}
