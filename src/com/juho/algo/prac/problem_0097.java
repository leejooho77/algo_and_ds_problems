package com.juho.algo.prac;

import java.util.HashMap;
import java.util.Map;

/**
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * 
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 
 * For example, two is written as II in Roman numeral, just two one's added together. 
 * Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.
 * 
 * Roman numerals are usually written largest to smallest from left to right. 
 * However, the numeral for four is not IIII. Instead, the number four is written as IV. 
 * Because the one is before the five we subtract it making four. 
 * 
 * The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 *  - I can be placed before V (5) and X (10) to make 4 and 9. 
 *  - X can be placed before L (50) and C (100) to make 40 and 90. 
 *  - C can be placed before D (500) and M (1000) to make 400 and 900.
 *  
 * Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to 3999.
 * 
 * Example 1:
 * Input: "III", Output: 3
 * 
 * Example 2:
 * Input: "IV", Output: 4
 * 
 * Example 3:
 * Input: "IX", Output: 9
 * 
 * Example 4:
 * Input: "LVIII", Output: 58
 * Explanation: L = 50, V= 5, III = 3.
 * 
 * Example 5:
 * Input: "MCMXCIV", Output: 1994
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 * 
 * @author Juho Lee
 * @since Oct 4, 2019
 */
public class problem_0097 {

	public String intToRoman(int num) {
        String result = "";
        Map<Integer, Character> romanMapper = getMapper();
        int dec = 1;
        while(num > 0) {
            int digit = num % 10;
            if(digit > 0)
                result = convert(romanMapper, digit * dec, dec) + result;
            num /= 10;
            dec *= 10;
        }
        return result;
    }
    
    private String convert(Map<Integer, Character> romanMapper, int num, int dec) {
        String result = "";
        if(romanMapper.containsKey(num)) 
            result = String.valueOf(romanMapper.get(num));
        else if(romanMapper.containsKey(num + dec))
            result = String.valueOf(romanMapper.get(dec)) + String.valueOf(romanMapper.get(num + dec));
        else {
            while(num > 0 && !romanMapper.containsKey(num)) {
                result = romanMapper.get(dec) + result;
                num -= dec;
            }
            result = romanMapper.get(num) + result;
        }
        return result;
    }
    
    private Map<Integer, Character> getMapper() {
		Map<Integer, Character> romanMapper = new HashMap<>();
		romanMapper.put(1, 'I');
		romanMapper.put(5, 'V');
		romanMapper.put(10, 'X');
		romanMapper.put(50, 'L');
		romanMapper.put(100, 'C');
		romanMapper.put(500, 'D');
		romanMapper.put(1000, 'M');
		return romanMapper;
	}
	
}
