package com.juho.algo.prac;

/**
 * We are playing the Guess Game. The game is as follows:
 * I pick a number from 1 to n. You have to guess which number I picked.
 * Every time you guess wrong, I'll tell you whether the number is higher or lower.
 * You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):
 *
 * -1 : My number is lower
 *  1 : My number is higher
 *  0 : Congrats! You got it!
 *
 * Example :
 * Input: n = 10, pick = 6, Output: 6
 *
 * @author Juho Lee
 * @since Nov 20, 2019
 */
public class problem_0178 {

    /**
        The guess API is defined in the parent class GuessGame.
        @param nums, your guess
        @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
        int guess(int num);
    */
    public int guess(int nums) {
        return 0;
    }

    public int guessNumber(int n) {
        int start = 1, end = n;
        while(start <= end) {
            int mid = start + (end - start)/2;
            if(guess(mid) == 0)
                return mid;
            else if(guess(mid) > 0) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return 1;
    }

}
