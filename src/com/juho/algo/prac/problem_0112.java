package com.juho.algo.prac;

/**
 * You are given two strings, A and B. Return whether A can be shifted some number of times to get B.
 * 
 * Example: 
 * Input: A = abcde, B = cdeab, Output: true 
 * Explanation: A can be shifted 3 times to the right to get B.
 * 
 * @author Juho Lee
 * @since Oct 15, 2019
 */
public class problem_0112 {

	public boolean canShifted(String A, String B) {
		if(A.length() != B.length()) 
			return false;
		int a = 0, b = 0;
		for(; b < B.length(); b++) {
			if(A.charAt(a) == B.charAt(b)) {
				int ptr = b;
				while(a < A.length() && A.charAt(a) == B.charAt(ptr)) {
					a++;
					ptr = (ptr + 1) % B.length();
				}
				if(a == A.length() && b == ptr)
					return true;
				else
					a = 0;
			}
		}
		return (A.length() == 0 && B.length() == 0);
	}
	
}
