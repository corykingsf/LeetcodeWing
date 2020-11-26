package com.laioffer.yan;
import java.util.*;
import java.util.ArrayList;

public class TwoPointer_Intersection_Union_Diff {
    public static void main(String[] args) {
        int[] arr1  = new int[]{1,2,3};
        int[] arr2 = new int[]{2,4};

        List<Integer> diff = new ArrayList<>();
        List<Integer> union = new ArrayList<>();
        List<Integer> intersection = new ArrayList<>();

        getDiffIntUnion(diff, union, intersection, arr1, arr2);
        System.out.println("diff");
        for (int i : diff) {
            System.out.print(i+ " ");
        }
        System.out.println();
        System.out.println("union");
        for (int i : union) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("intersection");
        for (int i : intersection) {
            System.out.print(i + " ");
        }

    }

    private static void  getDiffIntUnion(List<Integer> diff, List<Integer> union, List<Integer> intersection, int[] arr1, int[] arr2) {
        // sanity check
        int len1 = arr1.length;
        int len2 = arr2.length;
        int i = 0, j = 0;

        while (i < len1 && j < len2) {
            if (arr1[i] == arr2[j]) {
                intersection.add(arr1[i]);
                union.add(arr1[i]);
                i++;
                j++;
            } else if (arr1[i] < arr2[j]) {
                union.add(arr1[i]);
                diff.add(arr1[i]);
                i++;
            } else {
                union.add(arr1[i]);
                diff.add(arr2[j]);
                j++;
            }

        }
        while (i < len1) {
            union.add(arr1[i]);
            diff.add(arr1[i]);
            i++;
        }
        while (j < len2) {
            union.add(arr2[j]);
            diff.add(arr2[j]);
            j++;
        }
    }
}
