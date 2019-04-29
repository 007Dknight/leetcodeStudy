package com.knight.chinese;

import java.util.Arrays;

/**
 * 23. 合并K个排序链表
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 示例:
 *
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 * @author: create by knight007
 * @version: v1.0
 * @description: com.knight.leetcode_china.impl
 * @date:2019/1/6
 *
 * 每次循环找出里面最小的节点
 */
//class ListNode {
//    int val;
//    ListNode next;
//    ListNode(int x) { val = x; }
//}
public class TogetherKListNode23 {
    public static ListNode mergeKLists(ListNode[] lists) {

        ListNode[] tempList = new ListNode[lists.length];
        int t = 0;
        for (int i = 0; i < lists.length; i++) {
            if(lists[i] != null){
                tempList[t] = lists[i];
                t++;
            }
        }
        ListNode[] listNodes = Arrays.copyOf(tempList, t);
        if(listNodes.length <= 0) return null;
        if(listNodes.length == 1) return listNodes[0];
        ListNode listNode;
        int target = listNodes[0].val;
        int index = 0;
        for (int i = 0; i < listNodes.length; i++) {
            if(listNodes[i].val < target){
                target = listNodes[i].val;
                index = i;
            }
        }
        listNode = listNodes[index];
        ListNode[] temp;
        if(listNodes[index].next != null){
            listNodes[index] = listNodes[index].next;
            temp = listNodes;
        }else {
            int length = listNodes.length;
            temp = new ListNode[length-1];
            for (int i = 0; i < index; i++) {
                temp[i] = listNodes[i];
            }
            for (int i = index; i < length - 1; i++) {
                temp[i] = listNodes[i+1];
            }
        }

        listNode.next = mergeKLists(temp);
        return listNode;
    }

    public static void main(String[] args) {
//        ListNode listNode1 = new ListNode(1);
//        listNode1.next = new ListNode(4);
//        listNode1.next.next= new ListNode(5);
//
//        ListNode listNode2 = new ListNode(1);
//        listNode2.next = new ListNode(3);
//        listNode2.next.next= new ListNode(4);
//
//        ListNode listNode3 = new ListNode(2);
//        listNode3.next = new ListNode(6);
//
//        ListNode[] listNodes = {listNode1,listNode2,listNode3};

        ListNode listNode4 = new ListNode(2);
        ListNode listNode5 = null;
        ListNode listNode6 = new ListNode(-1);
        ListNode[] listNodes = {listNode4,listNode5,listNode6};
        System.out.println(mergeKLists(listNodes));



    }

}
