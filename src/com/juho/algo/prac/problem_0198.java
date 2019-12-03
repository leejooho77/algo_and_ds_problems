package com.juho.algo.prac;

import com.juho.algo.prac.ds.ListNode;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 *
 * Example:
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 *
 * @author Juho Lee
 * @since Dec 1, 2019
 */
public class problem_0198 {

    public ListNode swapPairs(ListNode head) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode ptr = newHead;
        while(ptr != null && ptr.next != null && ptr.next.next != null) {
            ListNode mid = ptr.next;
            ptr.next = ptr.next.next;
            ListNode next = ptr.next.next;
            ptr.next.next = mid;
            mid.next = next;
            ptr = mid;
        }
        return newHead.next;
    }

}
