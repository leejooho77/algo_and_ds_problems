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
        // flag for leftmost node
        boolean traverseToLeft = true;
        // list for inorder traversal
        List<Integer> result = new ArrayList<>();
        while(root != null) {
            // if we have to traverse to left,
            // go to leftmost node
            if(traverseToLeft) {
                while(root.left != null)
                    root = root.left;
            }
            // add leftmost node
            // and set flag to false
            // since we are at the leftmost node
            result.add(root.val);
            traverseToLeft = false;
            // if current node has right child
            // go to right child and set flag to true
            // so we can traverse to leftmost child of it
            if(root.right != null) {
                root = root.right;
                traverseToLeft = true;
            }
            // else if the parent node is not null
            // we go to its parent
            else if(root.parent != null) {
                // if right child of its parent is root itself
                // we need to go all the way up until right child of parent is not root
                while(root.parent != null && root.parent.right == root)
                    root = root.parent;
                // if parent is null, we reached to root
                // exit the loop
                if(root.parent == null)
                    break;
                // else go to its parent
                root = root.parent;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNodeWithParentPointer root = new TreeNodeWithParentPointer(5);
        root.left = new TreeNodeWithParentPointer(3);
        (root.left).parent = root;
        root.left.right = new TreeNodeWithParentPointer(4);
        (root.left.right).parent = root.left;
        root.left.left = new TreeNodeWithParentPointer(2);
        (root.left.left).parent = root.left;
        root.left.left.left = new TreeNodeWithParentPointer(1);
        (root.left.left.left).parent = root.left.left;
        root.right = new TreeNodeWithParentPointer(8);
        (root.right).parent = root;
        root.right.left = new TreeNodeWithParentPointer(6);
        (root.right.left).parent = root.right;
        root.right.right = new TreeNodeWithParentPointer(10);
        (root.right.right).parent = root.right;
        root.right.right.left = new TreeNodeWithParentPointer(9);
        (root.right.right.left).parent = root.right.right;
        root.right.right.right = new TreeNodeWithParentPointer(12);
        (root.right.right.right).parent = root.right.right;
        System.out.println(new problem_0154().inorderTraversal(root));
    }

}
