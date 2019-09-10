package com.juho.algo.prac;

/**
 * Implement a basic calculator to evaluate a simple expression string.
 * The expression string contains only non-negative integers, +, -, *, / operators and empty spaces. 
 * The integer division should truncate toward zero.
 * 
 * Example 1:
 * Input: "3+2*2", Output: 7
 * 
 * Example 2:
 * Input: " 3/2 ", Output: 1
 * 
 * Example 3:
 * Input: " 3+5 / 2 ", Output: 5
 * 
 * @author Juho Lee
 * @since Sep 09, 2019
 */
public class problem_0017 {

	public int calculate(String s) {
		s = s.trim();
		int prev = 0, sum = 0;
		char sign = '+';
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(c == ' ')
				continue;
			else if(Character.isDigit(c)) {
				int value = c - '0';
				while(i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
					value = value * 10 + (s.charAt(i + 1) - '0');
					i++;
				}
				if(sign == '+') {
					sum += prev;
					prev = 0;
					prev += value;
				} else if(sign == '-') {
					sum += prev;
					prev = 0;
					prev -= value;
				} else if(sign == '*') {
					prev *= value;
				} else {
					prev /= value;
				}
			} else
				sign = c;
		}
		return sum + prev;
	}
	
}
