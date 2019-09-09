package com.juho.algo.prac;

/**
 * Given a string with the initial condition of dominoes, where:
 *  - . represents that the domino is standing still
 *  - L represents that the domino is falling to the left side
 *  - R represents that the domino is falling to the right side
 *  
 *  Figure out the final position of the dominoes. 
 *  If there are dominoes that get pushed on both ends, the force cancels out and that domino remains upright.
 *  
 *  Example:
 *  Input:  ..R...L..R., Output: ..RR.LL..RR
 *  
 * @author leejooho77
 * @since Aug 10, 2019
 */
public class problem_0024 {
	
	public String pushDominoes(String dominoes) {
        char[] cs = dominoes.toCharArray();
        for(int l = 0, r = 0; r <= dominoes.length(); r++) {
            if(r == dominoes.length() && cs[l] == 'R') {
                while(l < r) cs[l++] = 'R';
            } else if(r < dominoes.length()) {
                if(cs[l] == 'R' && cs[r] == 'L') {
                    int temp = r;
                    while(l < temp) {
                        cs[l++] = 'R';
                        cs[temp--] = 'L';
                    }
                    l = ++r;
                } else if(cs[r] == 'L') {
                    while(l < r) cs[l++] = 'L';
                } else if(cs[r] == 'R') {
                    if(cs[l] == 'R') {
                        while(l < r) cs[l++] = 'R';
                    }
                    else l = r;
                }
            }
        }
        return String.valueOf(cs);
    }

}
