package com.juho.algo.prac;

import java.util.HashSet;
import java.util.Set;

/**
 * We have a list of tasks to perform, with a cooldown period.
 * We can do multiple of these at the same time, but we cannot run the same task simultaneously.
 *
 * Given a list of tasks, find how long it will take to complete the tasks in the order they are input.
 *
 * Example:
 * Input: tasks = [1, 1, 2, 1], cooldown = 2, Output: 7
 * Explanation: Order is 1 _ _ 1 2 _ 1
 *
 * @author Juho Lee
 * @since Nov 4, 2019
 */
public class problem_0151 {

    public int findTime(int[] tasks, int cooldown) {
        int interval = cooldown + 1, time = 0, i = 0;
        Set<Integer> set = new HashSet<>();
        while (i < tasks.length) {
            int task = tasks[i];
            if (interval == 0 || set.contains(task)) {
                time += interval;
                interval = cooldown + 1;
                set.clear();
            } else {
                set.add(task);
                time++;
                interval--;
                i++;
            }
        }
        return time;
    }

}