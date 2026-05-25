package LeetCode.Design;

import java.util.HashMap;

public class lruCache {

    public static void main(String[] args) {

    }
}


class LRUCache {

    CacheNode head, tail;

    HashMap<Integer, CacheNode> map;

    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = null;
        this.tail = null;
    }

    public int get(int key) {
        return 0;
    }

    public void put(int key, int value) {

        if (map.containsKey(key)) {

        }

        return;
    }

    public void removeNode(CacheNode node) {
        if (node.prev != null) {
            node.prev.next = node.next;
        }
        else {
            head = node.next;
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        }
        else {
            tail = node.prev;
        }

        node.prev = null;
        node.next = null;
    }

    public void addNodeToHead(CacheNode node) {
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

class cache {

    int key;
    int value;

    public cache(int key, int value) {
        this.key = key;
        this.value = value;
    }

}

class CacheNode {

    cache cache;

    CacheNode prev;

    CacheNode next;

    public CacheNode(cache cache) {
        this.cache = cache;
        this.prev = null;
        this.next = null;
    }

}
