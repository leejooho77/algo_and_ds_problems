package com.juho.algo.prac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Given a sorted array, two integers k and x, find the k closest elements to x in the array.
 * The result should also be sorted in ascending order. If there is a tie, the smaller elements are always preferred.
 *
 * Example 1:
 * Input: [1,2,3,4,5], k=4, x=3, Output: [1,2,3,4]
 *
 * Example 2:
 * Input: [1,2,3,4,5], k=4, x=-1, Output: [1,2,3,4]
 *
 * Note:
 *  - The value k is positive and will always be smaller than the length of the sorted array.
 *  - Length of the given array is positive and will not exceed 10^4
 *  - Absolute value of elements in the array and x will not exceed 10^4
 *
 * @author Juho Lee
 * @since Jan 07, 2020
 */
public class problem_0235 {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0, right = arr.length - k;
        while(left < right) {
            int mid = left + (right - left)/2;
            // arr[mid] is start point of arr[mid] ~ arr[mid + k - 1]
            // arr[mid + k] is the end point of arr[mid + 1] ~ arr[mid + k]
            // so if x - arr[mid] is larger than arr[mid + k] - x,
            // it means that arr[mid + k] is closer than arr[mid]
            // which also means that arr[mid + 1] ~ arr[mid + k] has closer elements than arr[mid] ~ arr[mid + k - 1]
            // so set left as mid + 1; otherwise set right as mid
            if(x - arr[mid] > arr[mid + k] - x)
                left = mid + 1;
            else
                right = mid;
        }
        return Arrays.stream(arr, left, left + k).boxed().collect(Collectors.toList());
    }

}