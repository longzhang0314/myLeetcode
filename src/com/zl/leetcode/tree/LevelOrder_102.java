package com.zl.leetcode.tree;

import com.zl.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 102. 二叉树层序遍历
 * Create by zhanglong on 2020/8/13
 */
public class LevelOrder_102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>(0);
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll == null) continue;
                list.add(poll.val);
                if (poll.left != null) queue.offer(poll.left);
                if (poll.right != null) queue.offer(poll.right);
            }
            if (list.size() > 0) res.add(list);
        }
        return res;
    }
}
