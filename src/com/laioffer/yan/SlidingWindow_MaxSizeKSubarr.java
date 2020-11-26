package com.laioffer.yan;
import java.util.*;

/*
1. brute force
2. max heap
3. treeset/treemap
4. monotonic deque

 */
public class SlidingWindow_MaxSizeKSubarr {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7,8,9,1,1};

        List<Integer> res = getMaxVals(nums, 2);
        for (int i : res) {
            System.out.println(i + " ");
        }
    }
    // deque里存的是之后有可能成为最大值的元素
    private static List<Integer> getMaxVals(int[] nums, int k) {
        // sanity check
        List<Integer> res = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < nums.length ;i++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            deque.offerLast(i);
            if (i >= k - 1) {
                res.add(nums[deque.peekFirst()]);
            }
        }
        return res;
    }
}
