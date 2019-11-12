package com.juho.algo.prac;

import com.juho.algo.prac.ds.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree and a given node value, return all of the node's cousins.
 * Two nodes are considered cousins if they are on the same level of the tree with different parents.
 * You can assume that all nodes will have their own unique value.
 *
 * @author Juho Lee
 * @since Nov 11, 2019
 */
public class problem_0158 {

    public List<Integer> listCousins(TreeNode root, TreeNode node) {
        List<Integer> cousins = new ArrayList<>();
        if(root == null || root == node) return cousins;
        boolean isFound = false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0) {
                TreeNode curr = queue.poll();
                if(curr.left == node || curr.right == node) {
                    isFound = true;
                    continue;
                }
                if(curr.left != null)
                    queue.offer(curr.left);
                if(curr.right != null)
                    queue.offer(curr.right);
            }
            if(isFound)
                break;
        }
        queue.stream().forEach(cousin -> cousins.add(cousin.val));
        return cousins;
    }

}