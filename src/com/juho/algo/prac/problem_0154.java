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
        // flag for traversing left
        boolean traverseToLeft = false;
        List<Integer> result = new ArrayList<>();
        while(root != null) {
            if (!traverseToLeft) {
                // go all the way to left
                while (root.left != null) {
                    root = (TreeNodeWithParentPointer) root.left;
                }
            }
            // add current node to list
            result.add(root.val);
            // set true since we went all the way to left
            traverseToLeft = true;
            // if right node of current node is not null
            // go to right and set traverseToLeft as false
            // so we could traverse to left again
            if (root.right != null) {
                root = (TreeNodeWithParentPointer) root.right;
                traverseToLeft = false;
            // else if parent is not null
            // check if right node of parent is equal to current node
            // if it is, go all the way to ancestor
            // until right node of parent is not equal to current node
            // or parent become null
            } else if (root.parent != null) {
                while (root.parent != null && root == root.parent.right)
                    root = root.parent;
                // if parent is null, we reached to root.
                // end the loop
                if (root.parent == null)
                    break;
                // go one way up to avoid duplicate traversal
                root = root.parent;
            } else
                break;
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNodeWithParentPointer root = new TreeNodeWithParentPointer(5);
        root.left = new TreeNodeWithParentPointer(3);
        ((TreeNodeWithParentPointer) root.left).parent = root;
        root.left.right = new TreeNodeWithParentPointer(4);
        ((TreeNodeWithParentPointer) root.left.right).parent = (TreeNodeWithParentPointer) root.left;
        root.left.left = new TreeNodeWithParentPointer(2);
        ((TreeNodeWithParentPointer) root.left.left).parent = (TreeNodeWithParentPointer) root.left;
        root.left.left.left = new TreeNodeWithParentPointer(1);
        ((TreeNodeWithParentPointer) root.left.left.left).parent = (TreeNodeWithParentPointer) root.left.left;
        root.right = new TreeNodeWithParentPointer(8);
        ((TreeNodeWithParentPointer) root.right).parent = root;
        root.right.left = new TreeNodeWithParentPointer(6);
        ((TreeNodeWithParentPointer) root.right.left).parent = (TreeNodeWithParentPointer) root.right;
        root.right.right = new TreeNodeWithParentPointer(10);
        ((TreeNodeWithParentPointer) root.right.right).parent = (TreeNodeWithParentPointer) root.right;
        root.right.right.left = new TreeNodeWithParentPointer(9);
        ((TreeNodeWithParentPointer) root.right.right.left).parent = (TreeNodeWithParentPointer) root.right.right;
        root.right.right.right = new TreeNodeWithParentPointer(12);
        ((TreeNodeWithParentPointer) root.right.right.right).parent = (TreeNodeWithParentPointer) root.right.right;
        System.out.println(new problem_0154().inorderTraversal(root));
    }

}
