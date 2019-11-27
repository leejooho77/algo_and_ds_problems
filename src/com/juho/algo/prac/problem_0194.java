package com.juho.algo.prac;

/**
 * Given a string, determine if there is a way to arrange the string such that the string is a palindrome.
 * If such arrangement exists, return a palindrome (There could be many arrangements). Otherwise return null.
 *
 * Example 1:
 * Input: “geeksogeeks”, Output: "geeksoskeeg"
 *
 * Example 2:
 * Input: "geeksforgeeks", Output: null
 *
 * @author Juho Lee
 * @since Nov 27, 2019
 */
public class problem_0194 {

    public String findPalindrome(String s) {
        if(isPalindrome(s))
            return s;
        int odd = 0;
        int[] chars = new int[26];
        for(char c : s.toCharArray()) {
            chars[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < chars.length; i++) {
            if(chars[i] % 2 != 0) {
                sb.append(Character.toChars(i + 'a'));
                chars[i]--;
                odd++;
            }
            if(odd > 1)
                return null;
        }
        for(int i = 0; i < chars.length; i++) {
            while(chars[i] > 0) {
                sb.append(Character.toChars(i + 'a'));
                sb.insert(0, Character.toChars(i + 'a'));
                chars[i] -= 2;
            }
        }
        return sb.toString();
    }

    private boolean isPalindrome(String s) {
        return s.equals(new StringBuilder(s).reverse().toString());
    }

}