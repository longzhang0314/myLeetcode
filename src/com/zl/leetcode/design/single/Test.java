package com.zl.leetcode.design.single;

/**
 * Create by zhanglong on 2020/7/31
 */
public class Test {

    public static void main(String[] args) {
        Class1 class1 = Class1.newInstance();

        Class2 class2 = Class2.SINGLE;
        class2.setParam1("12231");

        Class2[] class21 = Class2.class.getEnumConstants();

    }
}
