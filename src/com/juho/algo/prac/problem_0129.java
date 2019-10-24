package com.juho.algo.prac;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a directed graph, reverse the directed graph so all directed edges are reversed.
 *
 * Example:
 * Input: A -> B, B -> C, A ->C, Output: B->A, C -> B, C -> A
 *
 * @author Juho Lee
 * @since Oct 24, 2019
 */
public class problem_0129 {

    public class Node {
        List<Node> adjacent;
        String value;

        public Node(String value) {
            this.value = value;
            this.adjacent = new ArrayList<>();
        }
    }

    public Node[] reverse(Node[] graph) {
        // have map to store reversed version of graph
        Map<Node, List<Node>> reversedGraph = new HashMap<>();
        // initialize empty arrays in the map
        for(Node node : graph) reversedGraph.put(node, new ArrayList<>());
        // reverse the map
        for(Node node : graph) {
            for(Node neighbor : node.adjacent) {
                reversedGraph.get(neighbor).add(node);
            }
        }
        // replace each adjacent with a reversed version
        for(Node node : graph) node.adjacent = reversedGraph.get(node);
        return graph;
    }

}
