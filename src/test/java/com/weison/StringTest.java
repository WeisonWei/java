package com.weison;

import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class StringTest {
    static List<String> paths = new ArrayList<>();
    static Set<String> SECURITY_PATH_SET = new HashSet<String>();

    /**
     * /user
     * /user/mart_srd
     * /user/mart_srd/data_export.db
     * 10000
     * 35
     * 24
     */
    public static void main(String[] args) {
        init(1000);
        foreach();
        stream();
        pStream();
        paths.clear();

        init(20000);
        foreach();
        stream();
        pStream();
        paths.clear();

        init(30000);
        foreach();
        stream();
        pStream();
        paths.clear();

        init(40000);
        foreach();
        stream();
        pStream();
        paths.clear();

        init(50000);
        foreach();
        stream();
        pStream();
        paths.clear();

    }

    private static void foreach() {
        System.out.println("-- foreach --" + paths.size());
        long start = System.currentTimeMillis();
        for (String path : paths) {
            //stringSubs("/user/mart_srd/data_export.db");
            stringTokenizer(path);
        }
        long end = System.currentTimeMillis();
        System.out.println("stringTokenizer: " + (end - start));


        long start1 = System.currentTimeMillis();
        for (String path : paths) {
            //stringSubs("/user/mart_srd/data_export.db");
            stringJoin(path);
        }
        long end1 = System.currentTimeMillis();
        System.out.println("stringJoin: " + (end1 - start1));


        long start2 = System.currentTimeMillis();
        for (String path : paths) {
            //stringSubs("/user/mart_srd/data_export.db");
            stringSubs(path);
        }
        long end2 = System.currentTimeMillis();
        System.out.println("stringSubs: " + (end2 - start2));
    }

    private static void stream() {
        System.out.println("-- stream --" + paths.size());
        long start = System.currentTimeMillis();
        paths.stream().forEach(StringTest::stringTokenizer);
        long end = System.currentTimeMillis();
        System.out.println("stringTokenizer: " + (end - start));


        long start1 = System.currentTimeMillis();
        paths.stream().forEach(StringTest::stringJoin);
        long end1 = System.currentTimeMillis();
        System.out.println("stringJoin: " + (end1 - start1));


        long start2 = System.currentTimeMillis();
        paths.stream().forEach(StringTest::stringSubs);
        long end2 = System.currentTimeMillis();
        System.out.println("stringSubs: " + (end2 - start2));
    }

    private static void pStream() {
        System.out.println("-- pStream --" + paths.size());
        long start = System.currentTimeMillis();
        paths.stream().parallel().forEach(StringTest::stringTokenizer);
        long end = System.currentTimeMillis();
        System.out.println("stringTokenizer: " + (end - start));


        long start1 = System.currentTimeMillis();
        paths.stream().parallel().forEach(StringTest::stringJoin);
        long end1 = System.currentTimeMillis();
        System.out.println("stringJoin: " + (end1 - start1));


        long start2 = System.currentTimeMillis();
        paths.stream().parallel().forEach(StringTest::stringSubs);
        long end2 = System.currentTimeMillis();
        System.out.println("stringSubs: " + (end2 - start2));
    }

    public static void init(int num) {
        for (int i = 0; i < num; i++) {
            String p = "/user" + i + "/mart_srd" + i + "/data_export.db";
            paths.add(p);
        }
    }

    public static void stringTokenizer(String path) {
        StringTokenizer st = new StringTokenizer(path, "/");
        String parentPath = "";
        int index = 0;
        while (st.hasMoreTokens()) {
            String currentPath;
            if (index == 0) {
                currentPath = "/" + st.nextToken();
            } else {
                currentPath = parentPath + "/" + st.nextToken();
            }
            SECURITY_PATH_SET.add(currentPath + File.separator);
            //System.out.println(currentPath);
            parentPath = currentPath;
            index++;
        }
    }

    public static void stringJoin(String path) {
        String[] split = StringUtils.split(path, "/");
        String parentPath = "";
        for (int i = 0; i < split.length; i++) {
            String currentPath;
            if (i == 0) {
                currentPath = "/" + split[i];
            } else {
                currentPath = parentPath + "/" + split[i];
            }
            SECURITY_PATH_SET.add(currentPath + File.separator);
            //System.out.println(currentPath);
            parentPath = currentPath;
        }
    }

    /**
     * /a/b/c
     * /a/b
     * /c
     */
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
