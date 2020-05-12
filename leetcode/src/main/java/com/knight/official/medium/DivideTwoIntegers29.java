package com.knight.official.medium;

/**
 * Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.
 * <p>
 * Return the quotient after dividing dividend by divisor.
 * <p>
 * The integer division should truncate toward zero.
 * <p>
 * Example 1:
 * <p>
 * Input: dividend = 10, divisor = 3
 * Output: 3
 * Example 2:
 * <p>
 * Input: dividend = 7, divisor = -3
 * Output: -2
 *
 * @author: create by knight007
 * @version: v1.0
 * @description: com.knight.official.medium
 * @date: 2019/8/17 1:34
 */
//todo
public class DivideTwoIntegers29 {
    public static int divide(int dividend, int divisor) {
        if(dividend == 0 || divisor == 0) return 0;
        if(divisor == 1) return dividend;
        if(divisor == -1) return (int) (0-new Long(dividend));
        if(dividend == divisor) return 1;
        boolean flag = false;
        if(dividend < 0 && divisor > 0){
            dividend = 0-dividend;
            flag = true;
        }else if(dividend > 0 &&divisor < 0){
            divisor = 0-divisor;
            flag = true;
        } else if(dividend < 0 && divisor < 0){
            dividend = 0-dividend;
            divisor = 0-divisor;
        }

        int index = 0;
        //这时候大家都是正数了
        while (dividend > divisor){
            dividend = dividend - divisor;
            index++;
        }
        if(flag){
            return 0-index;
        }
        return index;

    }

    public static void main(String[] args) {
        int i = -2147483648;
        int j = -1;
        System.out.println(divide(i, j));
//        System.out.println(~i);
        System.out.println(0 - new Long(i));
    }
}
