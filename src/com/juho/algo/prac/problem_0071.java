package com.juho.algo.prac;

/**
 * 
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 * 
 * Example:
 * Input: [10,9,2,5,3,7,101,18], Output: 4 
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4. 
 * 
 * Note:
 *  - There may be more than one LIS combination, it is only necessary for you to return the length.
 *  - Your algorithm should run in O(n^2) complexity.
 *  
 * Follow up: Could you improve it to O(n log n) time complexity?
 * 
 * @author Juho Lee
 * @since Sep 17, 2019
 */
public class problem_0071 {

	/**
	 * Using standard dynammic programming approach with an additional array
	 * 
	 * @param nums
	 * @return int
	 */
	public int lengthOfLISWithDP(int[] nums) {
		if(nums.length == 0) return 0;
		int max = 0;
		int[] dp = new int[nums.length];
		for(int i = 1; i < dp.length; i++) {
			for(int j = 0; j < i; j++) {
				if(nums[j] < nums[i])
					dp[i] = Math.max(dp[i], dp[j] + 1);
				max = Math.max(dp[i], max);
			}
		}
		return max + 1;
	}
	
	/**
	 * Prepare an empty array to put possible @LongestIncreasingSubsequence.
	 * Since this array would be always in ascending order, we can apply binary search.
	 * As we loop through the @nums, if the @n is larger than values of @LIS, append it and increase the size.
	 * Else if we found pattern of @LIS[i - 1] < @n < @LIS[i], replace @LIS[i - 1] to @n.
	 * 
	 * @param nums
	 * @return int
	 */
	public int lengthOfLISWithBS(int[] nums) {
		int size = 0;
		int[] LIS = new int[nums.length];
		for(int n : nums) {
			int i = 0, j = size;
			while(i < j) {
                int m = i + (j - i)/2;
				if(n > LIS[m]) {
					i = m + 1;
				} else {
					j = m;
				}
			}
			LIS[i] = n;
			if(i == size) 
				size++;
		}
		return size;
	}
	
}
