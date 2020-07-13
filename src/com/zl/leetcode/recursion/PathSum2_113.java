package com.zl.leetcode.recursion;

import com.zl.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 113. 路径总和2
 *
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 */
public class PathSum2_113 {

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) return res;
        processs(root, sum, new ArrayList<Integer>());
        return res;
    }

    private void processs(TreeNode root, int sum, ArrayList<Integer> list) {
        if (root == null) return;
        // 当前节点加入进行中路径
        list.add(root.val);
        if (root.left == null && root.right == null && root.val == sum) {
            // 如果是叶子节点且路径之和等于sum
            res.add(new ArrayList<>(list));
        } else {
            // 继续向下探索
            processs(root.left, sum - root.val, list);
            processs(root.right, sum - root.val, list);
        }
        //恢复现场，不选择当前分支
        list.remove(list.size() - 1);
    }


}
