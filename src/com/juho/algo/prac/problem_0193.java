package com.juho.algo.prac;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return all possible palindrome partitioning of s.
 *
 * Example:
 * Input: "aab", Output:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 *
 * @author Juho Lee
 * @since Nov 27, 2019
 */
public class problem_0193 {

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        partition(result, new ArrayList<>(), s, 0);
        return result;
    }

    private void partition(List<List<String>> result, List<String> list, String s, int offset) {
        if(offset == s.length()) {
            result.add(new ArrayList<>(list));
            return;
        }
        for(int i = offset + 1; i <= s.length(); i++) {
            String sub = s.substring(offset, i);
            if(isPalindrome(sub)) {
                list.add(sub);
                partition(result, list, s, i);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        return s.equals(new StringBuilder(s).reverse().toString());
    }

}