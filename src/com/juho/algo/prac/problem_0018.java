package com.juho.algo.prac;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a sequence of numbers, find the longest sequence that contains only 2 unique numbers.
 * 
 * Example:
 * Input: [1, 3, 5, 3, 1, 3, 1, 5], Output: 4
 * 
 * @author Juho Lee
 * @since Aug 04, 2019
 */
public class problem_0018 {

	public static int findSequence(List<Integer> A) {
		if(A.size() <= 2) return A.size();
		boolean isA = true;
		int a = A.get(0), b = A.get(1), curr = 2, max = 2;
		Set<Integer> uniqueNumbers = new HashSet<>(Arrays.asList(a, b));
		for(int i = 2; i < A.size(); i++) {
			int n = A.get(i);
			if(uniqueNumbers.contains(n)) {
				curr++;
				max = Math.max(curr, max);
			} else {
				if(isA) {
					uniqueNumbers.remove(a);
					a = n;
					uniqueNumbers.add(a);
				} else {
					uniqueNumbers.remove(b);
					b = n;
					uniqueNumbers.add(b);
				}
				curr = 2;
				isA = !isA;
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		System.out.println(findSequence(Arrays.asList(1,2,3,4,5,6,7,8,9)));
	}
	
}
