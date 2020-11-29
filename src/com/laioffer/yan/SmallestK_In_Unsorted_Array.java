package com.laioffer.yan;

/*
method 1:min heap
method 2:max heap

 */

import java.util.*;

import java.util.Collections;
import java.util.PriorityQueue;

public class SmallestK_In_Unsorted_Array {
    public static void main(String[] args) {
        int[] arr = new int[]{5,4,6,7,21, 89};

        int[] res = getSmallestK(arr, 4);
        for (int i : res) {
            System.out.println(i + " ");
        }
    }
    private static int[]  getSmallestK(int[] arr, int k) {
        // sanity check
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, Collections.reverseOrder());

        for (int i = 0; i <arr.length; i++)  {
            if (maxHeap.size() < k) {
                maxHeap.offer(arr[i]);
            } else {
                if (arr[i] < maxHeap.peek()) {
                    maxHeap.poll();
                    maxHeap.offer(arr[i]);
                }
            }
        }
       int[] res = new int[maxHeap.size()];
        for (int i = maxHeap.size() - 1; i >= 0; i--) {
            res[i] = maxHeap.poll();
        }
        return res;
    }

}
