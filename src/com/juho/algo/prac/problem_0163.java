package com.juho.algo.prac;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given two strings s and t, determine if they are isomorphic.
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * All occurrences of a character must be replaced with another character while preserving the order of characters.
 * No two characters may map to the same character but a character may map to itself.
 *
 * Example 1:
 * Input: s = "egg", t = "add", Output: true
 *
 * Example 2:
 * Input: s = "foo", t = "bar", Output: false
 *
 * Example 3:
 * Input: s = "paper", t = "title", Output: true
 *
 * Note:
 *  - You may assume both s and t have the same length.
 *
 * @author Juho Lee
 * @since Nov 14, 2019
 */
public class problem_0163 {

    public boolean isIsomorphicOptimized(String s, String t) {
        int[] m = new int[512];
        for(int i = 0; i < s.length(); i++) {
            if(m[s.charAt(i)] != m[t.charAt(i) + 256])
                return false;
            m[s.charAt(i)] = m[t.charAt(i) + 256] = i + 1;
        }
        return true;
    }

    public boolean isIsomorphicWithMapAndSet(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < s.length(); i++) {
            if(set.contains(t.charAt(i)) && !map.containsKey(s.charAt(i)))
                return false;
            if(!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), t.charAt(i));
                set.add(t.charAt(i));
            }
            else if(map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) != t.charAt(i))
                return false;
        }
        return true;
    }

}