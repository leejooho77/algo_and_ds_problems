package com.juho.algo.prac;

import java.util.List;

import com.juho.algo.prac.ds.NTree;

/**
 * A k-ary tree is a tree with k-children, and a tree is symmetrical 
 * if the data of the left side of the tree is the same as the right side of the tree.
 * 
 * Here's an example of a symmetrical k-ary tree.
 * 
 *          4
 *      /       \
 *     3         3
 *   / | \     / | \
 *  9  4  1   1  4  9
 * 
 * Given a k-ary tree, figure out if the tree is symmetrical.
 * 
 * @author Juho Lee
 * @since Sep 30, 2019
 */
public class problem_0088 {

	public boolean isSymmetric(NTree root) {
		List<NTree> children = root.children;
		if(root == null || children.isEmpty()) return true;
		int start = 0, end = children.size() - 1;
		while(start < end) {
			NTree left = children.get(start);
			NTree right = children.get(end);
			if(!isSymmetric(left, right))
				return false;
			start++;
			end--;
		}
		return true;
	}
	
	private boolean isSymmetric(NTree left, NTree right) {
		// Both nodes have same value
		if(left.value == right.value) {
			// Both nodes are leaf nodes
			if(left.children.isEmpty() && right.children.isEmpty())
				return true;
			// if both children have same size
			else if(left.children.size() == right.children.size()) {
				// left starts with 0 and right starts with at the end
				int leftNode = 0, rightNode = right.children.size() - 1;
				// until we reached to the end of both children, recursively check if tree is symmetric
				while(leftNode < left.children.size() && rightNode >= 0) {
					// if not, return false
					if(!isSymmetric(left.children.get(leftNode), right.children.get(rightNode)))
						return false;
					leftNode++;
					rightNode--;
				}
				return true;
			}
			return false;
		} else
			return false;
	}
	
}
