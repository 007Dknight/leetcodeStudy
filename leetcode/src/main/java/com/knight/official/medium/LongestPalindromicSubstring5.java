package com.knight.official.medium;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * <p>
 * Example 1:
 * <p>
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * <p>
 * Example 2:
 * <p>
 * Input: "cbbd"
 * Output: "bb"
 *
 * @author: create by knight007
 * @version: v1.0
 * @description: com.knight.official.medium
 * @date: 2019/8/14 21:33
 */
//todo 超时
public class LongestPalindromicSubstring5 {
    public static String longestPalindrome(String s) {
        if (null == s || s.length() <= 1) return s;
        int length = s.length();
        String result = s.substring(0,1);
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                String temp = s.substring(i, j + 1);
                boolean flag = judgePalindromicString(temp);
                if(flag){
                    if(temp.length() > result.length()){
                        result = temp;
                    }
                }else {
                    continue;
                }
            }
        }
        return result;
    }
    static boolean judgePalindromicString(String s){
        if(null == s || s.length() <= 1)    return true;
        StringBuffer sb = new StringBuffer(s);
        sb.reverse();
        String temp = sb.toString();
        if(temp.equals(s)){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "cbbd";
        System.out.println(longestPalindrome(s));
    }
}
