package com.juho.algo.prac;

import com.juho.algo.prac.ds.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.
 * Return the smallest level X such that the sum of all the values of nodes at level X is maximal.
 *
 * Example 1:
 * Input: [1,7,0,7,-8,null,null], Output: 2
 * Explanation:
 * Level 1 sum = 1.
 * Level 2 sum = 7 + 0 = 7.
 * Level 3 sum = 7 + -8 = -1.
 * So we return the level with the maximum sum which is level 2.
 *
 * Note:
 *  - The number of nodes in the given tree is between 1 and 10^4.
 *  - -10^5 <= node.val <= 10^5
 *
 * @author Juho Lee
 * @since Dec 10, 2019
 */
public class problem_0209 {

    public int maxLevelSumDFS(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        maxLevelSumDFS(list, root, 0);
        int max = list.get(0), level = 1;
        for(int i = 1; i < list.size(); i++) {
            if(list.get(i) > max) {
                max = list.get(i);
                level = i;
            }
        }
        return level + 1;
    }

    private void maxLevelSumDFS(List<Integer> list, TreeNode root, int offset) {
        if(root == null)
            return;
        if(list.size() <= offset)
            list.add(root.val);
        else {
            int curr = list.get(offset);
            list.set(offset, curr + root.val);
        }
        maxLevelSumDFS(list, root.left, offset + 1);
        maxLevelSumDFS(list, root.right, offset + 1);
    }

    public int maxLevelSumWithBFS(TreeNode root) {
        int level = 1, maxLevel = 0, max = root.val;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int sum = 0;
            int size = queue.size();
            while(size-- > 0) {
                TreeNode node = queue.poll();
                sum += node.val;
                if(node.left != null)
                    queue.offer(node.left);
                if(node.right != null)
                    queue.offer(node.right);
            }
            if(max < sum) {
                max = sum;
                maxLevel = level;
            }
            level++;
        }
        return maxLevel;
    }

}