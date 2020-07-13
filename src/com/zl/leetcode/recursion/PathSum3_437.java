package com.zl.leetcode.recursion;

import com.zl.leetcode.TreeNode;

/**
 * 437. 路径总和
 *
 * 给定一个二叉树，它的每个结点都存放着一个整数值。
 * 找出路径和等于给定数值的路径总数。
 *
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 */
public class PathSum3_437 {

    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        // 包含root节点的路径总和 + 左子树路径总和 + 右子树路径总和 (换种说法：包含根节点的路径和 + 不包含根节点的路径和)
        return count(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    /**
     * 路径包含root的路径总和
     * @param root
     * @param sum
     * @return
     */
    private int count(TreeNode root, int sum) {
        if (root == null) return 0;
        int res = root.val == sum ? 1 : 0;
        return res + count(root.left, sum - root.val) + count(root.right, sum - root.val);
    }
}
