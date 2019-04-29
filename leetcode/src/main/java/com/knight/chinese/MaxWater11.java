package com.knight.chinese;

/**
 * 11. 盛最多水的容器
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * 示例:
 *
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 *
 * @author: create by knight007
 * @version: v1.0
 * @description: com.knight.leetcode_china.impl
 * @date:2018/11/26
 */
public class MaxWater11 {
    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int result = 0;
        while (left < right){
            int tempArea = Math.min(height[left],height[right]) * (right - left);
            result = Math.max(tempArea,result);
            if ((height[left] > height[right])) {
                right--;
            } else {
                left++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(a));
        new StringBuffer();
        new StringBuilder();
    }

}
