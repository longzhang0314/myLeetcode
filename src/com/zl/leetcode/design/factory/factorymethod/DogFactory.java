package com.zl.leetcode.design.factory.factorymethod;

import com.zl.leetcode.design.factory.Animal;
import com.zl.leetcode.design.factory.Dog;

/**
 * Create by zhanglong on 2020/7/31
 */
public class DogFactory extends Factory {
    @Override
    Animal create() {
        return new Dog();
    }
}
