package com.juho.algo.prac;

import com.juho.algo.prac.ds.ListNode;

/**
 * Remove all elements from a linked list of integers that have value val.
 *
 * Example:
 * Input:  1->2->6->3->4->5->6, val = 6, Output: 1->2->3->4->5
 *
 * @author Juho Lee
 * @since Oct 31, 2019
 */
public class problem_0143 {

    public ListNode removeElements(ListNode head, int val) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        head = newHead;
        while(newHead.next != null) {
            if(newHead.next.val == val)
                newHead.next = newHead.next.next;
            else
                newHead = newHead.next;
        }
        return head.next;
    }

}
