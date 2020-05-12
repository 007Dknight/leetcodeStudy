package com.knight.official.medium;


/**
 * Implement atoi which converts a string to an integer.
 *
 * The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.
 *
 * The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.
 *
 * If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
 *
 * If no valid conversion could be performed, a zero value is returned.
 *
 * Note:
 *
 *     Only the space character ' ' is considered as whitespace character.
 *     Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.
 *
 * Example 1:
 *
 * Input: "42"
 * Output: 42
 *
 * Example 2:
 *
 * Input: "   -42"
 * Output: -42
 * Explanation: The first non-whitespace character is '-', which is the minus sign.
 *              Then take as many numerical digits as possible, which gets 42.
 *
 * Example 3:
 *
 * Input: "4193 with words"
 * Output: 4193
 * Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
 *
 * Example 4:
 *
 * Input: "words and 987"
 * Output: 0
 * Explanation: The first non-whitespace character is 'w', which is not a numerical
 *              digit or a +/- sign. Therefore no valid conversion could be performed.
 *
 * Example 5:
 *
 * Input: "-91283472332"
 * Output: -2147483648
 * Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
 *              Thefore INT_MIN (−231) is returned.
 *
 *
 *
 */
public class StringtoIntegeratoi8 {
    /**
     * if the str is start with a number,return this number
     * else return 0
     *
     * @param str
     * @return
     */
    public static int myAtoi(String str) {
//        if(StringUtils.isBlank(str))    return 0;
        if(str.length() == 0)   return 0;
        str = str.trim();
        if(str.length() == 0) return 0;

        //去掉前面所有的空格

        StringBuffer sb = new StringBuffer();
        char start = str.charAt(0);
        if('-'== start || '+'== start || Character.isDigit(start)){
            sb.append(start);
        }else {
            return 0;
        }
        for (int i = 1; i < str.length(); i++) {
            char temp = str.charAt(i);
            if(Character.isDigit(temp)){
                sb.append(temp);
            }else {
                break;
            }
        }
        if(sb.length() == 1 && ('-'== start || '+'== start)){
            return 0;
        }
        Long aLong = Long.valueOf(sb.toString());
        if(aLong < Integer.MIN_VALUE){
            return -2147483648;
        }
        return aLong.intValue();
    }
    public int get(String str){
        // remove white spaces
        str = str.trim();
        // check length
        if(str.length() == 0) return 0;
        // check sign
        boolean sign = true;
        if(str.charAt(0) == '-' || str.charAt(0) == '+'){
            if(str.charAt(0) == '-'){
                sign = false;
            }
            str = str.substring(1);
        }
        // check length again
        if(str.length() == 0) return 0;
        int i = 0;
        // check leading zeros
        while(i < str.length() && str.charAt(i) == '0'){
            i++;
        }

        // initialize integer and count digits
        long num = 0;
        int digit = 0;
        while(i < str.length()){
            char curr = str.charAt(i);
            // count digits (digits > 10 means overflow)
            // check for non digit
            if(digit > 10 || curr < '0' || curr > '9') break;
            // convert digit, add to integer result
            num = num * 10 + Character.getNumericValue(curr);
            digit++;
            i++;
        }
        // overflow case
        if(digit > 10){
            if(sign) return Integer.MAX_VALUE;
            return Integer.MIN_VALUE;
        }
        // overflow with 10 digits
        if(!sign && num + Integer.MIN_VALUE > 0){
            return Integer.MIN_VALUE;
        }
        // overflow with 10 digits
        if(sign && num >= Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        // check sign and return value
        return sign ? (int) num : (int) - num;
    }

    public static void main(String[] args) {
        String s = "+001";
        System.out.println(Integer.valueOf(s));

        String str ="2147483648";
        System.out.println(myAtoi(str));
    }
}
