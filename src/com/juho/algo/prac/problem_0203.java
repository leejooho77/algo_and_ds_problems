package com.juho.algo.prac;

import com.juho.algo.prac.ds.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, find and return the largest path from root to leaf.
 *
 * @author Juho Lee
 * @since Dec 4, 2019
 */
public class problem_0203 {

    public class PathEntry {

        int sum;
        List<Integer> path;
        public PathEntry() {
            this.sum = 0;
            this.path = new ArrayList<>();
        }

        public int add(int val) {
            this.sum += val;
            return this.sum;
        }

        public void addToPath(int path) {
            this.path.add(0, path);
        }

        public void copyPath(PathEntry anotherPath) {
            this.sum = anotherPath.sum;
            this.path = new ArrayList<>(anotherPath.path);
        }

    }

    public List<Integer> largestPathSum(TreeNode root) {
        PathEntry entry = calculate(root);
        return entry.path;
    }

    private PathEntry calculate(TreeNode root) {
        if(root == null)
            return null;
        PathEntry entry = new PathEntry();
        PathEntry left = calculate(root.left);
        PathEntry right = calculate(root.right);
        if(left == null && right != null) {
            entry.copyPath(right);
        } else if(right == null && left != null) {
            entry.copyPath(left);
        } else if(left != null && right != null) {
            if (left.sum > right.sum)
                entry.copyPath(left);
            else
                entry.copyPath(right);
        }
        entry.add(root.val);
        entry.addToPath(root.val);
        return entry;
    }

}