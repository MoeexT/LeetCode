package problemset.hashTable;

/*
 * @date_time: 2020-04-05 21:08
 * @author: MoeexT
 * @problem: 146
 * @url: https://leetcode-cn.com/problems/lru-cache/
 */

import util.DoubleLinkedList;
import util.DoubleLinkedList.DoublyNode;

import java.util.HashMap;

public class LRUCache {

    private final int capacity;
    private HashMap<Integer, DoublyNode> map;
    private DoubleLinkedList cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        cache = new DoubleLinkedList();
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        int val = map.get(key).val;
        put(key, val);
        return val;
    }

    public void put(int key, int value) {
        DoublyNode newNode = new DoublyNode(key, value);
        if (map.containsKey(key)) {
            cache.delete(map.get(key));
        } else {
            if (map.size() == capacity) {
                int k = cache.deleteLast();
                map.remove(k);
            }
        }
        cache.addFirst(newNode);
        map.put(key, newNode);

    }

    public static void main(String[] args) {
//        LRUCache cache = new LRUCache(3);
//        System.out.println("null");
//        cache.put(2, 2);
//        System.out.println("null");
//        cache.put(1, 1);
//        System.out.println("null");
//        System.out.println(cache.get(2));
//        System.out.println(cache.get(1));
//        System.out.println(cache.get(2));
//        cache.put(3, 3);
//        System.out.println("null");
//        cache.put(4, 4);
//        System.out.println("null");
//        System.out.println(cache.get(3));
//        System.out.println(cache.get(2));
//        System.out.println(cache.get(1));
//        System.out.println(cache.get(4));
        LRUCache cache = new LRUCache(2);
        System.out.println(cache.get(2));
        cache.put(2, 6);
        System.out.println(cache.get(1));
        cache.put(1, 5);
        cache.put(1, 2);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
    }
}
