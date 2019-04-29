package com.knight.chinese.byte_dance;

/**
 * 翻转字符串里的单词
 * <p>
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 * <p>
 * 示例:
 * <p>
 * 输入: "the sky is blue",
 * 输出: "blue is sky the".
 * <p>
 * 说明:
 * <p>
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * <p>
 * 进阶: 请选用C语言的用户尝试使用 O(1) 空间复杂度的原地解法。
 *
 * @author: create by knight007
 * @version: v1.0
 * @description: com.knight.leetcode_china.byte_dance
 * @date:2018/12/15
 */
public class ReverseWordsOfString {
    public static String reverseWords(String s) {
        s = s.trim();
        String[] temp = s.split(" ");
        StringBuffer sb = new StringBuffer();
        for (int i = temp.length-1; i >= 0; i--) {
            temp[i] = temp[i].trim();
            if(temp[i].length() > 0){
                sb.append(temp[i] + " ");
            }
        }
        String result = sb.toString().trim();
        return result;
    }

    public static void main(String[] args) {
        String s = "   a   b ";
        System.out.println(reverseWords(s));
    }
}
