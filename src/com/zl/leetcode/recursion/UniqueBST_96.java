package com.zl.leetcode.recursion;

/**
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 * Create by zhanglong on 2020/7/27
 */
public class UniqueBST_96 {

    /**
     * 重复子问题 memo写法省略
     * @param n
     * @return
     */
    public int numTrees(int n) {
        if (n <= 1) return 1;
        int res = 0;
        // 当前根节点可选[1, n]
        // 左子树剩余个数i = [0, n - 1]
        for (int i = 0; i < n; i++) {
            int left = numTrees(i);
            // 右子树可选的节点有几个? n - i - 1
            int right = numTrees(n - i - 1);
            res += left * right;
        }
        return res;
    }
}
