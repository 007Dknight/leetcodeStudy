package com.knight.official.hard;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * <p>
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * <p>
 * You may assume nums1 and nums2 cannot be both empty.
 * <p>
 * Example 1:
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * The median is 2.0
 * <p>
 * Example 2:
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * The median is (2 + 3)/2 = 2.5
 *
 * @author: create by knight007
 * @version: v1.0
 * @description: com.knight.official.hard
 * @date: 2019/5/16 0:52
 */
public class MedianofTwoSortedArrays4 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int sum = nums1.length + nums2.length;
        int[] result = new int[sum];
        for (int i = 0, j = 0,t = 0; i < nums1.length || j < nums2.length; t++) {
            if((j == nums2.length) || (i < nums1.length && nums1[i] < nums2[j])){
                result[t] = nums1[i];
                i++;
            }else {
                result[t] = nums2[j];
                j++;
            }
        }
        if(sum % 2 == 0){
            return (result[sum/2] + result[sum/2 - 1])/2.0;
        }else {
            return result[sum/2];
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,2};
        int[] b = new int[]{3,4};
        System.out.println(findMedianSortedArrays(a,b));
    }
}
