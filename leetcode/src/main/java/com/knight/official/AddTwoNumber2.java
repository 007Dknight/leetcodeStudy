package com.knight.official;

import java.util.List;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Example:
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 *
 * @author: create by knight007
 * @version: v1.0
 * @description: com.knight.official
 * @date:2019/4/29 23:38，改于2019-05-11 晚上
 */
//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }



    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}

public class AddTwoNumber2 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if(l1 == null)  return l2;
        if(l2 == null)  return l1;
        ListNode p = l1;
        ListNode q = l2;
        //now，start add
        ListNode result = new ListNode(0);
        ListNode temp = result;
        int sum = 0;
        while (p != null || q != null || sum != 0){
            if(p == null && q == null){
                sum = sum;
            }else if(p == null){
                sum = q.val + sum;
            }else if(q == null){
               sum = p.val + sum;
            }else {
                sum = sum + p.val + q.val;
            }
            if(sum > 9){
                temp.next  = new ListNode(sum%10);
                sum = sum / 10;
            }else {
                temp.next = new ListNode(sum);
                sum = 0;
            }
            temp = temp.next;
            p = (p != null ? p.next : null);
            q = (q != null ? q.next : null);

        }
//        System.err.println(result);
        return result.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(5);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        System.out.println(addTwoNumbers(l1,l2));

    }
}
