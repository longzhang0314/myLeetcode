package com.zl.leetcode.twopointer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 345. 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 * Create by zhanglong on 2020/7/27
 */
public class ReverseVowelsOfAString_345 {

    public static void main(String[] args) {
        String hello = reverseVowels("hello");
        System.out.println(hello);
    }

    private static final Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
    public static String reverseVowels(String s) {
        if (s == null || s.length() == 0) return s;
        int i = 0, j = s.length() - 1;
        char[] cc = new char[s.length()];
        // 此处i==j是为了给cc数组赋值
        while (i <= j) {
            char ii = s.charAt(i);
            char jj = s.charAt(j);
            if (!set.contains(ii)) {
                cc[i++] = ii;
            } else if (!set.contains(jj)) {
                cc[j--] = jj;
            } else {
                cc[i++] = jj;
                cc[j--] = ii;
            }
        }
        return new String(cc);
    }
}
