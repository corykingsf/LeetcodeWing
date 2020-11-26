package com.laioffer.yan;

import java.util.*;

public class FindDuplicate_SizeK {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,1,5,2};
        System.out.println(containsNearbyDuplicate(arr, 2));
        System.out.println(containsNearbyDup(arr, 2));
    }
    /*
    method 1: 记录每个元素最近的出现过的index,如果发现当前元素之前出现过，判断距离时候小于k,如果小于k, return true,
    否则更新元素最后出现位置的index
     */

    private static boolean containsNearbyDup(int[] arr, int k) {
        // 物理意义： key:元素, value: 元素最后出现的Index
        Map<Integer, Integer> visited = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (visited.containsKey(arr[i])) {
               if (i - visited.get(arr[i]) <= k ) {
                   return true;
               }
            }
            visited.put(arr[i], i);

        }
        for (Map.Entry<Integer, Integer> entry : visited.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
            System.out.println();
        }
        return false;
    }


    // method 2
    private static boolean containsNearbyDuplicate(int[] arr, int k) {

        Set<Integer> window = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (!window.add(arr[i])) {
                return true;
            }
            if (i >= k) {
                window.remove(arr[i - k]);
            }
        }
        return false;
    }
}
