package com.juho.algo.prac;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given a file path with folder names, '..' (Parent directory), and '.' (Current directory),
 * return the shortest possible file path (Eliminate all the '..' and '.').
 *
 * @author Juho Lee
 * @since Oct 23, 2019
 */
public class problem_0127 {

    public String shortestPath(String path) {
        String[] arrPath = path.substring(1).split("/");
        Deque<String> stack = new ArrayDeque<>();
        for(String s : arrPath) {
            if(s.equals("..") && !stack.isEmpty())
                stack.pop();
            else if(s.equals("."))
                continue;
            else
                stack.push(s);
        }
        StringBuilder result = new StringBuilder("/");
        while(!stack.isEmpty()) {
            result.insert(0, String.format("/%s", stack.pop()));
        }
        return result.toString();
    }

}