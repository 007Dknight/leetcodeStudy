package com.knight.official.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1], k = 3
 * Output: true
 *
 * Example 2:
 *
 * Input: nums = [1,0,1,1], k = 1
 * Output: true
 *
 * Example 3:
 *
 * Input: nums = [1,2,3,1,2,3], k = 2
 * Output: false
 *
 * solution:
 * just use map
 * key=nums[i],value=i
 *
 */
public class ContainsDuplicateII219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums.length <= 1 || k <= 0)  return false;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i <nums.length ; i++) {
            int num = nums[i];
            if(null != map && map.containsKey(num)){
                  if((i - map.get(num)) <= k){
                      return true;
                  }else {
                      map.put(num,i);
                  }
            }else {
                map.put(num,i);
            }
        }
        return false;

    }
}
