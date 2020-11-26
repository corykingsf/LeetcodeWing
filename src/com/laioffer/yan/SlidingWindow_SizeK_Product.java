package com.laioffer.yan;
import java.util.*;

public class SlidingWindow_SizeK_Product {
    public static void main(String[] args) {
        int[] num = new int[]{1,2,3,0,5,0,6,7,8};
        List<Integer> res = calProductSizeK(num, 3);
        for (int i : res) {
            System.out.println(i + " ");
        }
    }
    private static List<Integer> calProductSizeK(int[] arr, int k) {
        // sanity check
        List<Integer> res = new ArrayList<>();
        int product = 1;
        int numZeroes = 0;

        for (int fast = 0; fast < arr.length; fast++) {
            if (arr[fast] == 0) {
                numZeroes++;
            } else {
                product *= arr[fast];
            }
            if (fast >= k) {
                if (arr[fast - k] == 0) numZeroes--;
                else product /= arr[fast - k];
            }
            if (fast >= k - 1) {
                // record product
                if (numZeroes == 0) res.add(product);
                else res.add(0);
            }
        }
        return res;
    }
}
