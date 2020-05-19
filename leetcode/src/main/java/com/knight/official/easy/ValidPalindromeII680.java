package com.knight.official.easy;

/**
 *  Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.
 *
 * Example 1:
 *
 * Input: "aba"
 * Output: True
 *
 * Example 2:
 *
 * Input: "abca"
 * Output: True
 * Explanation: You could delete the character 'c'.
 *
 * Note:
 *
 *     The string will only contain lowercase characters a-z. The maximum length of the string is 50000.
 * @author: create by knight007
 * @version: v1.0
 * @description: com.knight.official.easy
 * @date: 2020/5/19 22:52
 */
public class ValidPalindromeII680 {
    public static boolean validPalindrome(String s) {
        if(null == s || s.length() <= 1) return true;
        if(noDel(s)){
            return true;
        }
        if(delLeft(s)){
            return true;
        }
        if(delRight(s)){
            return true;
        }

        return false;
    }
    private static boolean noDel(String s){
        int start = 0;
        int end = s.length() -1;
        while (start<end) {
            char startChar = s.charAt(start);
            char endChar = s.charAt(end);
            if (startChar == endChar) {
                start++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }
    private static boolean delLeft(String s){
        int start = 0;
        int end = s.length() -1;
        boolean flag = false;

        while (start<end) {
            char startChar = s.charAt(start);
            char endChar = s.charAt(end);
            if (startChar == endChar) {
                start++;
                end--;
            } else {
                if(flag){
                    //说明已经删除过一个字符了
                    return false;
                }
                flag = true;
                if(s.charAt(start+1) == endChar) {
                    start = start + 2;
                    end--;
                }else {
                    return false;
                }
            }

        }
        return true;
    }
    private static boolean delRight(String s){
        int start = 0;
        int end = s.length() -1;
        boolean flag = false;

        while (start<end) {
            char startChar = s.charAt(start);
            char endChar = s.charAt(end);
            if (startChar == endChar) {
                start++;
                end--;
            } else {
                if(flag){
                    //说明已经删除过一个字符了
                    return false;
                }
                flag = true;
                if(startChar == s.charAt(end-1)) {
                    start++;
                    end = end -2;
                }else {
                    return false;
                }
            }

        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga";
        System.out.println(validPalindrome(s));
    }
}
