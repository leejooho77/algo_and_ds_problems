package com.juho.algo.prac;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a list of numbers, find if there exists a pythagorean triplet in that list. 
 * A pythagorean triplet is 3 variables a, b, c where a^2 + b^2 = c^2
 * 
 * Example:
 * Input: [3, 5, 12, 5, 13], Output: True
 * 
 * @author Juho Lee
 * @since Aug 01, 2019
 */
public class problem_0015 {
	
	public static boolean pythagoreanTriplet(List<Integer> A) {
		Set<Integer> set = new HashSet<>();
		for(int i = 0; i < A.size() - 1; i++) {
			for(int j = i + 1; j < A.size(); j++) {
				int n = A.get(i) * A.get(i) + A.get(j) * A.get(j);
				if(set.contains(A.get(i) * A.get(i)) || set.contains(A.get(j) * A.get(j)))
					return true;
				else 
					set.add(n);
			}
		}
		return false;
	}

}
