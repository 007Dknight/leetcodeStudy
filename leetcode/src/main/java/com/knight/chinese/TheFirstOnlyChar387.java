package com.knight.chinese;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 * 案例:
 *
 * s = "leetcode"
 * 返回 0.
 *
 * s = "loveleetcode",
 * 返回 2.
 * @author: create by knight007
 * @version: v1.0
 * @description: com.knight.chinese
 * @date: 2019/5/15 1:00
 */
public class TheFirstOnlyChar387 {
    /**
     * 用LinkHashMap存储字符和出现的位置
     * 因为LinkHashMap的顺序与插入顺序保持了一致，所以肯定能获取到第一个
     * @param s
     * @return
     */
    public static int firstUniqChar(String s) {
        if(s == null || s.length() == 0)    return -1;
        Map<Character,Integer> map = new LinkedHashMap<>();
        char[] array = s.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if(map.containsKey(array[i])){
                map.put(array[i],-1);
            }else {
                map.put(array[i],i);
            }
        }
        if(map == null || map.size() == 0){
            return -1;
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if(entry.getValue() != -1){
                return entry.getValue();
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String s = "aadadaad";
        System.out.println(firstUniqChar(s));
    }
}
