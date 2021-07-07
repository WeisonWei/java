package com.weison;

import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

public class SetTest {
    static List<String> paths = new ArrayList<>();
    static Set<String> SECURITY_PATH_SET1 = new HashSet<String>();
    static Set<String> SECURITY_PATH_SET2 = new CopyOnWriteArraySet<String>();
    static ConcurrentHashMap<String, Integer> certificationCosts = new ConcurrentHashMap<>();
    static Set<String> SECURITY_PATH_SET = certificationCosts.newKeySet();


    /**
     * /a/b/c
     * /a/b
     * /c
     */
    public static void main(String[] args) {
        init(100000);
        pStream();
        isSec();

    }

    private static void isSec() {
        System.out.println("-- startsWith --" + SECURITY_PATH_SET.size());
        long start = System.currentTimeMillis();
        startsWith("/a/");
        long end = System.currentTimeMillis();
        System.out.println("startsWith: " + (end - start));


        System.out.println("-- contains --" + SECURITY_PATH_SET.size());
        long start1 = System.currentTimeMillis();
        contains("/a");
        long end1 = System.currentTimeMillis();
        System.out.println("contains: " + (end1 - start1));
    }

    private static void startsWith(String path) {
        for (String p : SECURITY_PATH_SET) {
            if (path.startsWith(p)) {
                System.out.println("OK");
            }
        }
    }

    private static void contains(String path) {
        if (SECURITY_PATH_SET.contains(path)) {
            System.out.println("OK");
        }
    }

    private static void pStream() {
        long start2 = System.currentTimeMillis();
        paths.stream().parallel().forEach(SetTest::stringSubs);
        long end2 = System.currentTimeMillis();
        System.out.println("stringSubs: " + (end2 - start2));
    }

    public static void init(int num) {
        for (int i = 0; i < num; i++) {
            String p = "/user" + i + "/mart_srd" + i + "/data_export.db";
            paths.add(p);
        }
    }

    public static void stringSubs(String path) {
        String[] split = StringUtils.split(path, File.separator);
        for (int i = 0; i < split.length; i++) {
            String currentPath;
            if (i == 0) {
                currentPath = path;
            } else {
                int index = path.lastIndexOf(File.separator);
                currentPath = path.substring(0, index);
            }
            SECURITY_PATH_SET.add(currentPath + File.separator);
            //System.out.println(currentPath + File.separator);
            path = currentPath;
        }
    }
}
