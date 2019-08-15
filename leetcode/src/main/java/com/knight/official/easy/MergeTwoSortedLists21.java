package com.knight.official.easy;

/**
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 *
 * @author: create by knight007
 * @version: v1.0
 * @description: com.knight.official.easy
 * @date: 2019/8/16 0:45
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

public class MergeTwoSortedLists21 {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode t1 = l1;
        ListNode t2 = l2;
        ListNode result = new ListNode(0);
        ListNode temp = new ListNode(0);
        result = temp;
        while (t1 != null || t2 != null) {
            temp.next = new ListNode(0);
            if (t1 == null || (t2 != null && t1.val > t2.val)) {
                temp.next.val = t2.val;
                t2 = t2.next;
            } else {
                temp.next.val = t1.val;
                t1 = t1.next;
            }
            temp = temp.next;
        }
        return result.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);


        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        System.out.println(mergeTwoLists(l1, l2));
    }
}
