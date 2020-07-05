package com.zl.leetcode.tree;

import com.zl.leetcode.TreeNode;

/**
 * 在BST中查找一个数是否存在
 */
public class FindValFromBST {

    /**
     * 方法1：二叉树框架
     * @param root
     * @param target
     * @return
     */
    public boolean isInBST(TreeNode root, int target) {
        if (root == null) return false;
        if (root.val == target) return true;
        return isInBST(root.left, target) || isInBST(root.right, target);
    }


    /**
     * 方法2：二叉搜索特性
     * @param root
     * @param target
     * @return
     */
    public boolean isInBST2(TreeNode root, int target) {
        if (root == null) return false;
        if (root.val == target) return true;
        return root.val < target ? isInBST2(root.right, target) : isInBST2(root.left, target);
    }


}
