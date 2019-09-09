package com.juho.algo.prac;

/**
 * Given an integer array nums, 
 * find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 * 
 * Example:
 * Input: [-2,1,-3,4,-1,2,1,-5,4], Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * 
 * @author leejooho77
 * @since Aug 22, 2019
 */
public class problem_0036 {

	public int maxSubArrayWithDP(int[] nums) {
		int max = Integer.MIN_VALUE, curr = 0;
		for(int i : nums) {
			curr = (curr + i > i) ? curr + i : i;
			max = Math.max(curr, max);
		}
		return max;
	}
	
	public int maxSubArrayWithDivideAndConquer(int[] nums) {
        return maxSubArrayWithDivideAndConquer(nums, 0, nums.length - 1);
    }
    
    public int maxSubArrayWithDivideAndConquer(int[] nums, int start, int end) {
        if(start == end) return nums[start];
        int mid = start + (end - start)/2;
        int left = maxSubArrayWithDivideAndConquer(nums, start, mid);
        int right = maxSubArrayWithDivideAndConquer(nums, mid + 1, end);
        int middle = crossSum(nums, start, mid, end);
        return Math.max(left, Math.max(right, middle));
    }
    
    public int crossSum(int[] nums, int start, int mid, int end) {
        int sum = 0, curr = mid, left = Integer.MIN_VALUE, right = Integer.MIN_VALUE;
        while(curr >= start) {
            sum += nums[curr];
            left = Math.max(sum, left);
            curr--;
        }
        sum = 0; 
        curr = mid + 1;
        while(curr <= end) {
            sum += nums[curr];
            right = Math.max(sum, right);
            curr++;
        }
        return left + right;
    }
	
}
