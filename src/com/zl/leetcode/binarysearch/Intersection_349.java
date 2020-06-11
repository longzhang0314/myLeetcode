package com.zl.leetcode.binarysearch;

import java.util.*;

/**
 * 349. 两个数组的交集
 *
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 * Create by zhanglong on 2020/6/11
 */
public class Intersection_349 {

    /**
     * 方法1：暴力法 + hash表去重
     * 时间O(M*N), 空间O(N)
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection1(int[] nums1, int[] nums2) {
        int[] res = new int[Math.min(nums1.length, nums2.length)];
        int cnt = 0;
        Set<Integer> set = new HashSet<>();
        for (int i : nums1) {
            for (int j : nums2) {
                if (i == j && set.add(i)) {
                    res[cnt++] = i;
                    break;
                }
            }
        }
        return Arrays.copyOf(res, cnt);
    }

    /**
     * 方法2：两个hash表分别存储两个数组信息，判定是否存在并添加到结果集
     * 时间O(M+N),空间O(M+N)
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection2(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i : nums1) set1.add(i);
        for (int j : nums2) {
            if (set1.contains(j)) set2.add(j);
        }
        int[] res = new int[set2.size()];
        int cnt = 0;
        for (int i : set2) res[cnt++] = i;
        return res;
    }



    /**
     * 方法3：内置函数 retainAll()求交集
     * 时间O(M+N),空间O(M+N)
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection3(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int i : nums1) set1.add(i);
        Set<Integer> set2 = new HashSet<>();
        for (int j : nums2) set2.add(j);

        set1.retainAll(set2);

        int[] res = new int[set1.size()];
        int cnt = 0;
        for (int i : set1) res[cnt++] = i;

        return res;
    }

    /**
     * 方法4：二分查找
     * 时间O(MlogN) 空间O(N)
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection4(int[] nums1, int[] nums2) {
        return nums1.length < nums2.length ? inter4(nums1, nums2) : inter4(nums2, nums1);
    }

    // num1长度小于num2
    private int[] inter4(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Set<Integer> set = new HashSet<>();
        for (int i : nums2) {
            if (binarySearch(nums1, i)) set.add(i);
        }
        int[] res = new int[set.size()];
        int cnt = 0;
        for (int i : set) res[cnt++] = i;
        return res;
    }

    private boolean binarySearch(int[] nums1, int i) {
        int left = 0, right = nums1.length - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (nums1[mid] == i) return true;
            else if (nums1[mid] < i) left = mid + 1;
            else right =mid - 1;
        }
        return false;
    }


    /**
     * 方法5：双指针
     * 时间O(N*logN) 空间O(N)
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection5(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;
        Set<Integer> set = new HashSet<>();
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                set.add(nums1[i++]);
                j++;
            } else if (nums1[i] < nums2[j]) i++;
            else j++;
        }
        int[] res = new int[set.size()];
        int cnt = 0;
        for (int num : set) res[cnt++] = num;
        return res;
    }
}
