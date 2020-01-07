package com.juho.algo.prac;

import com.juho.algo.prac.ds.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a binary tree, return all duplicate subtrees.
 * For each kind of duplicate subtrees, you only need to return the root node of any one of them.
 * Two trees are duplicate if they have the same structure with same node values.
 *
 * Example 1:
 *
 *          1
 *         / \
 *       2   3
 *      /   / \
 *    4   2    4
 *       /
 *     4
 * The following are two duplicate subtrees:
 *
 *         2
 *       /
 *     4
 * and
 *
 *     4
 *
 * Therefore, you need to return above trees' root in the form of a list.
 *
 * @author Juho Lee
 * @since Jan 06, 20
 */
public class problem_0234 {

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        findDuplicateSubtrees(root, result, map);
        return result;
    }

    private void findDuplicateSubtrees(TreeNode root, List<TreeNode> result, Map<String, Integer> map) {
        if(root == null)
            return;
        StringBuilder serial = new StringBuilder();
        serialize(root, serial);
        String serializedTree = serial.toString();
        if(!map.containsKey(serializedTree)) {
            map.put(serializedTree, 1);
        } else {
            if(map.get(serializedTree) == 1)
                result.add(root);
            map.put(serializedTree, map.get(serializedTree) + 1);
        }
        findDuplicateSubtrees(root.left, result, map);
        findDuplicateSubtrees(root.right, result, map);
    }

    private void serialize(TreeNode root, StringBuilder serial) {
        if(root == null)
            serial.append("#");
        else {
            serial.append(root.val).append(",");
            serialize(root.left, serial);
            serialize(root.right, serial);
        }
    }

}
