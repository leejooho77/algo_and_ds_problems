package com.juho.algo.prac;

import com.juho.algo.prac.ds.TreeNodeWithParentPointer;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juho Lee
 * @since Nov 6, 2019
 */
public class problem_0154 {

    public List<Integer> inorderTraversal(TreeNodeWithParentPointer root) {
        List<Integer> result = new ArrayList<>();
        return null;
    }

    public static void main(String[] args) {
        TreeNodeWithParentPointer root = new TreeNodeWithParentPointer(5);
        root.left = new TreeNodeWithParentPointer(3);
        root.left.right = new TreeNodeWithParentPointer(4);
        root.left.left = new TreeNodeWithParentPointer(2);
        root.left.left.left = new TreeNodeWithParentPointer(1);
        root.right = new TreeNodeWithParentPointer(8);
        root.right.left = new TreeNodeWithParentPointer(6);
        root.right.right = new TreeNodeWithParentPointer(10);
        root.right.right.left = new TreeNodeWithParentPointer(9);
        root.right.right.right = new TreeNodeWithParentPointer(12);
        System.out.println(new problem_0154().inorderTraversal(root));
    }

}
