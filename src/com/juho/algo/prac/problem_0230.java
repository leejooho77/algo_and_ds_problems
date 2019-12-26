package com.juho.algo.prac;

/**
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes),
 * write a function to find the number of connected components in an undirected graph.
 *
 * Example:
 * Input: n = 5, edges = [[0, 1], [1, 2], [3, 4]], Output: 2.
 *
 * @author Juho Lee
 * @since Dec 26, 2019
 */
public class problem_0230 {

    public int countComponents(int n, int[][] edges) {
        int count = n;
        int[] roots = new int[n];
        for(int i = 0; i < roots.length; i++) {
            roots[i] = i;
        }
        for(int i = 0; i < edges.length; i++) {
            int v1 = getRoot(roots, edges[i][0]);
            int v2 = getRoot(roots, edges[i][1]);
            if(v1 != v2) {
                roots[v2] = v1;
                count--;
            }
        }
        return count;
    }

    public int getRoot(int[] roots, int vertex) {
        while(roots[vertex] != vertex) {
            roots[vertex] = roots[roots[vertex]];
            vertex = roots[vertex];
        }
        return vertex;
    }

}