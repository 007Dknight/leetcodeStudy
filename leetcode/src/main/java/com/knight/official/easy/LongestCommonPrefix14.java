package com.knight.official.easy;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 * Example 1:
 *
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 *
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * Note:
 *
 * All given inputs are in lowercase letters a-z.
 * @author: create by knight007
 * @version: v1.0
 * @description: com.knight.official.easy
 * @date: 2019/8/14 22:34
 */
public class LongestCommonPrefix14 {
    public static String longestCommonPrefix(String[] strs) {
        String result = "";
        if(null == strs || strs.length == 0)    return result;
        if(strs.length == 1)    return strs[0];
        int target = 0;
        String str = strs[0];
        if(null == str || str.length() <= 0)    return result;
        while (true){
            if(target > str.length())   return result;
            String index = str.substring(0,target);
            if(null == index || index.length() <= 0){
                target++;
                continue;
            }
            for (int j = 1; j < strs.length; j++) {
                String s = strs[j];
                if(null == s || s.length() <= 0||(!s.startsWith(index))){
                    return result;
                }
            }
            result = index;
            target++;
        }
    }

    public static void main(String[] args) {
        String[] s = {"c","c"};
        System.out.println(longestCommonPrefix(s));
    }
}
