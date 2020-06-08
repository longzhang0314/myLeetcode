package com.zl.leetcode.binarysearch;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 *
 * 时间复杂度必须是 O(log n)
 * 如果数组中不存在目标值，返回 [-1, -1]
 * Create by zhanglong on 2020/6/8
 */
public class FindFirstAndLastPositionOfElementInSortedArray_34 {

    public static void main(String[] args) {
        FindFirstAndLastPositionOfElementInSortedArray_34 demo = new FindFirstAndLastPositionOfElementInSortedArray_34();
        int[] nums = {5, 7, 7, 8, 8, 10};
        int[] ints = demo.searchRange2(nums, 8);
        for (int i : ints) {
            System.out.print(i + " ");
        }
    }

    /**
     * 方法2:两次二分分别找到左右边界
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange2(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{-1, -1};
        int leftBound = leftBound(nums, target);
        int rightBound = leftBound == -1 ? -1 : rightBound(nums, target);
        return new int[]{leftBound, rightBound};
    }

    //---------------------------方法2 边界 方式1--------------------------------------

    private int rightBound(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        return left == 0 || nums[left - 1] != target ? -1 : left - 1;
    }

    private int leftBound(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        return left == nums.length || nums[left] != target ? -1 : left;
    }

    //---------------------------方法2 边界 方式2--------------------------------------

    private int leftBound2(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] == target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return left == nums.length || nums[left] != target ? -1 : left;
    }

    private int rightBound2(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return right == -1 || nums[right] != target ? -1 : right;
    }

    //----------------------------------------------------------------------

    /**
     * 方法1：二分，但极端情况下退化成O(N)
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange1(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{-1, -1};
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                int tmp1 = mid;
                int tmp2 = mid;
                while (tmp1 > 0 && nums[tmp1 - 1] == nums[tmp1]) tmp1--;
                while (tmp2 < nums.length - 1 && nums[tmp2 + 1] == nums[tmp2]) tmp2++;
                return new int[]{tmp1, tmp2};
            }
        }
        return new int[]{-1, -1};
    }
}
