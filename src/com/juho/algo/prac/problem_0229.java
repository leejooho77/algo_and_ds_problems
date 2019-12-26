package com.juho.algo.prac;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * A valid parentheses string is either empty (""), "(" + A + ")", or A + B, where A and B are valid parentheses strings, and + represents string concatenation.
 * For example, "", "()", "(())()", and "(()(()))" are all valid parentheses strings.
 *
 * A valid parentheses string S is primitive if it is nonempty, and there does not exist a way to split it into S = A+B, with A and B nonempty valid parentheses strings.
 * Given a valid parentheses string S, consider its primitive decomposition: S = P_1 + P_2 + ... + P_k, where P_i are primitive valid parentheses strings.
 * Return S after removing the outermost parentheses of every primitive string in the primitive decomposition of S.
 *
 * Example:
 * Input: "(()())(())(()(()))", Output: "()()()()(())"
 * Explanation: The input string is "(()())(())(()(()))", with primitive decomposition "(()())" + "(())" + "(()(()))".
 *              After removing outer parentheses of each part, this is "()()" + "()" + "()(())" = "()()()()(())".
 *
 * @author Juho Lee
 * @since Dec 26, 2019
 */
public class problem_0229 {

    public String removeOuterParentheses_stack(String S) {
        StringBuilder sb = new StringBuilder();
        Deque<Character> stack = new ArrayDeque<>();
        for(char c : S.toCharArray()) {
            if(c == ')') {
                if(stack.size() > 1)
                    sb.append(c);
                stack.pop();
            } else {
                if(stack.size() > 0)
                    sb.append(c);
                stack.push(c);
            }
        }
        return sb.toString();
    }

    public String removeOuterParentheses(String S) {
        StringBuilder str = new StringBuilder();
        int count = 0;

        for(int i = 0; i < S.length();i++){
            if(S.charAt(i) == '(' && count++ > 0){
                str.append(S.charAt(i));
            }else if(S.charAt(i) == ')' && count-- > 1){
                str.append(S.charAt(i));
            }
        }
        return str.toString();
    }

}