package com.juho.algo.prac;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given a circular array (the next element of the last element is the first element of the array), print the Next Greater Number for every element.
 * The Next Greater Number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number.
 * If it doesn't exist, output -1 for this number.
 *
 * Example 1:
 * Input: [1,2,1], Output: [2,-1,2]
 * Explanation: The first 1's next greater number is 2;
 *              The number 2 can't find next greater number;
 *              The second 1's next greater number needs to search circularly, which is also 2.
 *
 * Note: The length of given array won't exceed 10000.
 *
 * @author Juho Lee
 * @since Jan 07, 2020
 */
public class problem_0236 {

    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 2 * nums.length - 1; i >= 0; i--) {
            int n = i % nums.length;
            while(!stack.isEmpty() && nums[stack.peek()] <= nums[n])
                stack.pop();
            result[n] = (stack.isEmpty()) ? -1 : nums[stack.peek()];
            stack.push(n);
        }
        return result;
    }

}