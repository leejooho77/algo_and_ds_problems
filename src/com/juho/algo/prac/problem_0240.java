package com.juho.algo.prac;

/**
 * Given two non-negative integers num1 and num2 represented as strings,
 * return the product of num1 and num2, also represented as a string.
 *
 * Example 1:
 * Input: num1 = "2", num2 = "3", Output: "6"
 *
 * Example 2:
 * Input: num1 = "123", num2 = "456", Output: "56088"
 *
 * Note:
 *  - The length of both num1 and num2 is < 110.
 *  - Both num1 and num2 contain only digits 0-9.
 *  - Both num1 and num2 do not contain any leading zero, except the number 0 itself.
 *  - You must not use any built-in BigInteger library or convert the inputs to integer directly.
 *
 * @author Juho Lee
 * @since Jan 11, 2020
 */
public class problem_0240 {

    public String multiply(String num1, String num2) {
        int maxSize = num1.length() + num2.length();
        int[] result = new int[maxSize];
        for(int i = num1.length() - 1; i >= 0; i--) {
            for(int j = num2.length() - 1; j >= 0; j--) {
                int value = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int carry = i + j;
                int curr = i + j + 1;
                int sum = result[curr] + value;
                result[curr] = sum % 10;;
                result[carry] += sum / 10;
            }
        }
        StringBuilder answer = new StringBuilder();
        for(int i : result) if(answer.length() != 0 || i != 0) answer.append(i);
        return answer.length() == 0 ? "0" : answer.toString();
    }

}