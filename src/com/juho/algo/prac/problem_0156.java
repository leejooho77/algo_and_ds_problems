package com.juho.algo.prac;

/**
 * Kaprekar's Constant is the number 6174.
 * This number is special because it has the property where for any 4-digit number that has 2 or more unique digits,
 * if you repeatedly apply a certain function it always reaches the number 6174.
 *
 * This certain function is as follows:
 * - Order the number in ascending form and descending form to create 2 numbers.
 * - Pad the descending number with zeros until it is 4 digits in length.
 * - Subtract the ascending number from the descending number.
 * - Repeat.
 *
 * Given a number n, find the number of times the function needs to be applied to reach Kaprekar's constant.
 *
 * @author Juho Lee
 * @since Nov 8, 2019
 */
public class problem_0156 {

    public final int KAPREKAR_CONSTANT = 6174;

    public int kaprekarIterations(int n) {
        int count = 0;
        while(n != KAPREKAR_CONSTANT) {
            int asc = n, desc = n;
            asc = sort(asc, false);
            desc = sort(desc, true);
            n = desc - asc;
            System.out.format("%d - %d = %d\n", desc, asc, n);
            count++;
        }
        return count;
    }

    private int sort(int n, boolean isDescending) {
        int[] bucket = new int[10];
        while(n != 0) {
            bucket[n % 10]++;
            n /= 10;
        }
        if(isDescending) {
            for (int i = bucket.length - 1; i >= 0; i--) {
                while (bucket[i] > 0) {
                    n *= 10;
                    n += i;
                    bucket[i]--;
                }
            }
            while(n < 1000)  n *= 10;
        } else {
            for (int i = 0; i < bucket.length; i++) {
                while (bucket[i] > 0) {
                    n *= 10;
                    n += i;
                    bucket[i]--;
                }
            }
        }
        return n;
    }

}