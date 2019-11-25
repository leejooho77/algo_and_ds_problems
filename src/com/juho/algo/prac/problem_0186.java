package com.juho.algo.prac;

/**
 * The set S originally contains numbers from 1 to n.
 * But unfortunately, due to the data error, one of the numbers in the set got duplicated to another number in the set,
 * which results in repetition of one number and loss of another number.
 *
 * Given an array nums representing the data status of this set after the error.
 * Your task is to firstly find the number occurs twice and then find the number that is missing.
 * Return them in the form of an array.
 *
 * Example 1:
 * Input: nums = [1,2,2,4], Output: [2,3]
 *
 * Note:
 *  - The given array size will in the range [2, 10000].
 *  - The given array's numbers won't have any order.
 *
 * @author Juho Lee
 * @since Nov 25, 2019
 */
public class problem_0186 {

    public int[] findErrorNums(int[] nums) {
        int n = nums.length, total = (n * (n + 1))/2, sum = 0, rep = 0;
        int[] set = new int[n];
        for(int num : nums) {
            if(set[num - 1] > 0)
                rep = num;
            else {
                set[num - 1]++;
                sum += num;
            }
        }
        return new int[] {rep, total - sum};
    }

}