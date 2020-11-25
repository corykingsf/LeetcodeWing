package com.laioffer.yan;

public class TwoSum_Sorted {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 4, 5, 5, 6};
        System.out.println(checkTwoSum(arr, 9));
    }

    // determine if there is a pair of elements sum to target
    // arr is sorted
    private static boolean checkTwoSum(int[] arr, int target) {
        // sanity check
        // two pointer
        /*
            1,2,4,5,5,6
            i         j
            for each j, find small index i which arr[i] + arr[j]  >= target

         */
        int i = 0;
        int j = arr.length - 1;

        while (i < j) {
            int sum = arr[i] + arr[j];
            if (sum == target) {
                return true;
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }
}
