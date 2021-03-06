package com.juho.algo.prac;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given an undirected graph, return true if and only if it is bipartite.
 *
 * Recall that a graph is bipartite if we can split it's set of nodes into two independent subsets A and B
 * such that every edge in the graph has one node in A and another node in B.
 *
 * The graph is given in the following form: graph[i] is a list of indexes j for which the edge between nodes i and j exists.
 * Each node is an integer between 0 and graph.length - 1.
 * There are no self edges or parallel edges: graph[i] does not contain i, and it doesn't contain any element twice.
 *
 * Note:
 *  - graph will have length in range [1, 100].
 *  - graph[i] will contain integers in range [0, graph.length - 1].
 *  - graph[i] will not contain i or duplicate values.
 *  - The graph is undirected: if any element j is in graph[i], then i will be in graph[j].
 *
 * @author Juho Lee
 * @since Oct 24, 2019
 */
public class problem_0130 {

    public boolean isBipartiteDFS(int[][] graph) {
        // 0: non-visited, 1: white, -1: black
        int[] colors = new int[graph.length];
        for(int i = 0; i < colors.length; i++) {
            if(colors[i] == 0 && !checkDFS(graph, colors, 1, i))
                return false;
        }
        return true;
    }

    public boolean checkDFS(int[][] graph, int[] colors, int color, int vertex) {
        // if this node is visited, return if this node has different color with previous node
        if(colors[vertex] != 0)
            return colors[vertex] == color;
        // else store color in current node
        colors[vertex] = color;
        for(int i = 0; i < graph[vertex].length; i++) {
            // if neighbor is not visited, recursively check if it is valid
            if(colors[graph[vertex][i]] == 0) {
                if(!checkDFS(graph, colors, -color, graph[vertex][i]))
                    return false;
            }
            // else check if neighbor has different color
            else {
                if(colors[graph[vertex][i]] == colors[vertex])
                    return false;
            }
        }
        return true;
    }

    public boolean isBipartiteBFS(int[][] graph) {
        if(graph.length == 0) return true;
        // store int value to indicate if the vertex is visited or not
        int[] visited = new int[graph.length];
        for(int i = 0; i < visited.length; i++) {
            // if we visit the node first time, go check
            // if it is not bipartitie, return false
            if(visited[i] == 0 && !checkBFS(graph, visited, i))
                return false;
        }
        return true;
    }

    private boolean checkBFS(int[][] graph, int[] visited, int i) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i);
        // mark initial vertex to 1
        visited[i] = 1;
        while(!queue.isEmpty()) {
            // get neighbors of current vertex
            int curr = queue.peek();
            for(int j = 0; j < graph[curr].length; j++) {
                // if neighbor is not visited, store current vertex + 1
                // and insert into queue
                if(visited[graph[curr][j]] == 0) {
                    visited[graph[curr][j]] = visited[curr] + 1;
                    queue.offer(graph[curr][j]);
                } else {
                    // else check if neighbor has same value with current vertex
                    // if it does, return false;
                    if(visited[graph[curr][j]] == visited[curr])
                        return false;
                }
            }
            queue.poll();
        }
        return true;
    }

}
