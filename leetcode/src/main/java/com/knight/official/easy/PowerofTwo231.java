package com.knight.official.easy;

/**
 * Given an integer, write a function to determine if it is a power of two.
 *
 * Example 1:
 *
 * Input: 1
 * Output: true
 * Explanation: 20 = 1
 *
 * Example 2:
 *
 * Input: 16
 * Output: true
 * Explanation: 24 = 16
 *
 * Example 3:
 *
 * Input: 218
 * Output: false
 *
 * @Auther knight
 * @Created At 2020/5/11-22:52
 */
public class PowerofTwo231 {
    public static boolean isPowerOfTwo(int n) {
        if(n == 0)  return false;
        while(n != 1){
            int temp = n%2;
            if(temp !=0 ){
                return false;
            }
            n = n/2;
        }
        return true;
    }

    public static void main(String[] args) {
        int i = 218;
        System.out.println(isPowerOfTwo(i));
    }
}
