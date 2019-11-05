package com.juho.algo.prac;

import java.util.*;

/**
 * Given a char array representing tasks CPU need to do.
 * It contains capital letters A to Z where different letters represent different tasks.
 * Tasks could be done without original order. Each task could be done in one interval.
 * For each interval, CPU could finish one task or just be idle.
 * However, there is a non-negative cooling interval n that means between two same tasks,
 * there must be at least n intervals that CPU are doing different tasks or just be idle.
 * You need to return the least number of intervals the CPU will take to finish all the given tasks.
 *
 * Example:
 * Input: tasks = ["A","A","A","B","B","B"], n = 2, Output: 8
 * Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
 *
 *
 * Note:
 *  - The number of tasks is in the range [1, 10000].
 *  - The integer n is in the range [0, 100].
 *
 * @author Juho Lee
 * @since Nov 4, 2019
 */
public class problem_0150 {

    public int leastIntervalWithMapAndHeap(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((a, b) -> {
            if(a.getValue() != b.getValue())
                return Integer.compare(b.getValue(), a.getValue());
            return Character.compare(a.getKey(), b.getKey());
        });
        for(char task : tasks) map.put(task, map.getOrDefault(task, 0) + 1);
        Iterator<Map.Entry<Character, Integer>> iter = map.entrySet().iterator();
        while(iter.hasNext()) maxHeap.add(iter.next());
        int interval = n + 1, time = 0;
        Queue<Map.Entry<Character, Integer>> queue = new LinkedList<>();
        while(!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> entry = maxHeap.remove();
            entry.setValue(entry.getValue() - 1);
            if(entry.getValue() > 0)
                queue.offer(entry);
            time++;
            interval--;
            if(interval == 0 || maxHeap.isEmpty()) {
                if(!queue.isEmpty()) time += interval;
                interval = n + 1;
                while(!queue.isEmpty()) maxHeap.add(queue.poll());
            }
        }
        return time;
    }

    public int leastIntervalWithArray(char[] tasks, int n) {
        return 0;
    }

}
