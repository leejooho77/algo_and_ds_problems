package com.juho.algo.prac;

/**
 * Given an unsorted array of integers, find the number of longest increasing subsequence.
 * 
 * Example 1:
 * Input: [1,3,5,4,7], Output: 2
 * Explanation: The two longest increasing subsequence are [1, 3, 4, 7] and [1, 3, 5, 7].
 * 
 * Example 2:
 * Input: [2,2,2,2,2], Output: 5
 * Explanation: The length of longest continuous increasing subsequence is 1, 
 * and there are 5 subsequences' length is 1, so output 5.
 * 
 * @author Juho Lee
 * @since Sep 17, 2019
 */
public class problem_0072 {
	
	public int findNumberOfLIS(int[] nums) {
		int[] length = new int[nums.length];
		int[] count = new int[nums.length];
		int max = 0, result = 0;
		for(int i = 0; i < nums.length; i++) {
			length[i] = count[i] = 1;
			for(int j = 0; j < i; j++) {
				// meet subsequence with ascending order
				if(nums[i] > nums[j]) {
					/**
					 * If value at @i is larger than value at @j by 1,
					 * It means that it includes subsequence which ends with the value @j.
					 * We can add it to current count.
					 * 
					 * @Example:
					 * 
					 * @idx:  0 1 2 3 4
					 * @nums: 1 3 5 4 7
					 * @len:  1 2 3 3 4
					 * @cnt:  1 1 1 1 2
					 * 
					 * As we see, at @i=4 and @j=3, we have @len 4 and 3 which differ by 1.
					 * In this case, since it is inclusive, we can add count[j] to count[i].
					 */
					if(length[i] == length[j] + 1)
						count[i] += count[j];
					/**
					 * If it is ascending order and still the @len at @i is less than @len at @j + 1,
					 * We change value of @len at @i to @len at @j + 1 and set value of @count at @i to @count at @j.
					 */
					else if(length[i] < length[j] + 1) {
						length[i] = length[j] + 1;
						count[i] = count[j];
					}
				}
			}
			if(max == length[i]) result += count[i];
			else if(max < length[i]) {
				max = length[i];
				result = count[i];
			}
		}
		return result;
    }

}
