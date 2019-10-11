package com.juho.algo.prac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.juho.algo.prac.util.ArrayUtils;

/**
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * 
 * Example:
 * Input: [1,1,2], Output:
 * [
 * 	 [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 * 
 * @author Juho Lee
 * @since Oct 10, 2019
 */
public class problem_0104 {
	
	public List<List<Integer>> permuteUnique(int[] nums) {
		Arrays.sort(nums);
		// keep track the used index
        boolean[] used = new boolean[nums.length];
        List<List<Integer>> perm = new ArrayList<>();
        permute(perm, nums, used, new ArrayList<>());
        return perm;
    }
    
    private void permute(List<List<Integer>> perm, int[] nums, boolean[] used, List<Integer> curr) {
        if(curr.size() == nums.length) {
            perm.add(new ArrayList<>(curr));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
        	// used[i - 1] will also work but !used[i - 1] makes us to get out of the loop earlier than used[i - 1]
            if(used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) 
                continue;
            used[i] = true;
            curr.add(nums[i]);
            permute(perm, nums, used, curr);
            curr.remove(curr.size() - 1);
            used[i] = false;
        }
    }

}
