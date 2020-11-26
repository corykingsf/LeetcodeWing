package com.laioffer.yan;

import java.util.*;

public class SlidingWindow_SumSizeKSubarr {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5};


        List<Integer> res = sumSizeKSubarray(nums, 3);
        for (int i : res) {
            System.out.println(i + " ");
        }
    }
    // return list of all sums
    private static List<Integer> sumSizeKSubarray(int[] arr, int k) {
         // sanity check
        // fix size sliding window, size is k
        int sum = 0;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i <arr.length; i++) {
            // 不管size多少，先要加进来
            sum += arr[i];
            if (i >= k) {
                sum -= arr[i - k];
            }
            if (i >= k - 1) {
                // record sum
                res.add(sum);
            }

        }
        return res;

    }
}
