package com.juho.algo.prac;

import java.util.PriorityQueue;

import com.juho.algo.prac.ds.ListNode;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and
 * describe its complexity.
 * 
 * Example: Input: [ 1->4->5, 1->3->4, 2->6 ] Output: 1->1->2->3->4->4->5->6
 * 
 * @author leejooho77
 * @since Aug 23, 2019
 */
public class problem_0037 {

	public ListNode mergeKListsIterative(ListNode[] lists) {
		if(lists.length == 0) return null;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> {
			return Integer.compare(a.val, b.val);
		});
		for(ListNode node : lists) {
            if(node != null)
			    minHeap.add(node);
		}
		ListNode dummyHead = new ListNode(0);
		ListNode curr = dummyHead;
		while(!minHeap.isEmpty()) {
			curr.next = minHeap.peek();
			if(minHeap.peek().next != null)
				minHeap.add(minHeap.remove().next);
			else 
				minHeap.remove();
            curr = curr.next;
		}
		return dummyHead.next;
	}
	
	public ListNode mergeKListsRecursive(ListNode[] lists) {
		return mergeKListsRecursive(lists, 0, lists.length - 1);
	}
	
	public ListNode mergeKListsRecursive(ListNode[] lists, int start, int end) {
		if(start > end) return null;
		else if(start == end) return lists[start];
		int mid = start + (end - start)/2;
		ListNode l1 = mergeKListsRecursive(lists, start, mid);
		ListNode l2 = mergeKListsRecursive(lists, mid + 1, end);
		return merge(l1, l2);
	}
	
	public ListNode merge(ListNode l1, ListNode l2) {
		if(l1 == null) return l2;
		if(l2 == null) return l1;
		if(l1.val < l2.val) {
			l1.next = merge(l1.next, l2);
			return l1;
		}
		else {
			l2.next = merge(l1, l2.next);
			return l2;
		}
	}

}
