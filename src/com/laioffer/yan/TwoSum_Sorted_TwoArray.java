package com.laioffer.yan;

public class TwoSum_Sorted_TwoArray {
    public static void main(String[] args) {
        int[] A = new int[]{1,3,5};
        int[] B = new int[]{3,4,6};

        // count how many pairs whcih sum equals to target
        System.out.println(countPairs(A, B, 7));
    }
    private static int countPairs(int[] A, int[] B, int target) {
        // sanity check
        // 相向双指针
        /*
          1,3,5         3,4,6
          i                 j

          arr[i] +arr[j] == 7  counter+1

         */

        int i = 0;
        int j = B.length - 1;
        int count = 0;
        while (i < A.length && j >= 0) {
            int sum = A[i] +B[j];
            if (sum == target) {
                count++;
                j--;
            } else if (sum <target) {
                i++;
            } else {
                j--;
            }
        }
        return count;
    }
}
