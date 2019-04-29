package com.knight.chinese;

/**
 * 最后一个单词的长度
 *
 *
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
 *
 * 如果不存在最后一个单词，请返回 0 。
 *
 * 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
 *
 * 示例:
 *
 * 输入: "Hello World"
 * 输出: 5
 * @author: create by knight007
 * @version: v1.0
 * @description: com.knight.chinese.easy
 * @date:2019/4/27
 */
public class LengthOfLastWord58 {
    public static int lengthOfLastWord(String s) {
        if(s.length() == 0) return 0;
        String[] temp = s.split(" ");
        if(temp.length == 0) return 0;
        String last = temp[temp.length-1];
        return last.length();
    }

    public static void main(String[] args) {
        String s = " ";
        System.out.println(lengthOfLastWord(s));
    }
}
