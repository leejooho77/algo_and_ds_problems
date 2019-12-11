package com.juho.algo.prac;

/**
 * Validate if a given string can be interpreted as a decimal number.
 *
 * Some examples:
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 * " -90e3   " => true
 * " 1e" => false
 * "e3" => false
 * " 6e-1" => true
 * " 99e2.5 " => false
 * "53.5e93" => true
 * " --6 " => false
 * "-+3" => false
 * "95a54e53" => false
 *
 * Note: It is intended for the problem statement to be ambiguous.
 *      You should gather all requirements up front before implementing one.
 *      However, here is a list of characters that can be in a valid decimal number:
 *       - Numbers 0-9
 *       - Exponent - "e"
 *       - Positive/negative sign - "+"/"-"
 *       - Decimal point - "."
 *
 * Of course, the context of these characters also matters in the input.
 *
 * @author Juho Lee
 * @since Dec 11, 2019
 */
public class problem_0210 {

    public boolean isNumber(String s) {
        if(s == null)
            return false;
        // remove all whitespaces
        s = s.trim();
        if(s.length() == 0)
            return false;
        // split by "e"
        String[] expo = s.split("e");
        if(s.charAt(s.length() - 1) == 'e')
            return false;
        if(expo.length == 1) {
            return checkNumber(expo[0], true);
        } else if(expo.length == 2) {
            return checkNumber(expo[0], true) && checkNumber(expo[1], false);
        }
        else
            return false;
    }

    private boolean checkNumber(String s, boolean allowDecimal) {
        if(s.length() == 0) return false;
        boolean sawSign = (s.charAt(0) == '+' || s.charAt(0) == '-');
        if(sawSign) {
            s = s.substring(1);
            if(s.length() == 0)
                return false;
        }
        if(s.equals("."))
            return false;
        // decimal allowed
        if(allowDecimal) {
            int decimal = 0;
            for(int i = 0; i < s.length(); i++) {
                if(s.charAt(i) == '.') {
                    decimal++;
                    if(decimal > 1)
                        return false;
                }
                else if(!Character.isDigit(s.charAt(i)))
                    return false;
            }
            return true;
        }
        // decimal not allowed
        else {
            for(int i = 0; i < s.length(); i++) {
                if(!Character.isDigit(s.charAt(i)))
                    return false;
            }
            return true;
        }
    }

}