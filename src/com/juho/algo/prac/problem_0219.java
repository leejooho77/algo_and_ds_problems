package com.juho.algo.prac;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a sorted integer array nums, where the range of elements are in the inclusive range [lower, upper], return its missing ranges.
 *
 * Example:
 * Input: nums = [0, 1, 3, 50, 75], lower = 0 and upper = 99, Output: ["2", "4->49", "51->74", "76->99"]
 *
 * @author Juho Lee
 * @since Dec 19, 2019
 */
public class problem_0219 {

    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        if(upper <= lower || lower > nums[nums.length - 1]) return result;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] < lower || nums[i] >= upper)
                continue;
            else if(nums[i] == lower)
                lower++;
            else {
                StringBuilder sb = new StringBuilder();
                sb.append(lower);
                if(nums[i] > lower + 1) {
                    sb.append("->");
                    if (upper < nums[i]) {
                        sb.append(upper);
                        break;
                    } else
                        sb.append(nums[i] - 1);
                }
                lower = nums[i] + 1;
                result.add(sb.toString());
            }
        }
        if(lower + 1 < upper)
            result.add(String.format("%d->%d", lower, upper));
        else if(lower + 1 == upper)
            result.add(String.valueOf(lower));
        return result;
    }

}