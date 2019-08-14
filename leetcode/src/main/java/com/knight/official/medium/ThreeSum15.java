package com.knight.official.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * <p>
 * Note:
 * <p>
 * The solution set must not contain duplicate triplets.
 * <p>
 * Example:
 * <p>
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * <p>
 * A solution set is:
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 *
 * @author: create by knight007
 * @version: v1.0
 * @description: com.knight.official.medium
 * @date: 2019/5/19 1:20
 */
//TODO 这个还没有解决
public class ThreeSum15 {
    /**
     * 这个方法超时了
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums.length <= 0) return lists;
        //因为保证结果不重复，所以先对nums进行排序，然后只往前找
        Arrays.sort(nums);
        int i = 0;
        while (i < nums.length - 2 && nums[i] <= 0) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                int temp = nums[i] + nums[j];
                if (temp > 0) break;
                for (int k = j + 1; k < nums.length; k++) {
                    if (temp + nums[k] == 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        if (!lists.contains(list)) {

                            lists.add(list);
                        }
                        break;
                    }
                }
            }
            i++;
        }
        return lists;

    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums.length <= 0) return lists;
        //因为保证结果不重复，所以先对nums进行排序，然后只往前找
        Arrays.sort(nums);
        //可以使用二分查找，每次都是最小值（这个是变的）和最大值相加，如果小于等于0，从数组中间开始找，找到这个数就行；如果大于0，则最大值减1，
        int i = 0;
        while (i <= nums.length - 3 && nums[i] <= 0) {
            //两个数从两边开始找
            int mid = (nums.length - 1 - i) / 2;
            for (int j = i + 1, k = nums.length - 1; j <= nums.length - 2 && k > i + 1; ) {
                if (nums[i] + nums[j] > 0) {
                    return lists;
                } else {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        if (!lists.contains(temp)) {
                            lists.add(temp);
                        }
                        if (nums[j] == nums[j + 1] && nums[k] != nums[k - 1]) {
                            j++;
                        } else if (nums[k] == nums[k - 1] && nums[j] != nums[j + 1]) {
                            k--;
                        } else {
                            j++;
                            k--;
                        }
                        ;
                    } else if (nums[i] + nums[j] + nums[k] < 0) {
                        j++;
                    } else {
                        k--;
                    }
                }
            }
            i++;
        }
        return lists;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }
}
