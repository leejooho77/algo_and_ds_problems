package com.juho.algo.prac;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 *
 * Example:
 * Input: "23", Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 * Note: Although the above answer is in lexicographical order, your answer could be in any order you want.
 *
 * @author Juho Lee
 * @since Dec 3, 2019
 */
public class problem_0202 {

    private final String[] MAPPING = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return new ArrayList<>();
        List<String> result = new ArrayList<>();
        letterCombinations(result, digits, 0, new char[digits.length()]);
        return result;
    }

    private void letterCombinations(List<String> result, String digits, int digit, char[] combination) {
        if(digit == digits.length()) {
            result.add(new String(combination));
            return;
        }
        String mapToString = MAPPING[digits.charAt(digit) - '0'];
        for(int i = 0; i < mapToString.length(); i++) {
            combination[digit] = mapToString.charAt(i);
            letterCombinations(result, digits, digit + 1, combination);
        }
    }

}