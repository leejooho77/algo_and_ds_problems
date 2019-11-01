package com.juho.algo.prac;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Given an array of integers,
 * find out whether there are two distinct indices i and j in the array such that the absolute difference
 * between nums[i] and nums[j] is at most t and the absolute difference between i and j is at most k.
 *
 * Example 1:
 * Input: nums = [1,2,3,1], k = 3, t = 0, Output: true
 *
 * Example 2:
 * Input: nums = [1,0,1,1], k = 1, t = 2, Output: true
 *
 * Example 3:
 * Input: nums = [1,5,9,1,5,9], k = 2, t = 3, Output: false
 *
 * @author Juho Lee
 * @since Oct 31. 2019
 */
public class problem_0146 {

    public boolean containsNearbyAlmostDuplicateWithTreeSet(int[] nums, int k, int t) {
        if(t < 0) return false;
        TreeSet<Long> set = new TreeSet<>();
        for(int i = 0; i < nums.length; i++) {
            long curr = nums[i];
            if(i > k)
                set.remove(new Long(nums[i - k - 1]));
            if(!set.isEmpty()) {
                SortedSet<Long> subset = set.subSet(curr - t, curr + t + 1);
                if(!subset.isEmpty())
                    return true;
            }
            set.add(curr);
        }
        return false;
    }

    public boolean containsNearbyAlmostDuplicateWithBucket(int[] nums, int k, int t) {
        return false;
    }

}