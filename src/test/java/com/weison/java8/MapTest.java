package com.weison.java8;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class MapTest {

    /**
     * put返回旧值，如果没有则返回null
     */
    @Test
    public void put() {
        Map<String, String> map = new HashMap<>();
        map.put("a", "A");
        map.put("b", "B");
        String v = map.put("b", "v"); // 输出 B
        System.out.println(v);
        String v1 = map.put("c", "v");
        System.out.println(v1); // 输出：NULL
    }

    /**
     * compute：返回新值
     */
    @Test
    public void compute() {
        Map<String, String> map = new HashMap<>();
        map.put("a", "A");
        map.put("b", "B");
        String val = map.compute("b", (k, v) -> "v"); // 输出 v
        System.out.println(val);
        String v1 = map.compute("c", (k, v) -> "v"); // 输出 v
        System.out.println(v1);
    }

    /**
     * putIfAbsent返回旧值，如果没有则返回null
     */
    @Test
    public void putIfAbsent() {
        Map<String, String> map = new HashMap<>();
        map.put("a", "A");
        map.put("b", "B");
        String v = map.putIfAbsent("b", "v");  // 输出 B
        System.out.println(v);
        String v1 = map.putIfAbsent("c", "v");  // 输出 null
        System.out.println(v1);
    }

    /**
     * computeIfAbsent:存在时返回存在的值，不存在时返回新值
     */
    @Test
    public void computeIfAbsent() {
        Map<String, String> map = new HashMap<>();
        map.put("a", "A");
        map.put("b", "B");
        String v = map.computeIfAbsent("b", k -> "v");  // 输出 B
        System.out.println(v);
        String v1 = map.computeIfAbsent("c", k -> "v"); // 输出 v
        System.out.println(v1);
    }

    /**
     * computeIfPresent:如果 key 对应的 value 不存在，则返回该null，如果存在，则返回通过remappingFunction重新计算后的值
     */
    @Test
    public void computeIfPresent() {
        Map<String, String> map = new HashMap<>();
        map.put("a", "A");
        map.put("b", "B");
        String b = map.computeIfPresent("b", (k, v) -> v + "a");// 输出 B
        System.out.println(b);
        String v1 = map.computeIfPresent("c", (k,v)->v); // 输出 v
        System.out.println(v1);
    }
}
