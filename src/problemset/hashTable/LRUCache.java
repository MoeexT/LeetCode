package problemset.hashTable;

/*
 * @date_time: 2020-04-05 21:08
 * @author: MoeexT
 * @problem: 146
 * @url: https://leetcode-cn.com/problems/lru-cache/
 */

import util.LRURecord;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    /* 超时
     */

    int capacity;
    Map<Integer, LRURecord> map = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        flush();
        if (map.containsKey(key)) {
            map.get(key).reset();
            return map.get(key).getVal();
        }
        return -1;
    }

    public void put(int key, int value) {
        flush();
        if (map.size() < capacity || map.containsKey(key)) {
            map.put(key, new LRURecord(value));
        } else {
            // TODO
            // 置换出最不常用的块
            int lstKey = 0;
            LRURecord lstRecord = new LRURecord(-2);
            lstRecord.setTime(-1);
            for (Map.Entry<Integer, LRURecord> entry : map.entrySet()) {
                if (entry.getValue().getTime() > lstRecord.getTime()) {
                    lstKey = entry.getKey();
                    lstRecord = entry.getValue();
                }
            }
            map.remove(lstKey);
            map.put(key, new LRURecord(value));
        }
    }

    /**
     * 将所有记录的时间戳加 1
     */
    private void flush() {
        for (LRURecord record : map.values()) {
            record.update();
        }
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
