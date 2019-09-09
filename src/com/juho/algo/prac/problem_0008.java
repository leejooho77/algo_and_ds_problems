package com.juho.algo.prac;

import java.util.HashSet;
import java.util.Set;

/**
 * You are given a list of numbers, and a target number k. 
 * Return whether or not there are two numbers in the list that add up to k.
 * 
 * Example:
 * Given [4, 7, 1 , -3, 2] and k = 5, 
 * 
 * return true since 4 + 1 = 5.
 * @author leejooho77
 * @since July 25, 2019
 */
public class problem_0008 {
	
	/**
	 * @param nums				array of integers
	 * @param target			target sum
	 * @return true if two integers in @nums add up to @target, else false
	 */
	public boolean twoSum(int[] nums, int target) {
		Set<Integer> set = new HashSet<>();
		for(int i : nums) {
			if(set.contains(i)) return true;
			else set.add(target - i);
		}
		return false;
	}

}
