package com.juho.algo.prac;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given a string S of lowercase letters, a duplicate removal consists of choosing two adjacent and equal letters, and removing them.
 * We repeatedly make duplicate removals on S until we no longer can.
 * Return the final string after all such duplicate removals have been made.  It is guaranteed the answer is unique.
 *
 * Example 1:
 * Input: "abbaca", Output: "ca"
 * Explanation: For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.
 *              The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".
 *
 * Note:
 *  - 1 <= S.length <= 20000
 *  - S consists only of English lowercase letters.
 *
 * @author Juho Lee
 * @since Jan 12, 2020
 */
public class problem_0241 {

    public String removeDuplicates(String S) {
        Deque<Character> stack = new ArrayDeque<>();
        for(char c : S.toCharArray()) {
            if(!stack.isEmpty() && c == stack.peek())
                stack.pop();
            else
                stack.push(c);
        }
        StringBuilder result = new StringBuilder();
        while(!stack.isEmpty()) result.insert(0, stack.pop());
        return result.toString();
    }

}