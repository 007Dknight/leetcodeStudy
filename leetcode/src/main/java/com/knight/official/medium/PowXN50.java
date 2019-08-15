package com.knight.official.medium;

import java.math.BigDecimal;

/**
 * Implement pow(x, n), which calculates x raised to the power n (xn).
 * <p>
 * Example 1:
 * <p>
 * Input: 2.00000, 10
 * Output: 1024.00000
 * Example 2:
 * <p>
 * Input: 2.10000, 3
 * Output: 9.26100
 * Example 3:
 * <p>
 * Input: 2.00000, -2
 * Output: 0.25000
 * Explanation: 2-2 = 1/22 = 1/4 = 0.25
 *
 * @author: create by knight007
 * @version: v1.0
 * @description: com.knight.official.medium
 * @date: 2019/8/15 23:56
 */
public class PowXN50 {
    public static double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n > 0) {
            return getPow(x,n);
        }
        return 1.0/getPow(x,-(n));
    }

    /**
     * n > 0
     * @param x
     * @param n
     * @return
     */
    public static double getPow(double x,int n){
        if(n == 1)  return x;
        String[] s = String.valueOf(x).split("\\.");
        BigDecimal ten = BigDecimal.ONE;
        Integer index;
        if(s.length > 1){

            String noZero = s[1].replaceAll("(0)*$", "");
            int i  = noZero.length();
            ten = new BigDecimal(getTen(i*n));
            index = Integer.valueOf(s[0] + noZero);
        }else {
            index = Integer.valueOf(String.valueOf(x));
        }
        String binaryString = Integer.toBinaryString(index);
        char[] array = binaryString.toCharArray();
        int length = array.length;
        int value = 0;
        for (int i = 0; i < length; i++) {
            if(array[i] != '0'){
                value += array[i] << (length-i-1);
            }
        }
        return Double.valueOf(value)/ten.doubleValue();
    }
    public static String  getTen(int x){
        StringBuilder sb = new StringBuilder();
        sb.append(1);
        for (int i = 0; i < x; i++) {
            sb.append("0");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(myPow(2.10000,3));
//        System.out.println(2<<0);
//        String s = "102013000";
//        System.out.println(s.replaceAll("(0)*$", ""));
//        System.out.println(21 << 2);
//        System.out.println(Math.pow(21,3));
//        System.out.println(Integer.toBinaryString(2));


    }

}
