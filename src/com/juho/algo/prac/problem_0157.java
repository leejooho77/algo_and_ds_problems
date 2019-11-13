package com.juho.algo.prac;

import java.util.*;

/**
 * Given a list of building in the form of (left, right, height), return what the skyline should look like.
 * The skyline should be in the form of a list of (x-axis, height),
 * where x-axis is the next point where there is a change in height starting from 0, and height is the new height starting from the x-axis.
 *
 * Example:
 * Input: [[2,9,3],[2,7,4],[4,6,5],[5,8,6]]
 * Output: [[2,3],[4,5],[5,6],[9,3],[10,0]]
 *
 *              3 3 3 3
 *            2 3 3 3 3
 *            2 3 3 3 3
 *        1 1 2 3 3 3 3 1
 *        1 1 2 3 3 3 3 1
 *        1 1 2 3 3 3 3 1
 * pos: 1 2 3 4 5 6 7 8 9 10
 *
 * @author Juho Lee
 * @since Nov 8, 2019
 */
public class problem_0157 {

    public List<List<Integer>> getSkylineWithTreeMap(int[][] buildings) {
        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> {
            if(a[0] != b[0])
                return Integer.compare(a[0], b[0]);
            return Integer.compare(b[1], a[1]);
        });
        TreeMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
        for(int[] building : buildings) {
            minHeap.add(new int[] {building[0], building[2]});
            minHeap.add(new int[] {building[1], -1 * building[2]});
        }
        int max = 0;
        map.put(0, 1);
        while(!minHeap.isEmpty()) {
            int[] building = minHeap.remove();
            if(building[1] > 0) {
                int count = (map.get(building[1]) == null) ? 0 : map.get(building[1]);
                map.put(building[1], count + 1);
            }
            else {
                int count = map.get(-1 * building[1]);
                if(count > 1)
                    map.put(-1 * building[1], count - 1);
                else
                    map.remove(-1 * building[1]);
            }

            if(max != map.firstKey()) {
                result.add(Arrays.asList(building[0], map.firstKey()));
                max = map.firstKey();
            }
        }
        return result;
    }

    public List<List<Integer>> getSkylineWithHeap(int[][] buildings) {
        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> {
            if(a[0] != b[0])
                return Integer.compare(a[0], b[0]);
            return Integer.compare(b[1], a[1]);
        });
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b, a));
        for(int[] building : buildings) {
            minHeap.add(new int[] {building[0], building[2]});
            minHeap.add(new int[] {building[1], -1 * building[2]});
        }
        int max = 0;
        maxHeap.add(0);
        while(!minHeap.isEmpty()) {
            int[] building = minHeap.remove();
            if(building[1] > 0)
                maxHeap.add(building[1]);
            else
                maxHeap.remove(-1 * building[1]);

            if(max != maxHeap.peek()) {
                result.add(Arrays.asList(building[0], maxHeap.peek()));
                max = maxHeap.peek();
            }
        }
        return result;
    }

}