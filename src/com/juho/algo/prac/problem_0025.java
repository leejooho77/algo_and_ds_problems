package com.juho.algo.prac;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.juho.algo.prac.ds.ListNode;

/**
 * Given the head of a linked list, 
 * we repeatedly delete consecutive sequences of nodes that sum to 0 until there are no such sequences.
 * 
 * After doing so, return the head of the final linked list.  You may return any such answer.
 * (Note that in the examples below, all sequences are serializations of ListNode objects.)
 * 
 * Example 1:
 * Input: head = [1,2,-3,3,1], Output: [3,1]
 * Note: The answer [1,2,1] would also be accepted.
 * 
 * Example 2:
 * Input: head = [1,2,3,-3,4], Output: [1,2,4]
 * 
 * Example 3:
 * Input: head = [1,2,3,-3,-2], Output: [1]
 * 
 * @author leejooho77
 * @since Aug 11, 2019
 */
public class problem_0025 {
	
	public ListNode removeZeroSumSublistsUsingMap(ListNode head) {
        int sum = 0;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;
		Map<Integer, ListNode> map = new HashMap<>();
        while(curr != null) {
            sum += curr.val;
            if(map.containsKey(sum)) {
                ListNode delete = map.get(sum).next;
                int pre = sum + delete.val;
                while(pre != sum) {
                    if(map.containsKey(pre))
                        map.remove(pre);
                    delete = delete.next;
                    pre += delete.val;
                }
                map.get(sum).next = curr.next;
            } else {
                map.put(sum, curr);
            }
            curr = curr.next;
        }
        return dummy.next;
	}
	
	public ListNode removeZeroSumSublistsBruteForce(ListNode head) {
		List<Integer> list = convertToArray(head);
		int size = list.size();
		for(int i = 0; i < size; i++) {
            int sum = 0;
			for(int j = i; j < size; j++) {
				sum += list.get(j);
				if(sum == 0) {
					int start = i;
					while(start++ <= j) {
						list.remove(i);
					}
					i--;
					break;
				}
			}
			size = list.size();
		}
		return convertToLinkedList(list);
	}
	
	public List<Integer> convertToArray(ListNode head) {
		List<Integer> list = new ArrayList<>();
		while(head != null) {
			list.add(head.val);
			head = head.next;
		}
		return list;
	}
	
	public ListNode convertToLinkedList(List<Integer> list) {
		ListNode dummyHead = new ListNode(0);
		ListNode pointer = dummyHead;
		for(int i = 0; i < list.size(); i++) {
			pointer.next = new ListNode(list.get(i));
			pointer = pointer.next;
		}
		return dummyHead.next;
	}

}
