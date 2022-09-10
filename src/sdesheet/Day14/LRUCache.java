package sdesheet.Day14;

import java.util.*;

class Node {
    int val;
    int key;
    Node prev;
    Node next;
    
    public Node(int key, int val) {
        this.val = val;
        this.key = key;
        this.next = null;
        this.prev = null;
    }
}

public class LRUCache {
    Map<Integer, Node> map;
    int capacity;
    Node head = new Node(0, 0);
    Node tail = new Node(0, 0);
    
    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            Node temp = map.get(key);
            remove(temp);
            insert(temp);
            return temp.val;
        }
        else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key))
            remove(map.get(key));
        
        if (map.size() == capacity)
            remove(tail.prev);
        
        insert(new Node(key, value));
    }
    
    private void remove(Node node) {
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    private void insert(Node node) {
        map.put(node.key, node);
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }
}
