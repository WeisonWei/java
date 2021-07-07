package com.weison;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class MainTest {

    /**
     * /user
     * /user/mart_srd
     * /user/mart_srd/data_export.db
     */
    @Test
    public void main() {
        Set<String> SECURITY_PATH_TREE_SET = new TreeSet<String>();
        Set<String> SECURITY_PATH_SET = new HashSet<String>();
        String path = "/user/mart_srd/data_export.db";
        String[] paths = path.split("/");
        if (paths.length > 1) {
            String parentPath = "";
            for (int i = 0; i < paths.length; i++) {
                String currentPath = File.separator + paths[i];
                if (i == 0) {
                    SECURITY_PATH_SET.add(currentPath);
                } else {
                    SECURITY_PATH_SET.add(parentPath + currentPath);
                }
                parentPath = currentPath;
            }
        }
        System.out.println(SECURITY_PATH_SET);
    }

    @Test
    public void StringTokenizer() {
        Set<String> SECURITY_PATH_TREE_SET = new TreeSet<String>();
        Set<String> SECURITY_PATH_SET = new HashSet<String>();
        String path = "/user/mart_srd/data_export.db";
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
            System.out.println(currentPath);
            parentPath = currentPath;
            index++;
        }
    }

    @Test
    public void stringUtil() {

    }


    @Test
    public void stringTokenizer3() {
        List<String> path = new ArrayList<>();
        Set<String> SECURITY_PATH_SET = new HashSet<String>();
        for (int i = 0; i < 10000; i++) {
            String p = "/user" + i + "/mart_srd/" + i + "data_export.db";
            path.add(p);
        }
    }

}
