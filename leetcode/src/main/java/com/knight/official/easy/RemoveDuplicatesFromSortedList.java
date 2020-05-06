package com.knight.official.easy;

/**
 * @author: create by knight007
 * @version: v1.0
 * @description: com.knight.official.easy
 * @date: 2020/5/6 22:42
 */



public class RemoveDuplicatesFromSortedList {
    class ListNode {
        int val;
        com.knight.official.easy.ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, com.knight.official.easy.ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public static com.knight.official.easy.ListNode deleteDuplicates(com.knight.official.easy.ListNode head) {
        if(null == head || null == head.next){
            return head;
        }
        com.knight.official.easy.ListNode slow = head;
        com.knight.official.easy.ListNode fast = head.next;
        if(fast != null){
            if(fast.val == slow.val){
                slow.next = fast.next;
            }else {
                slow = fast;
            }
            fast = fast.next;

        }
        return head;
    }

    public static void main(String[] args) {
        com.knight.official.easy.ListNode node1 = new com.knight.official.easy.ListNode(1);
        node1.next = new com.knight.official.easy.ListNode(1);
        node1.next.next = new com.knight.official.easy.ListNode(2);
        System.out.println(deleteDuplicates(node1));
    }



}
