package com.zl.leetcode.array;

/**
 * 27. 移除元素
 *
 * 原数组无序
 * 原地移除,空间O(1)
 * 新数组不用考虑移除后新数组长度之后的元素，新数组长度之前的元素可无序
 * Create by zhanglong on 2020/6/8
 */
public class RemoveElement_27 {

    /**
     * 方法1：逐个遍历，往新数组索引赋值，类似26题方法1
     * @param nums
     * @param val
     * @return
     */
    public int removeElement1(int[] nums, int val) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != val) {
                nums[idx++] = nums[i];
            }
        }
        return idx;
    }

    /**
     * 方法2：头尾指针
     * 等于val的元素放到尾部
     * @param nums
     * @param val
     * @return
     */
    public int removeElement2(int[] nums, int val) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int head = 0, tail = n - 1;
        while (head <= tail) {
            if (nums[head] == val) {
                nums[head] = nums[tail];
                nums[tail] = val;
                tail--;
                head--;
            }
            head++;
        }
        return head;
    }
}
