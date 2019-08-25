package com.knight.official.easy;
/**
 * 53. Maximum Subarray
 * Easy
 *
 * 4880
 *
 * 183
 *
 * Favorite
 *
 * Share
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 *
 * Example:
 *
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * Follow up:
 *
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 * @Author: knight
 * @Date: 2019-08-23 18:13
 */
public class MaximumSubarray53 {
    public static int maxSubArray(int[] nums) {
        if(null == nums || nums.length == 0)    return 0;
        if(nums.length == 1)    return nums[0];
        int target =nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = target + nums[i];
            if(target < 0){
                target = nums[i];
                if(target > max){
                    max = target;
                }
            }else {
                target = temp;
                if(target > max){
                    max = target;
                }
            }
        }
        return max;

    }

    public static void main(String[] args) {
        int[] a = new int[]{-2,1};
        System.out.println(maxSubArray(a));

    }
}
