package com.juho.algo.prac;

import com.juho.algo.prac.ds.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Given the root of a tree, you are asked to find the most frequent subtree sum.
 * The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node
 * (including the node itself).
 * So what is the most frequent subtree sum value?
 * If there is a tie, return all the values with the highest frequency in any order.
 *
 * Examples 1
 * Input:
 *
 *   5
 *  /  \
 * 2   -3
 * return [2, -3, 4], since all the values happen only once, return all of them in any order.
 *
 * Examples 2
 * Input:
 *
 *   5
 *  /  \
 * 2   -5
 * return [2], since 2 happens twice, however -5 only occur once.
 * Note: You may assume the sum of values in any subtree is in the range of 32-bit signed integer.
 *
 * @author Juho Lee
 * @since Nov 3, 2019
 */
public class problem_0149 {

    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        findFrequentTreeSum(map, root);
        int[] result = new int[map.size()];
        int i = 0, count = 1;
        Iterator<Map.Entry<Integer, Integer>> iter = map.entrySet().iterator();
        while(iter.hasNext()) {
            Map.Entry<Integer, Integer> entry = iter.next();
            if(entry.getValue() > count) {
                count = entry.getValue();
                i = 0;
            }
            if(entry.getValue() == count)
                result[i++] = entry.getKey();
        }
        return Arrays.copyOfRange(result, 0, i);
    }

    private int findFrequentTreeSum(Map<Integer, Integer> map, TreeNode root) {
        if(root == null)
            return 0;
        int left = findFrequentTreeSum(map, root.left);
        int right = findFrequentTreeSum(map, root.right);
        int sum = root.val + left + right;
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        return sum;
    }

}