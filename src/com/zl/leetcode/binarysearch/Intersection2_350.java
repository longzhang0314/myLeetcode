package com.zl.leetcode.binarysearch;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 350. 两个数组的交集2
 *
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 * Create by zhanglong on 2020/6/11
 */
public class Intersection2_350 {

    public static void main(String[] args) {
        Intersection2_350 demo = new Intersection2_350();
        int[] res = demo.intersect(new int[]{1,2,2,1}, new int[]{2,2});
        for (int i : res) {
            System.out.println(i);
        }
    }

    /**
     * 方法1：hash表存储一个数组的元素和个数
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        // 较小的存放hash表，减少内存消耗
        return nums1.length < nums2.length
                ? inter(nums1, nums2)
                : inter(nums2, nums1);
    }

    private int[] inter(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            Integer value = map.getOrDefault(num, 0);
            map.put(num, value + 1);
        }
        int[] res = new int[nums1.length];
        int cnt = 0;
        for (int num : nums2) {
            if (map.containsKey(num) && map.get(num) > 0) {
                res[cnt++] = num;
                map.put(num, map.get(num) - 1);
            }
        }
        return Arrays.copyOf(res, cnt);
    }
}
