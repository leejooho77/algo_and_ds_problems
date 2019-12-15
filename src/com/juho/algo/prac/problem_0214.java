package com.juho.algo.prac;

/**
 * Given a 32-bit integer, swap the 1st and 2nd bit, 3rd and 4th bit, up til the 31st and 32nd bit.
 *
 * @author Juho Lee
 * @since Dec 14, 2019
 */
public class problem_0214 {

    public int swapBits(int num) {
        // get all even bits
        int evenBits = num & 0xAAAAAAAA;
        // get all odd bits
        int oddBits = num & 0x55555555;
        // shift right by one to swap
        evenBits >>= 1;
        // shift left by one to swap
        oddBits <<= 1;
        return (evenBits | oddBits);
    }

}