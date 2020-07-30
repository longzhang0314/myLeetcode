package com.zl.leetcode.str;

/**
 * 205. 字符串同构
 * Create by zhanglong on 2020/7/29
 */
public class IsomorphicStrings_205 {

    public boolean isIsomorphic(String s, String t) {
        // 记录同一索引处s和t的元素上次出现的索引位置
        int[] cntS = new int[128];
        int[] cntT = new int[128];
        for (int i = 0; i < s.length(); i++) {
            char cs = s.charAt(i), ct = t.charAt(i);
            if (cntS[cs] != cntT[ct]) return false;
            // 初始化为0，防止0索引处元素和未出现元素混淆
            cntS[cs] = i + 1;
            cntT[ct] = i + 1;
        }
        return true;
    }
}
