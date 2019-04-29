package com.knight.chinese.byte_dance;

/**
 *   合并两个有序链表
 *
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * @author: create by knight007
 * @version: v1.0
 * @description: com.knight.leetcode_china.byte_dance
 * @date:2018/12/18
 */
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}

public class TogetherTwoLinked {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        int value1 = l1.val;
        int value2 = l2.val;
        ListNode listNode;
        if(value1 > value2){
            listNode = l2;
            listNode.next = mergeTwoLists(l1,l2.next);
        }else {
            listNode = l1;
            listNode.next = mergeTwoLists(l1.next,l2);
        }
        return listNode;
    }
}
