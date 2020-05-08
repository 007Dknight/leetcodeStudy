package com.knight.official.easy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as
 * one sorted array.
 * <p>
 * Note:
 * <p>
 * The number of elements initialized in nums1 and nums2 are m and n
 * respectively. You may assume that nums1 has enough space (size that is
 * greater or equal to m + n) to hold additional elements from nums2.
 * <p>
 * Example:
 * <p>
 * Input: nums1 = [1,2,3,0,0,0], m = 3 nums2 = [2,5,6], n = 3
 * <p>
 * Output: [1,2,2,3,5,6]
 *
 * @author: create by knight007
 * @version: v1.0
 * @description: com.knight.official.easy
 * @date: 2020/5/7 23:24
 */
public class MergeSortedArray88 {
    /**
     * this is fail,this question want the nums1 is expect,not stdout
     * 
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
        List<Integer> list = new LinkedList<>();
        int x = 0, y = 0;
        while (x < m || y < n) {
            if (y < n && (nums2[y] < nums1[x] || x >= m)) {
                list.add(nums2[y]);
                y++;
            } else {
                list.add(nums1[x]);
                x++;
            }
        }
        System.out.println(list.toString());

    }

    /**
     * this's not good
     * 
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        List<Integer> list = new LinkedList<>();
        int x = 0, y = 0;
        while (x < m || y < n) {
            if (y < n && (nums2[y] < nums1[x] || x >= m)) {
                list.add(nums2[y]);
                y++;
            } else {
                list.add(nums1[x]);
                x++;
            }
        }
        for (int i = 0; i < list.size(); i++) {
            nums1[i] = list.get(i);
        }

    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int length = nums1.length;
        for (int i = length-1; i >= 0 ; i--) {
            if(m == 0 || (m >0 && n >0 && nums2[n-1] > nums1[m-1])){
                nums1[i] = nums2[n-1];
                n--;
            }else{
                nums1[i] = nums1[m-1];
                m--;
            }
        }
        for (int i : nums1) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[] { 1, 2, 3, 0, 0, 0 };
        int[] nums2 = new int[] { 2, 5, 6 };
        merge(nums1, 3, nums2, 3);
    }
}
