package com.juho.algo.prac;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
 * The order of output does not matter.
 *
 * Example 1:
 * Input: s: "cbaebabacd" p: "abc", Output: [0, 6]
 * Explanation:
 *  - The substring with start index = 0 is "cba", which is an anagram of "abc".
 *  - The substring with start index = 6 is "bac", which is an anagram of "abc".
 *
 * @author Juho Lee
 * @since Dec 13, 2019
 */
public class problem_0213 {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if(s.length() < p.length())
            return result;
        int left = 0, right = 0;
        int[] pMap = new int[26], sMap = new int[26];
        initialize(p, pMap);
        for(; right < s.length(); right++) {
            sMap[s.charAt(right) - 'a']++;
            if(right - left + 1 == p.length()) {
                if(compare(pMap, sMap))
                    result.add(left);
                sMap[s.charAt(left++) - 'a']--;
            }

        }
        return result;
    }

    private void initialize(String p, int[] pMap) {
        for(char c : p.toCharArray()) {
            pMap[c - 'a']++;
        }
    }

    private boolean compare(int[] pMap, int[] sMap) {
        for(int i = 0; i < pMap.length; i++) {
            if(pMap[i] != sMap[i])
                return false;
        }
        return true;
    }

}