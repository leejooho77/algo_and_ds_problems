package com.juho.algo.prac;

import com.juho.algo.prac.util.ArrayUtils;

import java.util.PriorityQueue;

/**
 * You are given a list of n numbers, where every number is at most k indexes away from its properly sorted index.
 * Write a sorting algorithm (that will be given the number k) for this list that can solve this in O(n log k)
 *
 * Example:
 * Input: [3, 2, 6, 5, 4], k=2, Output: [2, 3, 4, 5, 6]
 * As seen above, every number is at most 2 indexes away from its proper sorted index.
 *
 * @author Juho Lee
 * @since Nov 14, 2019
 */
public class problem_0165 {

    public void sort(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int i = 0, j = 0; i <= nums.length; i++) {
            if(i == nums.length) {
                while(!heap.isEmpty())
                    nums[j++] = heap.remove();
            } else {
                heap.add(nums[i]);
                if(heap.size() == k + 1)
                    nums[j++] = heap.remove();
            }
        }
    }

}