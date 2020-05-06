package com.knight.official.easy;

/**
 *
 * Implement int sqrt(int x).
 *
 * Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
 *
 * Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.
 *
 * Example 1:
 *
 * Input: 4
 * Output: 2
 * Example 2:
 *
 * Input: 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since
 *              the decimal part is truncated, 2 is returned.
 * @author: create by knight007
 * @version: v1.0
 * @description: com.knight.official.easy
 * @date: 2019/8/26 1:06
 */
public class Sqrtx69 {
    //todo

    public static int mySqrt(int x) {
        if(x <= 0)  return 0;
        if(x < 4)   return 1;
        if(x == 4)  return 2;
        for (int i = 2; i < x/2; i++) {
            if(i * i == x){
                return i;
            }
            if(i * i > x){
                return i-1;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(2147483647));
        System.out.println(2147395600);
        System.out.println(289398*289398);
        System.out.println(46340*46340);
    }
}
