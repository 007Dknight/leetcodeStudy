package com.knight.chinese.byte_dance;

/**
 * 最长公共前缀
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * <p>
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * <p>
 * 说明:
 * <p>
 * 所有输入只包含小写字母 a-z 。
 *
 * @author: create by knight007
 * @version: v1.0
 * @description: com.knight.leetcode_china.byte_dance
 * @date:2018/12/3
 */
public class TheLongStart {
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length <= 0) {
            return "";
        }
        if(strs.length == 1){
            return strs[0];
        }
        String target = strs[0];
        if (target.length() <= 0) {
            return "";
        }
        String startIndex = "";
        for (int i = 0; i < target.length(); i++) {
            startIndex = startIndex + target.toCharArray()[i];
            for (int j = 1; j < strs.length; j++) {
                if(!strs[j].startsWith(startIndex)){
                    return startIndex.substring(0,i);
                }
            }
        }
        return startIndex;
    }

    public static void main(String[] args) {
        String[] s = {"c","c"};
        System.out.println(longestCommonPrefix(s));
    }
}
