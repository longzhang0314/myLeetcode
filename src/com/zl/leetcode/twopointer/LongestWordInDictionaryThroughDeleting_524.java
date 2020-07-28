package com.zl.leetcode.twopointer;

import java.util.List;

/**
 * 524.通过删除字母匹配到字典里最长单词
 * Create by zhanglong on 2020/7/28
 */
public class LongestWordInDictionaryThroughDeleting_524 {

    /**
     * 方法1：双指针
     *
     * @param s
     * @param d
     * @return
     */
    public String findLongestWord(String s, List<String> d) {
        String str = "";
        for (String sstr : d) {
            for (int i = 0, j = 0; i < s.length() && j < sstr.length(); i++) {
                // 相等后移，不相等只有i后移相当于删除当前i的位置
                if (s.charAt(i) == sstr.charAt(j)) j++;
                // 如果i走完j没走完，当前子串不会被替换
                // j走完，判断和全局对比是否是最优解
                if (j == sstr.length()) {
                    if (sstr.length() > str.length() || (sstr.length() == str.length() && sstr.compareTo(str) < 0)) {
                        str = sstr;
                    }
                }
            }
        }
        return str;
    }

}
