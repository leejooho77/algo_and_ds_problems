package com.juho.algo.prac;

/**
 * Given an array of characters, compress it in-place.
 * The length after compression must always be smaller than or equal to the original array.
 * Every element of the array should be a character (not int) of length 1.
 * After you are done modifying the input array in-place, return the new length of the array.
 * 
 * Follow up: Could you solve it using only O(1) extra space?
 * 
 * Example 1:
 * Input: ["a","a","b","b","c","c","c"], Output: Return 6 
 * The first 6 characters of the input array should be: ["a","2","b","2","c","3"]
 * Explanation: "aa" is replaced by "a2". "bb" is replaced by "b2". "ccc" is replaced by "c3".
 * 
 * Example 2:
 * Input: ["a"], Output: Return 1, and the first 1 characters of the input array should be: ["a"]
 * Explanation: Nothing is replaced.
 * 
 * Example 3:
 * Input: ["a","b","b","b","b","b","b","b","b","b","b","b","b"], Output: Return 4 
 * The first 4 characters of the input array should be: ["a","b","1","2"].
 * Explanation: Since the character "a" does not repeat, it is not compressed. 
 * 	            "bbbbbbbbbbbb" is replaced by "b12".
 *              Notice each digit has it's own entry in the array.
 *              
 * Note:
 *  - All characters have an ASCII value in [35, 126].
 *  - 1 <= len(chars) <= 1000.
 * 
 * @author Juho Lee
 * @since 
 */
public class problem_0098 {

	public int compress(char[] chars) {
		// Have two pointers: one for read and other for write
		int read = 0, write = 0, count = 1;
		// As we read the chars check if current char is equal to next char
		for(; read < chars.length; read++) {
			// if we reach at the end or the current char is not equal to next char
			// compress and overwrite on the array
			if(read == chars.length - 1 || chars[read] != chars[read + 1]) {
				chars[write++] = chars[read];
				if(count > 1) {
					String s = String.valueOf(count);
					for(int i = 0; i < s.length(); i++) {
						chars[write++] = s.charAt(i);
					}
					count = 1;
				}
			}
			// else increment count
			else if(chars[read] == chars[read + 1])
				count++;
		}
		// return new length
		return write;
	}
	
}
