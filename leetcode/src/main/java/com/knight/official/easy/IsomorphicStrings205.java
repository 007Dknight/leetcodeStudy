package com.knight.official.easy;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t, determine if they are isomorphic.
 *
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 *
 * All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.
 *
 * Example 1:
 *
 * Input: s = "egg", t = "add"
 * Output: true
 *
 * Example 2:
 *
 * Input: s = "foo", t = "bar"
 * Output: false
 *
 * Example 3:
 *
 * Input: s = "paper", t = "title"
 * Output: true
 *
 * Note:
 * You may assume both s and t have the same length.
 * @author: create by knight007
 * @version: v1.0
 * @description: com.knight.official.easy
 * @date: 2020/5/19 23:32
 */
public class IsomorphicStrings205 {
    public static boolean isIsomorphic(String s, String t) {
        if(null == s && null == t)  return true;
        if(null != s && null == t)  return false;
        if(null == s && null != t)  return false;
        if(s.length() != t.length())    return false;

        Map<Character, String> mapS = getMap(s);

        Map<Character, String> mapT =getMap(t);
        //比较两个的values，string都一致的话，就说明他们同构
        Collection<String> valuesS =  mapS.values();
        Collection<String> valuesT =  mapT.values();
        //判断他们相互包含
        for (String s1 : valuesT) {
            if(!valuesS.contains(s1)){
                return false;
            }
        }
        for (String s1 : valuesS) {
            if(!valuesT.contains(s1)){
                return false;
            }
        }
        return true;

    }

    private static Map<Character, String> getMap(String s) {
        Map<Character, String> mapS = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (null != mapS && mapS.containsKey(c)) {
                String temp = mapS.get(c);
                mapS.put(c, temp + "-" + i);
            } else {
                mapS.put(c, String.valueOf(i));
            }
        }
        return mapS;
    }

    public static void main(String[] args) {
        String s = "foo";
        String t = "bar";
        System.out.println(isIsomorphic(s,t));
    }
}
