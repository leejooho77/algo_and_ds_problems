package com.juho.algo.prac;

import com.juho.algo.prac.ds.ListNode;

/**
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * ou should preserve the original relative order of the nodes in each of the two partitions.
 *
 * Example:
 * Input: head = 1->4->3->2->5->2, x = 3, Output: 1->2->2->4->3->5
 *
 * @author Juho Lee
 * @since Dec 1, 2019
 */
public class problem_0199 {

    public ListNode partition(ListNode head, int x) {
        ListNode beforeHead = new ListNode(0);
        ListNode afterHead = new ListNode(0);
        ListNode before = beforeHead;
        ListNode after = afterHead;
        while(head != null) {
            if(head.val < x) {
                before.next = new ListNode(head.val);
                before = before.next;
            } else {
                after.next = new ListNode(head.val);
                after = after.next;
            }
            head = head.next;
        }
        before.next = afterHead.next;
        return beforeHead.next;
    }

}
