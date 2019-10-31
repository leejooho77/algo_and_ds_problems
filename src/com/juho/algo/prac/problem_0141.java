package com.juho.algo.prac;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a pattern and a string str, find if str follows the same pattern.
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
 *
 * Example 1:
 * Input: pattern = "abba", str = "dog cat cat dog", Output: true
 *
 * Example 2:
 * Input:pattern = "abba", str = "dog cat cat fish", Output: false
 *
 * Example 3:
 * Input: pattern = "aaaa", str = "dog cat cat dog", Output: false
 *
 * Example 4:
 * Input: pattern = "abba", str = "dog dog dog dog", Output: false
 *
 * Notes: You may assume pattern contains only lowercase letters, and str contains lowercase letters that may be separated by a single space.
 *
 * @author Juho Lee
 * @since Oct 30, 2019
 */
public class problem_0141 {

    public boolean wordPattern(String pattern, String str) {
        Map<Character, String> map = new HashMap<>();
        String[] patternStr = str.split(" ");
        if(pattern.length() != patternStr.length)
            return false;
        for(int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if(map.containsKey(c) && !map.get(c).equals(patternStr[i]))
                return false;
            else if(!map.containsKey(c)) {
                if(!map.containsValue(patternStr[i]))
                    map.put(c, patternStr[i]);
                else
                    return false;
            }
        }
        return true;
    }

}
