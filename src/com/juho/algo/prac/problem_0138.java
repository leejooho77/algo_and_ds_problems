package com.juho.algo.prac;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 *
 * Example:
 * Input: "25525511135", Output: ["255.255.11.135", "255.255.111.35"]
 *
 * @author Juho Lee
 * @since Oct 28, 2019
 */
public class problem_0138 {

    public List<String> restoreIpAddresses(String s) {
        List<String> ips = new ArrayList<>();
        for(int i = 1; i <= 3 && i < s.length(); i++) {
            String A = s.substring(0, i);
            if(!check(A)) continue;
            for(int j = i + 1; j - i <= 3 && j < s.length(); j++) {
                String B = s.substring(i, j);
                if(!check(B)) continue;
                for(int k = j + 1; k - j <= 3 && k < s.length(); k++) {
                    String C = s.substring(j, k);
                    String D = s.substring(k);
                    if(!check(C) || !check(D)) continue;
                    ips.add(A + "." + B + "." + C + "." + D);
                }
            }
        }
        return ips;
    }

    private boolean check(String section) {
        if(section.length() > 3 || Integer.valueOf(section) < 0 || Integer.valueOf(section) > 255 ||
                (section.charAt(0) == '0' && section.length() > 1)) return false;
        return true;
    }

}
