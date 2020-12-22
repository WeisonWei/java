package com.weison.algorithm.lru;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

/**
 * LinkedHashMap 本身内部有一个触发条件则自动执行的方法：删除最老元素（最近最少使用的元素）
 * 由于最近最少使用元素是 LinkedHashMap 内部处理
 * 故我们不再需要维护 最近访问元素放在链尾，get 时直接访问/ put 时直接存储
 */
public class LruCache3 {
    LinkedHashMap<Integer, Integer> cache;
    int capacity;

    public LruCache3(int capacity) {
        cache = new LinkedHashMap<>(capacity);
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) return -1;

        int val = cache.get(key);
        cache.remove(key); // 从链表中删除
        cache.put(key, val); // 添加到链尾

        return val;

    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            cache.remove(key); // 已经存在，链表中删除
        }

        if (capacity == cache.size()) {
            // cache 已满,删除链表头
            Set<Integer> keySet = cache.keySet();
            Iterator<Integer> iterator = keySet.iterator();
            cache.remove(iterator.next());
        }
        cache.put(key, value);// 添加到链尾
    }
}

