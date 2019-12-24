package com.juho.algo.prac;

import com.juho.algo.prac.ds.ListNode;

import java.util.*;

/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 *
 * Example 1:
 * Input: 1->2->3->3->4->4->5, Output: 1->2->5
 *
 * Example 2:
 * Input: 1->1->1->2->3, Output: 2->3
 *
 * @author Juho Lee
 * @since Dec 24, 2019
 */
public class problem_0226 {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode newHead = new ListNode(0);
        ListNode ptr = newHead;
        while(head != null) {
            ListNode next = head.next;
            if(next != null && head.val == next.val) {
                int dup = head.val;
                while(head != null && head.val == dup)
                    head = head.next;
            } else {
                ptr.next = head;
                head = head.next;
                ptr = ptr.next;
            }
        }
        ptr.next = null;
        return newHead.next;
    }

}