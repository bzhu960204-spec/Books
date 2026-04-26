package LeetCode.TopInterviewQuestions;

import java.util.HashMap;
import java.util.Map;

/**
 * 非最佳解法
 * 将固定的方法抽离出来单独实现，可以使得代码更加简洁
 * 使用Map 提升查询效率
 */
public class Q146 {
    /*
    Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

    Implement the LRUCache class:

    LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
    int get(int key) Return the value of the key if the key exists, otherwise return -1.
    void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
    The functions get and put must each run in O(1) average time complexity.
    */
    /*
    ["LRUCache","put","put","get","put","get","put","get","get","get"]
    [[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]


    ["LRUCache","put","put","put","put","get","get"]
    [[2],[2,1],[1,1],[2,3],[4,1],[1],[2]]
    Use Testcase
    Output
    [null,null,null,null,null,1,-1]
    Expected
    [null,null,null,null,null,-1,3]


    ["LRUCache","put","get","put","get","get"]
    [[1],[2,1],[2],[3,2],[2],[3]]
    */
    public static void main(String[] args) {
//        LRUCache lruCache = new LRUCache(2);
//        lruCache.put(2, 1);
//        lruCache.put(1, 1);
//        lruCache.put(2, 3);
//        lruCache.put(4, 1);
//        System.out.println(lruCache.get(1)); // 1
//        System.out.println(lruCache.get(2)); // -1

        LRUCache lruCache = new LRUCache(1);
        lruCache.put(2, 1);
        System.out.println(lruCache.get(2)); // 1
        lruCache.put(3, 2);
        System.out.println(lruCache.get(2)); // -1
        System.out.println(lruCache.get(3)); // 2
    }


}

class LRUCache {

    private EntryNode head;
    private EntryNode tail;

    private EntryNode findNode;

    private final int capacity;

    private int size;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    Map<Integer, EntryNode> hashMap = new HashMap<>();

    public int get(int key) {
        find(key);
        if (findNode == null) {
            return -1;
        } else if (findNode != head) {
            removeNode(findNode);
            addNodeToHead(findNode);
        }
        return findNode.value;
    }

    public void put(int key, int value) {
        find(key);
        if (findNode != null) {
            removeNode(findNode);
        }
        EntryNode entryNode = new EntryNode(key, value);
        addNodeToHead(entryNode);
        if (size > capacity) {
            removeNode(tail);
        }
    }

    public void find(int key) {
        findNode = hashMap.get(key);
    }

    public void removeNode(EntryNode removeNode) {
        if (size == 1) {
            head = null;
            tail = null;
            size--;
            return;
        }
        if (removeNode == head) {
            removeNode.next.previous = null;
            head = removeNode.next;
            removeNode.next = null;
        } else if (removeNode == tail) {
            removeNode.previous.next = null;
            tail = removeNode.previous;
            removeNode.previous = null;
        } else {
            removeNode.previous.next = removeNode.next;
            removeNode.next.previous = removeNode.previous;
        }
        hashMap.remove(removeNode.key);
        size--;
    }

    public void addNodeToHead(EntryNode entryNode) {
        if (size == 0) {
            head = entryNode;
            tail = entryNode;
        } else {
            entryNode.next = head;
            head.previous = entryNode;
            head = entryNode;
        }
        hashMap.put(entryNode.key, entryNode);
        size++;
    }
}

class EntryNode {
    int key;
    int value;
    public EntryNode next;
    public EntryNode previous;

    public EntryNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}