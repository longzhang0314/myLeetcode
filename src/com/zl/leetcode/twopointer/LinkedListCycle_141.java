package com.zl.leetcode.twopointer;

import com.zl.leetcode.ListNode;

/**
 * 141. 判断链表是否有环
 * Create by zhanglong on 2020/7/28
 */
public class LinkedListCycle_141 {

    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }
}
