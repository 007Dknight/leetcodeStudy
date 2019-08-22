package com.knight.official.easy;

/**
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 * <p>
 * Example 1:
 * <p>
 * Input: 121
 * Output: true
 * Example 2:
 * <p>
 * Input: -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * Example 3:
 * <p>
 * Input: 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 * Follow up:
 * <p>
 * Coud you solve it without converting the integer to a string?
 *
 * @author: create by knight007
 * @version: v1.0
 * @description: com.knight.official.easy
 * @date: 2019/8/17 23:23
 */
public class PalindromNumber9 {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x < 10) return true;
        String s = String.valueOf(x);
        StringBuilder sb = new StringBuilder(s);
        StringBuilder reverse = sb.reverse();
        if(s.equals(reverse.toString())){
            return true;
        }
        return false;
    }
}
