package com.zl.leetcode.lru;

import java.util.HashMap;
import java.util.Map;

/**
 * Create by zhanglong on 2020/8/18
 */
public class LRUTest {

    private int capacity;
    private Map<Integer, Node> map;
    private DoubleList cache;

    public LRUTest(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.cache = new DoubleList();
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node node = map.get(key);
        put(key, node.val);
        return node.val;
    }

    public void put(int key, int val) {
        Node newNode = new Node(key, val);
        if (map.containsKey(key)) {
            // remove
            cache.remove(map.get(key));
            // put
            cache.addFirst(newNode);
            map.put(key, newNode);
        } else {
            if (cache.size() == capacity) {
                // removeLast
                Node last = cache.removeLast();
                map.remove(last.key);
            }
            cache.addFirst(newNode);
            map.put(key, newNode);
        }
    }

    class DoubleList {
        private Node head;
        private Node tail;
        private int size;
        DoubleList() {
            this.head = new Node(-1, -1);
            this.tail = new Node(-1, -1);
            head.next = tail;
            tail.pre = head;
            size = 0;
        }

        public void addFirst(Node node) {
            node.next = head.next;
            head.next.pre = node;
            node.pre = head;
            head.next = node;
            size++;
        }

        public void remove(Node node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
            size--;
        }

        public Node removeLast() {
            Node last = tail.pre;
            if (last == head) return null;
            remove(last);
            return last;
        }

        public int size() {
            return size;
        }
    }

    class Node {
        int key;
        int val;
        Node pre;
        Node next;
        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}
