package com.knight.chinese.byte_dance;

import java.util.ArrayList;
import java.util.List;

/**
 * 字符串相乘
 * <p>
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * <p>
 * 示例 1:
 * <p>
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * <p>
 * 示例 2:
 * <p>
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * <p>
 * 说明：
 * <p>
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 *
 * @author: create by knight007
 * @version: v1.0
 * @description: com.knight.leetcode_china.byte_dance
 * @date:2018/12/6
 */
public class MultiOfString {
    public static String multiply(String num1, String num2) {
        if(num1.length() <= 0 || num2.length() <= 0){
            return null;
        }
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();
        int length1 = num1.length();
        int length2 = num2.length();
        int[] nums1 = new int[length1];
        int[] nums2 = new int[length2];
        for (int i = 0; i < length1; i++) {
            nums1[i] = chars1[i] - '0';
        }
        for (int i = 0; i < length2; i++) {
            nums2[i] = chars2[i] - '0';
        }
//        System.out.println(Arrays.toString(nums1));
//        System.out.println(Arrays.toString(nums2));
        //根据乘法错位相加的规律得出乘积最小位数
        int[] temp = new int[length1 + length2 - 1];
        for (int i = 0; i < length1; i++) {
            for (int j = 0; j < length2; j++) {
                temp[i + j] += nums1[i] * nums2[j];
            }
        }
//        System.out.println(Arrays.toString(temp));
        //接下来处理各位如果大于9的情况，如果大于9，就本位等于原值%10，进一位等于 进一位加上 原值/10
        for (int i = temp.length - 1; i > 0; i--) {
            if (temp[i] > 9) {
                int target = temp[i];
                temp[i] = target % 10;
                temp[i - 1] = temp[i - 1] + target / 10;
            }
        }
        //然后处理最高位，如果最高位小于9，不做处理，否则最高位处再加一位
        StringBuffer sb = new StringBuffer();
        if(temp[0] > 9){
            sb.append(temp[0] / 10);
            sb.append(temp[0] % 10);
        }else {
            sb.append(temp[0]);
        }
        for (int i = 1; i < temp.length ; i++) {
            sb.append(temp[i]);
        }
//        System.out.println(Arrays.toString(temp));
        return sb.toString();

    }

    public static void main(String[] args) {
        String s1 = "123";
        String s2 = "456";
        System.out.println(multiply(s1, s2));

        List list = new ArrayList();
        list.add("1");
        list.add("2");
        list.add("2");
//        System.out.println(String.join("", list));
        int[] a = new int[2];
        System.out.println(a[1]);

    }
}
