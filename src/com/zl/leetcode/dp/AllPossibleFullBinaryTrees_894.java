package com.zl.leetcode.dp;

import com.zl.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 894.所有可能的满二叉树
 * <p>
 * <p>
 * TODO
 * Create by zhanglong on 2020/6/15
 */
public class AllPossibleFullBinaryTrees_894 {
    /**
     * 递归
     * @param N
     * @return
     */
    public List<TreeNode> allPossibleFBT(int N) {
        // N为偶数不可能是满二叉树
        if ((N & 1) == 0) return new ArrayList<>(0);
        List<TreeNode> trees = new ArrayList<>(N);
        if (N == 1) {
            trees.add(new TreeNode(0));
            return trees;
        }
        --N;
        for (int i = 1; i < N; i += 2) {
            // 此处N已经减去根节点占用的一个
            // 1 和 N - 1的分配，左子树分配i个，右子树分配N - i(实际为总个数 - 1 - i, 因为根节点已经占用掉一个)
            // 这里的list存储着分配i个节点后 左子树的所有情况
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(N - i);
            for (TreeNode nodeL : left) {
                for (TreeNode nodeR : right) {
                    TreeNode root = new TreeNode(0);
                    root.left = nodeL;
                    root.right = nodeR;
                    trees.add(root);
                }
            }
        }
        return trees;
    }

}
