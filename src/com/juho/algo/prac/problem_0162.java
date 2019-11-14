package com.juho.algo.prac;

import com.juho.algo.prac.ds.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' values.
 * (ie, from left to right, then right to left for the next level and alternate between).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its zigzag level order traversal as:
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *
 * @author Juho Lee
 * @since Nov 13, 2019
 */
public class problem_0162 {

    public List<List<Integer>> zigzagLevelOrderWithDFS(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        zigzagLevelOrderWithDFS(result, root, 0);
        return result;
    }

    private void zigzagLevelOrderWithDFS(List<List<Integer>> result, TreeNode root, int level) {
        if(root == null)
            return;
        if(result.size() == level)
            result.add(new ArrayList<>());
        if((level % 2) != 0)
            result.get(level).add(0, root.val);
        else
            result.get(level).add(root.val);
        zigzagLevelOrderWithDFS(result, root.left, level + 1);
        zigzagLevelOrderWithDFS(result, root.right, level + 1);
    }

    public List<List<Integer>> zigzagLevelOrderWithBFS(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            while(size-- > 0) {
                TreeNode node = queue.poll();
                if((result.size() % 2) != 0)
                    level.add(0, node.val);
                else
                    level.add(node.val);
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            result.add(level);
        }
        return result;
    }

}