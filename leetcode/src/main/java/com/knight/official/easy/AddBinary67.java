package com.knight.official.easy;
/**
 * Given two binary strings, return their sum (also a binary string).
 *
 * The input strings are both non-empty and contains only characters 1 or 0.
 *
 * Example 1:
 *
 * Input: a = "11", b = "1"
 * Output: "100"
 * Example 2:
 *
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 * @Author: knight
 * @Date: 2019-08-23 19:16
 */
public class AddBinary67 {
    public static String addBinary(String a, String b) {
        if(null == a || a.length() == 0)    return b;
        if(null == b || b.length() == 0)    return a;
        String reA = new StringBuilder(a).reverse().toString();
        String reB = new StringBuilder(b).reverse().toString();
        int length = a.length() > b.length() ? a.length() : b.length();
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            if(i >= reA.length()){
                String tempB = reB.substring(i,i+1);
                arr[i] = Integer.parseInt(tempB);

            }else if(i >= reB.length()){
                String tempA = reA.substring(i,i+1);
                arr[i] = Integer.parseInt(tempA);
            }else {
                String tempA = reA.substring(i,i+1);
                String tempB = reB.substring(i,i+1);
                arr[i] = Integer.parseInt(tempA) + Integer.parseInt(tempB);
            }
        }
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i] + index;
            if(temp > 1){
                sb.append(temp - 2);
                index = 1;
            }else {
                sb.append(temp);
                index = 0;
            }
        }
        if(index == 1){
            sb.append(1);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "1010";
        String b = "1011";
        System.out.println(addBinary(a,b));
    }

}
