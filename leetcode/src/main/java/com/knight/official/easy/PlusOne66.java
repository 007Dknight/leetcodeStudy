package com.knight.official.easy;
import com.alibaba.fastjson.JSON;

/**
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
 * <p>
 * The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.
 * <p>
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * Example 2:
 * <p>
 * Input: [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 *
 * @Author: knight
 * @Date: 2019-08-23 18:49
 */
public class PlusOne66 {
    public static int[] plusOne(int[] digits) {
        if (null == digits || digits.length == 0) return digits;
        int temp = digits[digits.length - 1];
        digits[digits.length - 1] = temp + 1;
        int[] target = new int[digits.length + 1];
        int index = 0;
        for (int i = digits.length - 1; i > 0; i--) {
            int t = digits[i] + index;
            if (t <= 9) {
                target[i + 1] = t;
                index = 0;
            } else {
                index = 1;
                target[i + 1] = t - 10;
            }
        }
        int i = digits[0] + index;
        if(i > 9){
            target[0] = 1;
            target[1] = i - 10;
            return target;
        }else {
            target[1] = i;
            int[] target2 = new int[target.length-1];
            for (int j = 1; j < target.length; j++) {
                target2[j-1] = target[j];
            }
            return target2;
        }

    }

    public static void main(String[] args) {
        int[] a = new int[]{
                8,8,5,0,5,1,9,7
        };
        System.out.println(JSON.toJSONString(plusOne(a)));
    }
}
