package com.knight.chinese;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 3. 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * <p>
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * @author: create by knight007
 * @version: v1.0
 * @description: com.knight.leetcode_china.impl
 * @date:2018/11/26
 */
public class LengthOfLongestSubstring3 {
    //i 是当前字符位置，i - temp是当前字符串起始位置。出现重复字符时，先判断字符上一次出现位置是否在当前字符串内，如果不在，则Map中更新位置并且temp++；如果在，则temp截断，从 上一次出现+1 的位置开始计算。
    public static int lengthOfLongestSubstring(String s) {

        Map<Character, Integer> pos = new HashMap<>();
        char[] ss = s.toCharArray();
        int max = 0, temp = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!pos.containsKey(ss[i])) {
                pos.put(ss[i], i);
                temp++;
            } else {
                if (pos.get(ss[i]) + temp < i) {
                    temp++;
                } else {
                    max = Math.max(max, temp);
                    temp = i - pos.get(ss[i]);
                }
                pos.put(ss[i], i);
            }
        }
        max = Math.max(max, temp);
        return max;

    }
    public static int myLengthLongSubString(String s){
        List list = new ArrayList<>();
        char[] chars = s.toCharArray();
        int max = 0;
        int temp = 0;
        for (int i = 0; i < chars.length; i++) {
            if(!list.contains(chars[i])){
                list.add(chars[i]);
                temp = list.size();
                if(temp > max){
                    max = temp;
                }
            }else {
                temp = list.size();
                if(temp > max){
                    max = temp;
                }
                int j = list.indexOf(chars[i]);
                for (int k = 0; k <= j; k++) {
                    list.remove(0);
                }
                list.add(chars[i]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "pwwkew";//"pwwkew" "dvdf" "nfpdmpi"


        System.out.println(myLengthLongSubString(s));
    }
}
