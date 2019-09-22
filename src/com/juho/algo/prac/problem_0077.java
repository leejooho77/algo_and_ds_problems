package com.juho.algo.prac;

/**
 * Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, 
 * then the whole array will be sorted in ascending order, too.
 * You need to find the shortest such subarray and output its length.
 * 
 * Example 1:
 * Input: [2, 6, 4, 8, 10, 9, 15], Output: 5
 * Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
 * 
 * Note:
 *  1. Then length of the input array is in range [1, 10,000].
 *  2. The input array may contain duplicates, so ascending order here means <=.
 * 
 * @author leejooho77
 * @since Sep 22, 2019
 */
public class problem_0077 {

	/**
	 * First, we need to find first descending order from start and first ascending order from end.
	 * Then, we need to find the @min and @max in this section.
	 * Finally, we need to find the right place for @min and @max, then we can get the range of unsorted array.
	 * 
	 * @param nums
	 * @return int
	 */
	public int findUnsortedSubarray(int[] nums) {
		int asc = 0, desc = nums.length - 1, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        // checking ascending order
        while(asc < desc && nums[asc] <= nums[asc + 1]) asc++;
        if(asc == desc) return 0;
        // checking descending order
        while(asc < desc && nums[desc] >= nums[desc - 1]) desc--;
        // find min and max in unsorted area
        for(int i = asc; i <= desc; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        // find each position by searching positions for min and max
        while(asc >= 0 && min < nums[asc]) asc--;
        while(desc < nums.length && max > nums[desc]) desc++;
        return desc - asc - 1;
	}
	
}
