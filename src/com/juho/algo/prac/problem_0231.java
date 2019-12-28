package com.juho.algo.prac;

/**
 * Given a non-negative integer num, convert num to base N in string form.
 *
 * @author Juho Lee
 * @since Dec 27, 2019
 */
public class problem_0231 {

    public String convertToBaseN_iter(int num, int N) {
        StringBuilder sb = new StringBuilder();
        while(num > 0) {
            sb.insert(0, num % N);
            num /= N;
        }
        return sb.toString();
    }

    public String convertToBaseN_recur(int num, int N) {
        if(num < 0) return "-" + convertToBaseN_recur(num * -1, N);
        if(num < 7) return String.valueOf(num);
        return convertToBaseN_recur(num / N, N) + String.valueOf(num % N);
    }

}