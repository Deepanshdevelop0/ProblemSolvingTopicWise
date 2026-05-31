package LeetCode.Design;

import java.util.HashMap;

public class LRUCache_Impl {

    public static void main(String[] args) {
        // Create cache with capacity 2
        LRUCache cache = new LRUCache(2);

        // Put values in cache
        cache.put(1, 1);
        cache.put(2, 2);

        // Get value for key 1
        System.out.println(cache.get(1));

        // Insert another key (evicts key 2)
        cache.put(3, 3);

        // Key 2 should be evicted
        System.out.println(cache.get(2));

        // Insert another key (evicts key 1)
        cache.put(4, 4);

        // Key 1 should be evicted
        System.out.println(cache.get(1));

        // Key 3 should be present
        System.out.println(cache.get(3));

        // Key 4 should be present
        System.out.println(cache.get(4));
    }
}


class LRUCache {

    CacheNode head, tail;

    HashMap<Integer, CacheNode> map;

    int capacity;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        head = new CacheNode(-1, -1);
        tail = new CacheNode(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {

        // If key exists in cache
        if (map.containsKey(key)) {
            CacheNode curr = map.get(key);

            // Remove old mapping
            map.remove(key);

            // Move accessed node to front
            removeNode(curr);
            addNode(curr);

            // Update map
            map.put(key, curr);

            return curr.val;
        }

        return -1;
    }

    public void put(int key, int value) {
        // If key already exists
        if (map.containsKey(key)) {
            CacheNode curr = map.get(key);
            map.remove(key);
            removeNode(curr);
        }

        // If capacity reached
        if (map.size() == capacity) {
            map.remove(tail.prev.key);
            removeNode(tail.prev);
        }

        // Insert new node at front
        addNode(new CacheNode(key, value));
        map.put(key, head.next);
    }


    // Method to remove a given node from list
    public void removeNode(CacheNode node) {
        CacheNode nodePrev = node.prev;
        CacheNode nodeNext = node.next;

        nodePrev.next = nodeNext;
        nodeNext.prev = nodePrev;
    }

    // Method to add a node right after head
    public void addNode(CacheNode node) {
        CacheNode temp = head.next;
        node.prev = head;
        node.next = temp;
        head.next = node;
        temp.prev = node;
    }


}


class CacheNode {

    int key;

    int val;

    CacheNode prev;
    CacheNode next;

    public CacheNode(int key, int val) {
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}
