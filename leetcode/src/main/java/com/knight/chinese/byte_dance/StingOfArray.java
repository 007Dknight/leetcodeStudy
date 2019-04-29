package com.knight.chinese.byte_dance;

import java.util.Arrays;

/**
 *  字符串的排列
 *  给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 *
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 *
 * 示例1:
 *
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 *
 *
 *
 * 示例2:
 *
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 * @author: create by knight007
 * @version: v1.0
 * @description: com.knight.leetcode_china.byte_dance
 * @date:2018/12/3
 */
public class StingOfArray {
    public static boolean checkInclusion(String s1, String s2) {
        if(s1.length() == 0){
            return true;
        }
        int s1Length = s1.length();
        int s2Length = s2.length();

        if(s2Length < s1Length){
            return false;
        }
        char[] s1Char = s1.toCharArray();
        Arrays.sort(s1Char);
        int target = 0;
        while (target < s2Length){
            String temp = String.valueOf((s2.toCharArray()[target]));
            outer:if(s1.contains(temp) && (target+s1Length) <= s2Length){
                String index = s2.substring(target,target+s1Length);
                char[] indexChar = index.toCharArray();
                Arrays.sort(indexChar);
                for (int i = 0; i < s1Char.length; i++) {
                    if(s1Char[i] != indexChar[i]){
                        break outer;
                    }
                }
                return true;
            }
            target++;
        }
        return false;
    }

    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "ooolleoooleh";//"hello"
        System.out.println(checkInclusion(s1,s2));
    }
}
