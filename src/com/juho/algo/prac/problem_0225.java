package com.juho.algo.prac;

import com.juho.algo.prac.ds.ListNode;

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 *
 * Example 1:
 * Input: 1->1->2, Output: 1->2
 *
 * Example 2:
 * Input: 1->1->2->3->3, Output: 1->2->3
 *
 * @author Juho Lee
 * @since Dec 24, 2019
 */
public class problem_0225 {

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;
        ListNode ptr = head, next = head.next;
        while(next != null) {
            if(next.val != ptr.val) {
                ptr.next = next;
                ptr = next;
            }
            next = next.next;
        }
        ptr.next = null;
        return head;
    }

}