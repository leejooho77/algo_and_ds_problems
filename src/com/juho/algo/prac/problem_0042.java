package com.juho.algo.prac;

/**
 * The count-and-say sequence is the sequence of integers with the first five terms as following:
 * 
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * 
 * Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.
 * 
 * @author leejooho77
 * @since Aug 28, 2019
 */
public class problem_0042 {

	public String countAndSay(int n) {
		String result = "1";
		while(n-- > 1) {
			int count = 0;
			char c  = result.charAt(0);
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i <= result.length(); i++) {
				if(i == result.length() || c != result.charAt(i)) {
					sb.append(count).append(c);
					if(i < result.length()) {
						count = 1;
						c = result.charAt(i);
					}
				} else 
                    count++;
			}
			result = sb.toString();
		}
		return result;
	}
	
}
