package com.knight.official.easy;
/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 * <p>
 * If the last word does not exist, return 0.
 * <p>
 * Note: A word is defined as a character sequence consists of non-space characters only.
 * <p>
 * Example:
 * <p>
 * Input: "Hello World"
 * Output: 5
 *
 * @Author: knight
 * @Date: 2019-08-21 18:45
 */
public class LengthofLastWord58 {
    public static int lengthOfLastWord(String s) {
        if (null == s || s.length() == 0) return 0;

        String empty = " ";
//        if (s.endsWith(empty)) {
//            return 0;
//        }
        String[] split = s.split(empty);
        if(null == split || split.length == 0)  return 0;
        if(split.length == 1)   return split[0].length();
        String target = split[split.length - 1];
        return target.length();
    }

    public static void main(String[] args) {
        String a =" ";
        System.out.println(lengthOfLastWord(a));
    }
}
