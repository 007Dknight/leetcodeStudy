package com.knight.chinese;

/**
 * 给出一个链表，每 k 个节点一组进行翻转，并返回翻转后的链表。
 * <p>
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么将最后剩余节点保持原有顺序。
 * <p>
 * 示例 :
 * <p>
 * 给定这个链表：1->2->3->4->5
 * <p>
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * <p>
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 * <p>
 * 说明 :
 * <p>
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * @author: create by knight007
 * @version: v1.0
 * @description: com.knight.leetcode_china.impl
 * @date:2019/1/6
 */
public class ReverseKListNode25 {

    public static ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        //计算链表长度
        int size = 1;
        ListNode sup = head;
        while (sup.next != null){
            size++;
            sup = sup.next;
        }
        System.out.println(size);
        if(k >= size) return head;
        //计算需要翻转多少次
        int num = size/k;
        ListNode result = new ListNode(0);
        result.next = head;
        ListNode index = head.next;
        while (num >= 1){
            for (int i = 1; i < k; i++) {
                ListNode next = index.next;
                result.next = index;
                index = next;
            }
            num--;
        }


        return result.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        System.out.println(reverseKGroup(listNode, 2));
    }
}
