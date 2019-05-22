package com.knight.chinese.hard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 57. 插入区间
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 * <p>
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * <p>
 * 示例 1:
 * <p>
 * 输入: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出: [[1,5],[6,9]]
 * <p>
 * 示例 2:
 * <p>
 * 输入: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出: [[1,2],[3,10],[12,16]]
 * 解释: 这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 *
 * @author: create by knight007
 * @version: v1.0
 * @description: com.knight.chinese.hard
 * @date: 2019/5/22 23:17
 */
public class InsertInterval57 {
    /**
     * 思路：
     * 其实主要是对newInterval先进行插入，插入成功后进行合并
     *
     * @param intervals
     * @param newInterval
     * @return
     */
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length == 0){
            int[][] tempInt = new int[1][2];
            tempInt[0][0] = newInterval[0];
            tempInt[0][1] = newInterval[1];
            return tempInt;
        }
        if(newInterval.length == 0){
            return intervals;
        }
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<LinkedList<Integer>> temp = new LinkedList<>();
        LinkedList<LinkedList<Integer>> lists = new LinkedList<>();
//        int length = intervals.length;//代表有几个区间
//        int i0 = newInterval[0];//这是起始点
//        int i1 = newInterval[1];//这是终点
        for (int i = 0; i < intervals.length; i++) {
            LinkedList<Integer> list = new LinkedList<>();
            list.add(intervals[i][0]);
            list.add(intervals[i][1]);
            temp.add(list);
        }
        //所以先插入成功就行
        int index = getIndex(temp, newInterval);
        LinkedList<Integer> target = new LinkedList<>();
        target.add(newInterval[0]);
        target.add(newInterval[1]);
        if(index < temp.size()){
            for (int i = 0; i < temp.size(); i++) {
                if(index == i){
                    lists.add(target);
                }
                lists.add(temp.get(i));
            }
        }else {
            lists.addAll(temp);//这样就可以了
            lists.add(target);
        }


        System.out.println(lists.toString());
        //然后开始合并区间
        int min = lists.get(0).get(0);
        for (int i = 0; i < lists.size(); ) {
            if(i == lists.size() - 1){
                List<Integer> list = new ArrayList<>();
                list.add(min);
                list.add(lists.get(i).get(1));
                result.add(list);
                break;
            }
            if(lists.get(i).get(1) < lists.get(i+1).get(0)){
                List<Integer> list = new ArrayList<>();
                list.add(min);
                list.add(lists.get(i).get(1));
                result.add(list);
                min = lists.get(i+1).get(0);
                i++;
            }else {
                if(lists.get(i).get(1) < lists.get(i+1).get(1)){
                    i++;
                }else {
                    lists.set(i+1,lists.get(i));
                    i++;
                }
            }
        }
        System.out.println("result:" + result.toString());
        int[][] arr = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            arr[i][0] = result.get(i).get(0);
            arr[i][1] = result.get(i).get(1);
        }
        System.out.println();
        for (int[] ints : arr) {
            System.out.println(ints[0] + "-" + ints[1]);
        }
        return arr;
    }
    public static int getIndex(LinkedList<LinkedList<Integer>> lists, int[] newInterval){
        int min = newInterval[0];
        for (int i = 0; i < lists.size(); i++) {
            if(min <= lists.get(i).get(0)){
                return i;
            }
        }
        return lists.size();
    }
    public static void main(String[] args) {
        //[[1,2],[3,5],[6,7],[8,10],[12,16]]
        //[4,8]
        int[][] i = new int[][]{{1, 2}, { 3,5},{6,7},{8,10},{12,16}};
        int[] a = new int[]{4,8};
        System.out.println(insert(i,a).length);


    }
}
