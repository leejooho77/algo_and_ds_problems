package com.juho.algo.prac;

import java.util.*;

/**
 * Given a non-empty array of integers, return the k most frequent elements.
 *
 * Example 1:
 * Input: nums = [1,1,1,2,2,3], k = 2, Output: [1,2]
 *
 * Example 2:
 * Input: nums = [1], k = 1, Output: [1]
 *
 * Note:
 *  - You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 *  - Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 *
 * @author Juho Lee
 * @since Oct 22, 2019
 */
public class problem_0123 {

    public List<Integer> topKFrequentWithBucketSort(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums) map.put(i, map.getOrDefault(i, 0) + 1);
        // buckets to store the key based on its count
        List<Integer>[] counts = new List[nums.length];
        for(int i : map.keySet()) {
            int count = map.get(i);
            if(counts[count - 1] == null)
                counts[count - 1] = new ArrayList<>();
            counts[count - 1].add(i);
        }
        List<Integer> result = new ArrayList<>();
        for(int i = nums.length - 1; i >= 0 && k > 0; i--) {
            if(counts[i] != null) {
                for(int n : counts[i]) {
                    if(k > 0)
                        result.add(n);
                    k--;
                }
            }
        }
        return result;
    }

    public List<Integer> topKFrequentWithHeap(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) map.put(i, map.getOrDefault(i, 0) + 1);
        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>((a, b) -> {
            if (a.getKey() != b.getKey())
                return Integer.compare(a.getValue(), b.getValue());
            return Integer.compare(b.getKey(), a.getKey());
        });
        Iterator<Map.Entry<Integer, Integer>> iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            heap.add(iter.next());
            if (heap.size() > k)
                heap.remove();
        }
        List<Integer> result = new ArrayList<>();
        while (!heap.isEmpty()) {
            result.add(0, heap.remove().getKey());
        }
        return result;
    }
}
