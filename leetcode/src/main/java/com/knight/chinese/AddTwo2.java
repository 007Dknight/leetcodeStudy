package com.knight.chinese;

/**
 * 第二题 两数相加
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * @author: create by knight007
 * @version: v1.0
 * @description: com.knight.leetcode_china.impl
 * @date:2018/11/26
 *
 *
 * *******************未解决
 */
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

public class AddTwo2 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode temp = result;
        ListNode c1 = l1;
        ListNode c2 = l2;
        while (c1 != null || c2 != null){
            int sum = 0;
            if(c1 != null){
             sum  += c1.val;
             c1 = c1.next;
            }
            if(c2 != null){
                sum  += c2.val;
                c2 = c2.next;
            }
            ListNode sumNode = new ListNode(sum);
            temp.next = sumNode;
            temp = temp.next;
        }
        ListNode notTen = result;
        while (notTen != null){
            if(notTen.val >= 10){
                int index = notTen.val;
                notTen.val = index %10;
                if(notTen.next != null){
                    notTen.next.val = notTen.next.val + index/10;
                }else {
                    ListNode added = new ListNode(index/10);
                    notTen.next = added;
                }
            }
            notTen = notTen.next;
        }


        return result.next;
    }

    public static void main(String[] args) {
        ListNode l13 = new ListNode(3);
        ListNode l12 = new ListNode(4);
        ListNode l11 = new ListNode(2);
        l12.next = l13;
        l11.next = l12;

        ListNode l23 = new ListNode(4);
        ListNode l22 = new ListNode(6);
        ListNode l21 = new ListNode(5);
        l22.next = l23;
        l21.next = l22;

        System.out.println(addTwoNumbers(l11,l21));

    }
}
