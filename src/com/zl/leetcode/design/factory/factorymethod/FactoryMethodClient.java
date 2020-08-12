package com.zl.leetcode.design.factory.factorymethod;

import com.zl.leetcode.design.factory.Animal;

/**
 * Create by zhanglong on 2020/8/3
 */
public class FactoryMethodClient {

    public static void main(String[] args) {
        Factory factory = new DogFactory();
        Animal animal = factory.create();

    }
}
