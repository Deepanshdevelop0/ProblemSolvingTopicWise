package Design;

import java.util.ArrayList;
import java.util.HashMap;

public class LRU_CACHE {
    public static void main(String[] args) {

        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1); // cache is {1=1}
        lruCache.put(2, 2); // cache is {1=1, 2=2}
        System.out.println(lruCache.get(1));    // return 1
        lruCache.put(3, 3); // LRU key 2 is evicted, cache is {1=1, 3=3}
        System.out.println(lruCache.get(2));    // returns -1 (not found)
        lruCache.put(4, 4); // LRU key 1 is evicted, cache is {4=4, 3=3}
        System.out.println(lruCache.get(1));    // returns -1 (not found)
        System.out.println(lruCache.get(3));    // return 3
        System.out.println(lruCache.get(4));    // return 4

    }

}

class LRUCache {

    private Node head, tail;
    private HashMap<Integer, Node> cacheMap;

    private Integer capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = null;
        tail = null;
        cacheMap = new HashMap<>();
    }

    public int get(int key) {

        Node node = cacheMap.getOrDefault(key, null);

        if (node == null) {
            return -1;
        }

        removeNode(node);
        addToHead(node);

        return cacheMap.get(key).data.val;
    }

    public void put(int key, int value) {

        if (cacheMap.containsKey(key)) {
            Node curr = cacheMap.get(key);
            curr.data.val = value;
            removeNode(curr);
            addToHead(curr);
        }

        if (cacheMap.size() >= capacity) {
            cacheMap.remove(tail.data.key);
            removeNode(tail);
        }


        Cache cache = new Cache(key, value);

        Node newNode = new Node(cache);

        // set new node as head
        addToHead(newNode);
        cacheMap.put(key, newNode);
    }

    private void removeNode(Node node) {
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next;
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            tail = node.prev;
        }

        node.next = null;
        node.prev = null;
    }

    private void addToHead(Node node) {
        node.next = head;
        node.prev = null;

        if (head != null) {
            head.prev = node;
        }
        head = node;

        if (tail == null) {
            tail = head;
        }
    }

}

class Cache {
    int key;
    int val;

    public Cache(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class Node {
    Cache data;
    Node next;
    Node prev;

    public Node(Cache data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}
