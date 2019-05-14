package com.knight.official.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * <p>
 * Example 1:
 * <p>
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * <p>
 * Example 2:
 * <p>
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * <p>
 * Example 3:
 * <p>
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 * @author: create by knight007
 * @version: v1.0
 * @description: com.knight.official.medium
 * @date: 2019/5/12 11:13
 */
public class LongestSubstringWithoutRepeatingCharacters3 {
    public static int lengthOfLongestSubstring(String s) {
        if (s == null) return 0;
        if (s.length() <= 1) return s.length();
        char[] chars = s.toCharArray();
        List<Character> list = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (list.contains(chars[i])) {
                int x = list.lastIndexOf(chars[i]);
                for (int j = 0; j <= x; j++) {
                    list.remove(0);
                }
            }
            list.add(chars[i]);
            count = (list.size() > count ? list.size() : count);

        }
        return count;
    }

    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
