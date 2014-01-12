package com.datastructures.graphs;

import java.io.File;
import java.util.Scanner;

public class GraphTest {
	
	public static int degree(AdjListGraph graph, int v) { 
        int degree = 0;
        for (int w : graph.getAdjacentVertices(v)) 
        	degree++;
        return degree;
    }

    // maximum degree 
    public static int maxDegree(AdjListGraph graph) {
        int max = 0;
        for (int v = 0; v < graph.getVertices(); v++)
            if (degree(graph, v) > max)
                max = degree(graph, v);
        return max;
    }

    // average degree
    public static int avgDegree(AdjListGraph graph) {
        // each edge incident on two vertices
        return 2 * graph.getEdges() / graph.getVertices();
    }

    // number of self-loops
    public static int numberOfSelfLoops(AdjListGraph graph) {
        int count = 0;
        for (int v = 0; v < graph.getVertices(); v++){
            for (int w : graph.getAdjacentVertices(v)){
            	if (v == w) count++;
            }        	
        }
        return count/2;   // self loop appears in adjacency list twice
    }
    
    public static void main(String[] args)throws Exception {
       Scanner scanner = new Scanner(new File("bin/com/datastructures/graphs/small.txt"));
	   AdjListGraph G = new AdjListGraph(scanner);
	   
       System.out.println("vertex of maximum degree = " + maxDegree(G));
       System.out.println("average degree           = " + avgDegree(G));
       System.out.println("number of self loops     = " + numberOfSelfLoops(G));
       
	}

}
