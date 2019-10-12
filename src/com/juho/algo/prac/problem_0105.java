package com.juho.algo.prac;

import java.util.LinkedList;

/**
 * The set [1,2,3,...,n] contains a total of n! unique permutations.
 * By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
 * 
 *  1. "123"
 *  2. "132"
 *  3. "213"
 *  4. "231"
 *  5. "312"
 *  6. "321"
 *  
 * Given n and k, return the kth permutation sequence.
 *  
 * Note:
 *  - Given n will be between 1 and 9 inclusive.
 *  - Given k will be between 1 and n! inclusive.
 *  
 * Example 1:
 * Input: n = 3, k = 3, Output: "213"
 * 
 * Example 2:
 * Input: n = 4, k = 9, Output: "2314"
 * 
 * @author Juho Lee
 * @since Oct 11, 2019
 */
public class problem_0105 {
	
	/**
	 * https://leetcode.com/problems/permutation-sequence/discuss/22507/%22Explain-like-I'm-five%22-Java-Solution-in-O(n)
	 * 
	 * @param n
	 * @param k
	 * @return String
	 */
	public String getPermutation(int n, int k) {
		int[] factorial = getFactorial(n);
		StringBuilder sb = new StringBuilder();
		LinkedList<Integer> list = new LinkedList<>();
		for(int i = 0; i < n; i++) list.add(i + 1);
		k = k - 1;
		for(int i = 1; i <= n; i++) {
			int idx = k/factorial[n - i];
			sb.append(list.get(idx));
			list.remove(idx);
			k = k - idx * factorial[n - i];
		}
        return sb.toString();
    }
	
	private int[] getFactorial(int n) {
		int[] factorial = new int[n + 1];
		factorial[0] = 1;
		for(int i = 1; i < factorial.length; i++) factorial[i] = i * factorial[i - 1];
		return factorial;
	}

}
