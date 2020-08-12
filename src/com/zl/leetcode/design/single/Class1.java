package com.zl.leetcode.design.single;

/**
 * Create by zhanglong on 2020/7/31
 */
public class Class1 {

    private Class1() {}

    private static class Holder {
        private static final Class1 CLASS_1 = new Class1();
    }

    public static Class1 newInstance() {
        return Holder.CLASS_1;
    }


}
