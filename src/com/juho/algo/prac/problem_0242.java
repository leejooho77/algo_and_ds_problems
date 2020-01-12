package com.juho.algo.prac;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array A of strings made only from lowercase letters,
 * return a list of all characters that show up in all strings within the list (including duplicates).
 * For example, if a character occurs 3 times in all strings but not 4 times,
 * you need to include that character three times in the final answer.
 *
 * You may return the answer in any order.
 *
 * Example 1:
 * Input: ["bella","label","roller"], Output: ["e","l","l"]
 *
 * Example 2:
 * Input: ["cool","lock","cook"], Output: ["c","o"]
 *
 * Note:
 *  - 1 <= A.length <= 100
 *  - 1 <= A[i].length <= 100
 *  - A[i][j] is a lowercase letter
 *
 * @author Juho Lee
 * @since Jan 12, 2020
 */
public class problem_0242 {

    public List<String> commonChars(String[] A) {
        List<String> result = new ArrayList<>();
        int[] map = new int[26];
        for(char c : A[0].toCharArray())
            map[c - 'a']++;
        for(int i = 1; i < A.length; i++) {
            int[] temp = new int[26];
            String s = A[i];
            for(char c : s.toCharArray()) {
                if(map[c - 'a'] > 0) {
                    temp[c - 'a']++;
                    map[c - 'a']--;
                }
            }
            map = temp;
        }
        for(int i = 0; i < map.length; i++) {
            while(map[i] > 0) {
                result.add(String.valueOf((char)('a' + i)));
                map[i]--;
            }
        }
        return result;
    }

}