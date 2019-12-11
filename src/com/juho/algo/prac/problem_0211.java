package com.juho.algo.prac;

import com.juho.algo.prac.ds.TreeNode;

/**
 * Given two non-empty binary trees s and t,
 * check whether tree t has exactly the same structure and node values with a subtree of s.
 * A subtree of s is a tree consists of a node in s and all of this node's descendants.
 * The tree s could also be considered as a subtree of itself.
 *
 * @author Juho Lee
 * @since Dec 11, 2019
 */
public class problem_0211 {

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null && t == null)
            return true;
        else if(s == null)
            return false;
        if(s.val == t.val) {
            TreeNode p = t;
            if(check(s, p))
                return true;
        }
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean check(TreeNode s, TreeNode t) {
        if(s == null && t == null)
            return true;
        else if(s == null || t == null)
            return false;
        else if(s.val != t.val)
            return false;
        else
            return check(s.left, t.left) && check(s.right, t.right);
    }

}