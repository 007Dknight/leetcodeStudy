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
        if (dividend == 0 || divisor == 0 ) return 0;
        if (dividend == divisor) return 1;
        int i = 0;
        int temp = dividend;
        int target = divisor;
        if(dividend > divisor){
            if(divisor > 0){
                while (temp >= target){
                    temp -= target;
                    i++;
                }
                return i;
            }else if(dividend < 0){
                return 0;
            }else {
                //dividend >0 and divisor <0
                //then dividend need add divisor to 0
                while (temp >= 0){
                    temp += target;
                    i--;
                }
                return i+1;
            }
        }else {
            if(dividend > 0){
                return 0;
            }else if(divisor < 0){
                // dividend and divisor both < 0
                while (temp <= target){
                    temp -= target;
                    i++;
                }
                return i;
            }else {
                //divisor > 0 and dividend < 0
                while (temp <= 0){
                    temp += target;
                    i--;
                }
                return i+1;
            }
        }

    }

    public static void main(String[] args) {
        int i = -2147483648;
        int j = -1;
        System.out.println(divide(i, j));
//        System.out.println(~i);
    }
}
