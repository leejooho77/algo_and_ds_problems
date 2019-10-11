package com.juho.algo.prac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.juho.algo.prac.util.ArrayUtils;

/**
 * Given a collection of distinct integers, return all possible permutations.
 * 
 * Example:
 * Input: [1,2,3]
 * Output: [
 *  [1,2,3],
 *  [1,3,2],
 *  [2,1,3],
 *  [2,3,1],
 *  [3,1,2],
 *  [3,2,1]
 * ]
 * 
 * @author Juho Lee
 * @since Oct 10, 2019
 */
public class problem_0103 {

	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> perm = new ArrayList<>();
		permute(perm, nums, 0);
		return perm;
	}
	
	private void permute(List<List<Integer>> perm, int[] nums, int i) {
		if(i == nums.length) {
			List<Integer> curr = Arrays.stream(nums).boxed().collect(Collectors.toList());
			perm.add(curr);
			return;
		}
		for(int j = i; j < nums.length; j++) {
			ArrayUtils.swap(nums, i, j);
			permute(perm, nums, i + 1);
			ArrayUtils.swap(nums, i, j);
		}
	}
	
}
