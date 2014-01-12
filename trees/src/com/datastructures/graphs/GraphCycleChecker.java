package com.datastructures.graphs;

import java.io.File;
import java.util.Scanner;
import java.util.Stack;

//determining whether an undirected graph has a cycle.
//This implementation uses depth-first search. The constructor takes time proportional to O(V+E)(in the worst case),
//TODO: Find all the cycles
public class GraphCycleChecker {
	private boolean[] visited = null;
	private int[] edgeTo;
    private Stack<Integer> cycle;
    
	 public GraphCycleChecker(AdjListGraph graph) {
	        if (hasSelfLoop(graph)) return;
	        if (hasParallelEdges(graph)) return;
	        visited = new boolean[graph.getVertices()];
	        edgeTo = new int[graph.getVertices()];
	        for (int v = 0; v < graph.getVertices(); v++)
	            if (!visited[v])
	                dfs(graph, -1, v);
	    }
	 
	  	// does this graph have a self loop?
	    // side effect: initialize cycle to be self loop
	    private boolean hasSelfLoop(AdjListGraph graph) {
	        for (int v = 0; v < graph.getVertices(); v++) {
	            for (int w : graph.getAdjacentVertices(v)) {
	                if (v == w) {
	                    cycle = new Stack<Integer>();
	                    cycle.push(v);
	                    cycle.push(v);
	                    return true;
	                }
	            }
	        }
	        return false;
	    }

	 // does this graph have two parallel edges?
     // side effect: initialize cycle to be two parallel edges
	    private boolean hasParallelEdges(AdjListGraph graph) {
	        visited = new boolean[graph.getVertices()];

	        for (int v = 0; v < graph.getVertices(); v++) {

	            //check for parallel edges incident to v
	            for (int w : graph.getAdjacentVertices(v)) {
	                if (visited[w]) {
	                    cycle = new Stack<Integer>();
	                    cycle.push(v);
	                    cycle.push(w);
	                    cycle.push(v);
	                    return true;
	                }
	                visited[w] = true;
	            }

	            // reset so marked[v] = false for all v
	            for (int w : graph.getAdjacentVertices(v)) {
	            	visited[w] = false;
	            }
	        }
	        return false;
	    }
	    
	     //Does the graph have a cycle?
	    public boolean hasCycle() {
	        return cycle != null;
	    }	
	    
	    //Returns a cycle if the graph has a cycle, and null otherwise.
	    public Iterable<Integer> cycle() {
	        return cycle;
	    }
	    
	    // u previous vertex 
	    private void dfs(AdjListGraph graph, int u, int v) {
	        visited[v] = true;
	        for (int w : graph.getAdjacentVertices(v)) {

	            // short circuit if cycle already found
	            if (cycle != null) return;

	            if (!visited[w]) {
	                edgeTo[w] = v;
	                dfs(graph, v, w);
	            }

	            // check for cycle (but disregard reverse of edge leading to v)
	            //will end up loop, if there is any parallel edge, so make sure validate first
	            else if (w != u) {
	                cycle = new Stack<Integer>();
	                for (int x = v; x != w; x = edgeTo[x]) {
	                    cycle.push(x);
	                }
	                cycle.push(w);
	                cycle.push(v);
	            }
	        }
	    }

	    public static void main(String[] args)throws Exception {
	    	Scanner scanner = new Scanner(new File("bin/com/datastructures/graphs/test.txt"));
	    	AdjListGraph graph = new AdjListGraph(scanner);
	        GraphCycleChecker checker = new GraphCycleChecker(graph);
	        if (checker.hasCycle()) {
	            for (int v : checker.cycle()) {
	                System.out.print(v + " ");
	            }
	            System.out.println();
	        }
	        else {
	        	System.out.println("Graph is acyclic");
	        }
	    	    
	    }
}
