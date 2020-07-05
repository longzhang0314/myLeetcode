package com.zl.leetcode.tree;

import com.zl.leetcode.TreeNode;

/**
 * 222. 完全二叉树的节点个数
 * 给出一个完全二叉树，求出该树的节点个数。
 *
 * 在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，
 * 并且最下面一层的节点都集中在该层最左边的若干位置。
 *
 * 若最底层为第 h 层，则该层包含 1~ 2h 个节点。
 *
 */
public class CountCompleteTreeNodes_222 {

    /**
     * 方法1：递归
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        return countNodes(root.left) + countNodes(root.right) + 1;
    }


    /**
     * 方法2：遍历
     * @param root
     * @return
     */
    int res = 0;
    public int countNodes2(TreeNode root) {
        process(root);
        return res;
    }

    private void process(TreeNode root) {
        if (root == null) return;
        res++;
        process(root.left);
        process(root.right);
    }

}
