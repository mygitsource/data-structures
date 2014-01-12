package com.datastructures.graphs;

import java.io.File;
import java.util.Scanner;
import java.util.Stack;

public class GraphSampleTest {
	private boolean[] visited = null;
	private int[] edgeTo;
    private Stack<Integer> cycle;
    
    GraphSampleTest(AdjListGraph graph){
    	visited = new boolean[graph.getVertices()];
    	edgeTo = new int[graph.getVertices()];
    }

    private boolean hasParallelEdges(AdjListGraph graph) {
        visited = new boolean[graph.getVertices()];

        for (int v = 0; v < graph.getVertices(); v++) {
        	System.out.println(graph.getAdjacentVertices(v));
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

    private void dfs(AdjListGraph graph, int u, int v) {
        visited[v] = true;
        for (int w : graph.getAdjacentVertices(v)) {
System.out.println(v+" "+w);
            // short circuit if cycle already found
            if (cycle != null) return;

            if (!visited[w]) {
                edgeTo[w] = v;
                dfs(graph, v, w);
            }

            // check for cycle (but disregard reverse of edge leading to v)
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
    
    public Stack<Integer> getCycle() {
        return cycle;
    }
    
	public static void main(String[] args)throws Exception {
	   
       Scanner scanner = new Scanner(new File("bin/com/datastructures/graphs/test.txt"));
	   AdjListGraph graph = new AdjListGraph(scanner);
	   GraphSampleTest test = new GraphSampleTest(graph);
	   //boolean has = test.hasParallelEdges(graph);
//       for (int v = 0; v < graph.getVertices(); v++)
	   test.dfs(graph, -1, 4);
	   System.out.println(test.cycle);
	}
	
}
