package com.laioffer.yan;

import java.util.*;

public class FindDuplicate_SizeK {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,2};
        System.out.println(containsNearbyDuplicate(arr, 2));
    }

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
