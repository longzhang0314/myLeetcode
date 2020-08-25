package com.zl.leetcode.tree.test;

import com.zl.leetcode.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Create by zhanglong on 2020/8/24
 */
public class BuildTreeTest_105 {

    /**
     * 前序遍历 preorder = [3,9,20,15,7]
     * 中序遍历 inorder = [9,3,15,20,7]
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) return null;
        Map<Integer, Integer> idxMap = new HashMap<>();
        int n = preorder.length;
        for (int i = 0; i < n; i++) {
            idxMap.put(inorder[i], i);
        }
        return buildTree(preorder, 0, n - 1, inorder, 0, n - 1, idxMap);
    }

    private TreeNode buildTree(int[] preorder, int ps, int pe, int[] inorder, int is, int ie, Map<Integer, Integer> idxMap) {
        if (ps > pe || is > ie) return null;
        TreeNode root = new TreeNode(preorder[ps]);
        int rootIdx = idxMap.get(preorder[ps]);
        int leftNum = rootIdx - is;

        root.left = buildTree(preorder, ps + 1, ps + leftNum, inorder, is, rootIdx - 1, idxMap);
        root.right = buildTree(preorder, ps + leftNum + 1, pe, inorder, rootIdx + 1, ie, idxMap);
        return root;
    }


}
