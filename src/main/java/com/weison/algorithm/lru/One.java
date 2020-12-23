package com.weison.algorithm.lru;

import java.util.Iterator;

public class One {
    public static void main(String[] args) {
        lru();
        //lruCache();
        //lruCache2();
        //lruCache3();
    }

    public static void lru() {
        Lru lru = new Lru(3);
        lru.put(1, 1);
        lru.put(2, 2);
        lru.put(3, 3);
        lru.put(4, 4);
        lru.put(5, 5);
        lru.put(6, 6);
        Iterator iterator = lru.iterator();
        if (iterator.hasNext()) {
            System.out.println(iterator.next().toString());
        }
    }

    public static void lruCache() {
        LruCache lru = new LruCache(3);
        lru.put(1, 1);
        lru.put(2, 2);
        lru.put(3, 3);
        lru.put(4, 4);
        lru.put(3, 3);
        lru.put(6, 6);
        System.out.println();
    }

    public static void lruCache2() {
        LruCache2 lru = new LruCache2(3);
        lru.put(1, 1);
        lru.put(2, 2);
        lru.put(3, 3);
        lru.put(4, 4);
        lru.put(3, 3);
        lru.put(6, 6);
        System.out.println();
    }

    public static void lruCache3() {
        LruCache3 lru = new LruCache3(3);
        lru.put(1, 1);
        lru.put(2, 2);
        lru.put(3, 3);
        lru.put(4, 4);
        lru.put(3, 3);
        lru.put(6, 6);
        System.out.println();
    }
}
