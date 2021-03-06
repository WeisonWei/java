package com.weison.collection.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class HashMapTest {
    public static final int MAX_VALUE = 0x7fffffff;

    @SuppressWarnings({"unchecked", "rawtypes"})
    public static void main(String[] args) {
        int threshold = (int) Math.min(11 * 0.75, Integer.MAX_VALUE - 8 + 1);
        int newCapacity = (11 << 1) + 1;
        myHashMap1();
        myHashMap2();
        myHashMap3();
    }

    /**
     * entrySet().iterator()
     */
    private static void myHashMap1() {
        Map map = new HashMap();
        for (int i = 0; i < 1000000; i++) {
            map.put(i, i);
        }

        Iterator iterator = map.entrySet().iterator();
        long begin = System.currentTimeMillis();
        while (iterator.hasNext()) {
            Entry next = (Entry) iterator.next();
            Object key = next.getKey();
            Object value = next.getValue();
            // System.out.println(">>>>>key>>>>>" + next.getKey() + ">>>>>value>>>" +
            // next.getValue());
        }
        long end = System.currentTimeMillis();
        System.out.println("---myHashMap1 - cost---" + (end - begin));
    }

    /**
     * keySet()
     */
    private static void myHashMap2() {
        Map map = new HashMap();
        for (int i = 0; i < 1000000; i++) {
            map.put(i, i);
        }

        long begin = System.currentTimeMillis();
        for (Object obj : map.keySet()) {
            Object key = obj;
            Object value = map.get(key);
            // System.out.println(">>>>>key>>>>>" + key + ">>>>>value>>>" + map.get(key));
        }
        long end = System.currentTimeMillis();
        System.out.println("---myHashMap2 - cost---" + (end - begin));
    }

    /**
     * entrySet()
     */
    private static void myHashMap3() {
        Map map = new HashMap();
        for (int i = 0; i < 1000000; i++) {
            map.put(i, i);
        }

        long begin = System.currentTimeMillis();
        for (Object object : map.entrySet()) {
            Entry<Integer, Integer> entry = (Entry<Integer, Integer>) object;
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            // System.out.println(">>>>>key>>>>>" + entry.getKey() + ">>>>>value>>>" +
            // entry.getValue());
        }
        long end = System.currentTimeMillis();
        System.out.println("---myHashMap3 - cost---" + (end - begin));
    }
}
