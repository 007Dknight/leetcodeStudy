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
 * @date:2019/4/29 23:38
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
        if(l1 == null && l2 == null)    return null;
        if(l1 == null)  return l2;
        if(l2 == null)  return l1;
        //now，start add
        ListNode result = new ListNode(l1.val + l2.val);
        ListNode l1Next = l1.next;
        ListNode l2Next = l2.next;
        ListNode resultNext = null;
        while (l1Next != null || l2Next != null){
            if(l1Next == null){
                resultNext = new ListNode(l2Next.val);
                l2Next = l2Next.next;
            }else if(l2Next == null){
                resultNext = new ListNode(l1Next.val);
                l1Next = l1Next.next;
            }else {
                resultNext = new ListNode(l1Next.val + l2Next.val);
                l1Next = l1Next.next;
                l2Next = l2Next.next;
            }
            resultNext = resultNext.next;
        }
        result.next =resultNext;
        return result;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        System.out.println(addTwoNumbers(l1,l2));

    }
}
