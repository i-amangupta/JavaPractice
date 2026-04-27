package com.example.JavaPractice.lruCache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private Map<Integer, Node> map;

    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;

        map = new HashMap<>();

        head = new Node(0,0);
        tail = new Node(0,0);

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if(!map.containsKey(key))
            return -1;

        Node node = map.get(key);

        // remove that key
        remove(node);
        // insert it at front
        insertAtFront(node);

        return node.value;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)) {
            remove(map.get(key));
        }

        if(map.size() == capacity) {
            Node lru = tail.prev;
            // remove lru
            remove(lru);
            map.remove(lru.key);
        }

        Node newNode = new Node(key, value);
        // insert at front
        insertAtFront(newNode);
        map.put(key, newNode);
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insertAtFront(Node node) {
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;

    }

    public void print() {
        Node curr = head.next;

        while (curr != tail) {
            System.out.println(curr.key + " " + curr.value);
            curr = curr.next;
        }

        System.out.println();
    }

    public static void main(String... args) {
        LRUCache cache = new LRUCache(3);

        cache.put(1, 5);
        cache.print();

        cache.put(2, 10);
        cache.print();

        cache.put(3, 15);
        cache.print();

        cache.get(1);
        cache.print();

        cache.put(4, 20);
        cache.print();
    }
}