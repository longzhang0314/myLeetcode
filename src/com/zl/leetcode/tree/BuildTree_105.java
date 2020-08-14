package com.zl.leetcode.tree;

import com.zl.leetcode.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 105.前序，中序
 *
 * 所有节点值不重复
 * Create by zhanglong on 2020/8/14
 */
public class BuildTree_105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) return null;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0 ; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
    }

    private TreeNode buildTree(int[] preorder, int ps, int pe, int[] inorder, int is, int ie, Map<Integer, Integer> map) {
        if (ps > pe) return null;
        int rootVal = preorder[ps];
        TreeNode root = new TreeNode(rootVal);
//        int iIdx = 0;
//        for (int i = is; i <= ie; i++) {
//            if (inorder[i] == rootVal) {
//                iIdx = i;
//            }
//        }
        int iIdx = map.get(rootVal);
        int leftNum = iIdx - is;
        root.left = buildTree(preorder, ps + 1, ps + leftNum, inorder, is, iIdx - 1, map);
        root.right = buildTree(preorder, ps + leftNum + 1, pe, inorder, iIdx + 1, ie, map);
        return root;
    }


}
