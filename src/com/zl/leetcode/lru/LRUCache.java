package com.zl.leetcode.lru;

import java.util.HashMap;
import java.util.Map;

/**
 * 146
 *
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 * Create by zhanglong on 2020/8/18
 */
public class LRUCache {

    private Map<Integer, Node> map;
    private DoubleList doubleList;
    private int capacity;

    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.doubleList = new DoubleList();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        int val = map.get(key).val;
        put(key, val);
        return val;
    }

    public void put(int key, int value) {
        Node newNode = new Node(key, value);
        if (map.containsKey(key)) {
            doubleList.remove(map.get(key));
            doubleList.addFirst(newNode);
            map.put(key, newNode);
        } else {
            if (doubleList.size() == capacity) {
                Node node = doubleList.removeLast();
                map.remove(node.key);
            }
            doubleList.addFirst(newNode);
            map.put(key, newNode);
        }
    }



    private static class DoubleList {
        private Node head;
        private Node tail;
        private int size;

        DoubleList() {
            this.head = new Node(-1, -1);
            this.tail = new Node(-1, -1);
            head.next = tail;
            tail.pre = head;
            this.size = 0;
        }

        public void addFirst(Node node) {
            node.next = head.next;
            node.next.pre = node;
            head.next = node;
            node.pre = head;
            size++;
        }

        public void remove(Node node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
            size--;
        }

        public Node removeLast() {
            if (tail.pre == head) return null;
            Node remove = tail.pre;
            remove(remove);
            return remove;
        }

        public int size() {
            return size;
        }


    }

    private static class Node {
        public int key;
        public int val;
        public Node pre;
        public Node next;
        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}


