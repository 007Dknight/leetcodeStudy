package com.knight.chinese;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: create by knight007
 * @version: v1.0
 * @description: com.knight.chinese
 * @date: 2019/5/8 22:50
 */
public class DivisionSelfNum728 {
    public static List<Integer> getData(int left,int right){
        if(left < 1 || right > 10000){
            return null;
        }
        List<Integer> list = new LinkedList<>();
        for (int i = left; i <= right; i++) {
            if(judgeNum(i)){
                list.add(i);
            }
        }
        return list;
    }
    public static boolean judgeNum(int num){
        //需要记录三个值，一个本身，一个除以10之后的，一个除以10的结果
        int target = num;
        while (target > 1){
            int index = target % 10;
            target = target / 10;
            if( index == 0 || num % index != 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int i = 123;
        System.out.println(i/10);
        System.out.println(i%10);
        System.out.println(i/(10*10));
        System.out.println(judgeNum(21));
        System.out.println(getData(1,22).toString());
    }
}
