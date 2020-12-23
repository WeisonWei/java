package com.weison.algorithm.array;

import java.util.Arrays;

/**
 * @author weixiaoxing
 * @date 2020/12/23
 */
public class One {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 2, 4, 6, 7, 9, 12, 15, 19, 22};
        int[] arr2 = new int[]{0, 2, 5, 7, 8, 13, 16, 18, 21};

        //变量用于存储两个集合应该被比较的索引（存入新集合就加一）
        int a = 0;
        int b = 0;
        int[] arr3 = new int[arr1.length + arr2.length];
        // 1.在本数组内最小
        // 2.在别的数组内最小
        for (int i = 0; i < arr3.length; i++) {
            if (a < arr1.length && b < arr2.length) {   //两数组都未遍历完，相互比较后加入
                if (arr1[a] > arr2[b]) {
                    arr3[i] = arr2[b];
                    b++;
                } else {
                    arr3[i] = arr1[a];
                    a++;
                }
            } else if (a < arr1.length) {   //num2已经遍历完，无需比较，直接将剩余num1加入
                arr3[i] = arr1[a];
                a++;
            } else if (b < arr2.length) {    //num1已经遍历完，无需比较，直接将剩余num2加入
                arr3[i] = arr2[b];
                b++;
            }
        }

        System.out.println("排序后:" + Arrays.toString(arr3));
    }
}
