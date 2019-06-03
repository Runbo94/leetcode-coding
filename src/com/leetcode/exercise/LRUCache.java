package com.leetcode.exercise;

import java.util.HashMap;
import java.util.Map;

class LRUCache {
    public static void main(String[] args) {
        String[] methods = { "LRUCache", "put", "put", "put", "put", "put", "get", "put", "get", "get", "put", "get",
                "put", "put", "put", "get", "put", "get", "get", "get", "get", "put", "put", "get", "get", "get", "put",
                "put", "get", "put", "get", "put", "get", "get", "get", "put", "put", "put", "get", "put", "get", "get",
                "put", "put", "get", "put", "put", "put", "put", "get", "put", "put", "get", "put", "put", "get", "put",
                "put", "put", "put", "put", "get", "put", "put", "get", "put", "get", "get", "get", "put", "get", "get",
                "put", "put", "put", "put", "get", "put", "put", "put", "put", "get", "get", "get", "put", "put", "put",
                "get", "put", "put", "put", "get", "put", "put", "put", "get", "get", "get", "put", "put", "put", "put",
                "get", "put", "put", "put", "put", "put", "put", "put" };
        int[][] parameters = { { 10 }, { 10, 13 }, { 3, 17 }, { 6, 11 }, { 10, 5 }, { 9, 10 }, { 13 }, { 2, 19 }, { 2 },
                { 3 }, { 5, 25 }, { 8 }, { 9, 22 }, { 5, 5 }, { 1, 30 }, { 11 }, { 9, 12 }, { 7 }, { 5 }, { 8 }, { 9 },
                { 4, 30 }, { 9, 3 }, { 9 }, { 10 }, { 10 }, { 6, 14 }, { 3, 1 }, { 3 }, { 10, 11 }, { 8 }, { 2, 14 },
                { 1 }, { 5 }, { 4 }, { 11, 4 }, { 12, 24 }, { 5, 18 }, { 13 }, { 7, 23 }, { 8 }, { 12 }, { 3, 27 },
                { 2, 12 }, { 5 }, { 2, 9 }, { 13, 4 }, { 8, 18 }, { 1, 7 }, { 6 }, { 9, 29 }, { 8, 21 }, { 5 },
                { 6, 30 }, { 1, 12 }, { 10 }, { 4, 15 }, { 7, 22 }, { 11, 26 }, { 8, 17 }, { 9, 29 }, { 5 }, { 3, 4 },
                { 11, 30 }, { 12 }, { 4, 29 }, { 3 }, { 9 }, { 6 }, { 3, 4 }, { 1 }, { 10 }, { 3, 29 }, { 10, 28 },
                { 1, 20 }, { 11, 13 }, { 3 }, { 3, 12 }, { 3, 8 }, { 10, 9 }, { 3, 26 }, { 8 }, { 7 }, { 5 },
                { 13, 17 }, { 2, 27 }, { 11, 15 }, { 12 }, { 9, 19 }, { 2, 15 }, { 3, 16 }, { 1 }, { 12, 17 }, { 9, 1 },
                { 6, 19 }, { 4 }, { 5 }, { 5 }, { 8, 1 }, { 11, 7 }, { 5, 2 }, { 9, 28 }, { 1 }, { 2, 2 }, { 7, 4 },
                { 4, 22 }, { 7, 24 }, { 9, 26 }, { 13, 28 }, { 11, 26 } };
        LRUCache cache = new LRUCache(parameters[0][0]);
        for (int i = 1; i < methods.length; i++) {
            if (methods[i].equals("put")) {
                cache.put(parameters[i][0], parameters[i][1]);
                System.out.println("null");
            } else if (methods[i].equals("get")) {
                System.out.println(cache.get(parameters[i][0]));
            }
        }
    }

    private int capacity;
    private int length;
    private DoubleLinkedList head = new DoubleLinkedList(-1, -1);
    private DoubleLinkedList tail = new DoubleLinkedList(-1, -1);
    private Map<Integer, DoubleLinkedList> map = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.length = 0;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {

        // get the value
        int returnVal = map.containsKey(key) ? map.get(key).val : -1;

        // update the linked list
        if (map.containsKey(key)) {
            DoubleLinkedList gotNode = map.get(key);
            DoubleLinkedList prev = gotNode.prev;
            DoubleLinkedList next = gotNode.next;
            prev.next = next;
            next.prev = prev;

            DoubleLinkedList headNext = head.next;
            head.next = gotNode;
            headNext.prev = gotNode;
            gotNode.prev = head;
            gotNode.next = headNext;
        }

        return returnVal;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            DoubleLinkedList node = map.get(key);
            System.out.print(node.val + " ");
            node.val = value;

            // update the linked list
            // delete
            DoubleLinkedList prev = node.prev;
            DoubleLinkedList next = node.next;
            prev.next = next;
            next.prev = prev;
            // add it after the head node
            DoubleLinkedList headNext = head.next;
            head.next = node;
            headNext.prev = node;
            node.next = headNext;
            node.prev = head;
            return;
        }

        DoubleLinkedList valueNode = new DoubleLinkedList(key, value);
        map.put(key, valueNode);
        if (length < capacity) {
            // linked list
            DoubleLinkedList headNext = head.next;
            head.next = valueNode;
            valueNode.next = headNext;
            headNext.prev = valueNode;
            valueNode.prev = head;

            length++;
        } else {
            map.remove(tail.prev.key);
            // delete the least recent used node from the linked list
            DoubleLinkedList tailPrevPrev = tail.prev.prev;
            tailPrevPrev.next = tail;
            tail.prev = tailPrevPrev;
            // add the new value just after the head node
            DoubleLinkedList headNext = head.next;
            head.next = valueNode;
            valueNode.next = headNext;
            headNext.prev = valueNode;
            valueNode.prev = head;
        }
    }
}

class DoubleLinkedList {
    public int val;
    public int key;
    public DoubleLinkedList prev;
    public DoubleLinkedList next;

    public DoubleLinkedList(int key, int val) {
        this.key = key;
        this.val = val;
        this.prev = null;
    }
}
/**
 * Your LRUCache object will be instantiated and called as such: LRUCache obj =
 * new LRUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
 */