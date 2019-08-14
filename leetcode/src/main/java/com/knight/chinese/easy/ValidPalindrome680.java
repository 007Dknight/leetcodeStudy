package com.knight.chinese.easy;

/**
 * @author: create by knight007
 * @version: v1.0
 * @description: com.knight.chinese.easy
 * @date: 2019/7/2 0:07
 */
public class ValidPalindrome680 {
    public static boolean validPalindrome(String s) {
        if (s.length() <= 1) return true;
        StringBuffer sb = new StringBuffer(s);
        String temp = sb.reverse().toString();
        if (s.equals(temp)) {
            return true;
        }
        for (int i = 0; i < s.length()-1; i++) {
            String s1;
            String s2;

           if(s.length() % 2 == 0){
               if (i <= s.length() / 2) {
                   s1 = s.substring(0, i) + s.substring(i + 1, s.length() / 2 + 1);
                   s2 = s.substring(s.length() / 2, s.length());
               } else {
                   s1 = s.substring(0, s.length() / 2);
                   s2 = s.substring(s.length() / 2 -1, i) + s.substring(i + 1, s.length());
               }
           }else {
               if (i <= s.length() / 2) {
                   s1 = s.substring(0, i) + s.substring(i + 1, s.length() / 2 + 1);
                   s2 = s.substring(s.length() / 2 + 1, s.length());
               } else {
                   s1 = s.substring(0, s.length() / 2);
                   s2 = s.substring(s.length() / 2, i) + s.substring(i+1, s.length());
               }
           }


            StringBuffer temp1 = new StringBuffer(s2).reverse();
            if (s1.equals(temp1.toString())) {
                return true;
            }
        }
        String s1 = s.substring(0,s.length()-1);
        String s2 = new StringBuffer(s1).reverse().toString();
        if(s1.equals(s2)){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "cuelnbtbyyjddhfcbsfzdvdvpckqqovpdaastcxmbkkdaxznuljlunzxadkkbmxctsaadpvoqqkcpvdvdzfsbcfhddjyybhtbnleuc";
        System.out.println(validPalindrome(s));
        System.out.println(s.length());
    }
}
