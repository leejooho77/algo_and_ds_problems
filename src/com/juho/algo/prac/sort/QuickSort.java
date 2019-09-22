package com.juho.algo.prac.sort;

import java.util.Random;

import com.juho.algo.prac.util.ArrayUtils;

/**
 * 
 * @author Juho Lee
 * @since Sep 21, 2019
 */
public class QuickSort {

	public void quickSort(int[] nums, int start, int end) {
		if(start >= end) return;
		int pivot = partition(nums, start, end);
		quickSort(nums, start, pivot - 1);
		quickSort(nums, pivot + 1, end);
	}

	private int partition(int[] nums, int start, int end) {
		int low = start, pivot = end;
		for (int i = start; i < pivot; i++) {
			if (nums[i] < nums[pivot])
				ArrayUtils.swap(nums, low++, i);
		}
		ArrayUtils.swap(nums, low, pivot);
		return low;
	}

	public static void main(String[] args) {
		Random random = new Random();
		int[] randomArray = new int[10];
		for (int i = 0; i < randomArray.length; i++) {
			randomArray[i] = random.nextInt(100);
		}
		ArrayUtils.print(randomArray);
		new QuickSort().quickSort(randomArray, 0, randomArray.length - 1);
		ArrayUtils.print(randomArray);
	}

}
