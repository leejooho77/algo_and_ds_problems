package com.juho.algo.prac.util;

/**
 * @author Juho Lee
 * @since July 17, 2019
 */
public class ArrayUtils {

	public static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	public static void print(int[] nums) {
		System.out.print("[ ");
		for(int i : nums) {
			System.out.print(i + " ");
		}
		System.out.println("]");
	}
	
}
