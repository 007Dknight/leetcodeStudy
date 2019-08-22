package com.knight.official.easy;

/**
 * Implement strStr().
 *
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 * Example 1:
 *
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * Example 2:
 *
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 * Clarification:
 *
 * What should we return when needle is an empty string? This is a great question to ask during an interview.
 *
 * For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
 * @Author: knight
 * @Date: 2019-08-20 18:09
 */
public class ImplementStrStr28 {
    public static int strStr(String haystack, String needle) {
        if(null != haystack && null != needle && haystack.equals(needle))   return 0;
        if(null == haystack || haystack.length() == 0)  return -1;
        if(!haystack.contains(needle)){
            return -1;
        }
        for (int i = 0; i < haystack.length(); i++) {
            String temp = haystack.substring(i);
            if(temp.startsWith(needle)){
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String a = "a";
        String b = "a";
        System.out.println(strStr(a,b));
    }
}
