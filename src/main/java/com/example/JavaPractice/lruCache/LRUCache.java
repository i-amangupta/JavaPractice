package com.example.JavaPractice.lruCache;

public class LRUCache {
    class Node {
        int key;
        int value;
        long timeStamp;

        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.timeStamp = System.currentTimeMillis();
        }
    }

    private int capacity;
    private int size;

    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;

        head = null;
        tail = null;
    }

    public int get(int key) {
        // If key is present then update the timestamp move it to front and return value

        // Otherwise return -1
        return -1;
    }

    public void put(int key, int value) {
        Node current = head;

        if(size == capacity) {
            // Remove the last node
        }

        // If key is already present then replace the value and timestamp

        // Otherwise add it in Cache
    }
}
