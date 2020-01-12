package com.juho.algo.prac;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a positive integer n, find all primes less than n.
 *
 * @author Juho Lee
 * @since Jan 11, 2020
 */
public class problem_0238 {

    public List<Integer> findPrimes(int n) {
        List<Integer> result = new ArrayList<>();
        if(n < 2) return result;
        boolean[] nonPrimes = new boolean[n];
        nonPrimes[0] = true;
        for(int i = 2; i * 2 <= n; i++) {
            if(!nonPrimes[i - 1]) {
                for(int j = i * 2; j <= n; j += i) {
                    nonPrimes[j - 1] = true;
                }
            }
        }
        for(int i = 0; i < n; i++) {
            if(!nonPrimes[i])
                result.add(i + 1);
        }
        return result;
    }

}