package com.datastructures.graphs;

import java.io.File;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/*
 * Compute connected components using depth first search in an undirected graph.
 *  Runs in O(E + V) time.
 * 
 *  The id operation determines in which connected component a given vertex lies; 
 *  the 'areConnected' operation determines whether two vertices are in the same connected component;
 *  the 'count' operation determines the number of connected components;
 *  
 *  The 'component identifier' of a connected component is one of the
 *  vertices in the connected component: two vertices have the same component
 *  identifier if and only if they are in the same connected component.
 */

public class ConnectedComponents {
	private boolean[] visited;   
    private int[] id;           // id[v] id of connected component containing v vertex
    private int[] size;         // size[id] number of vertices in given component
    private int count;          // number of connected components

    // Computes the connected components of the undirected graph
    ConnectedComponents(AdjListGraph graph){
    	  visited = new boolean[graph.getVertices()];
          id = new int[graph.getVertices()];
          size = new int[graph.getVertices()];
          for (int v = 0; v < graph.getVertices(); v++) {
              if (!visited[v]) {
                  dfs(graph, v);
                  count++;
              }
          }
    }
    
    
	// depth-first search
	private void dfs(AdjListGraph graph, int vertex){
	    visited[vertex] = true;
	    id[vertex] = count;
	    size[count]++;
	    for (int w : graph.getAdjacentVertices(vertex)) {
	        if (!visited[w]) {
	            dfs(graph, w);
	        }
	    }
	}

	
	//Returns the component id of the connected component containing vertex
	public int getId(int v) {
		return id[v];
	}
	
	//Returns the number of vertices in the connected component containing vertex
	public int getSize(int v) {
		return size[v];
	}

	//Returns the number of connected components.
	public int getCount() {
		return count;
	}
	
	
	//Are vertices v and w in the same connected component?
    public boolean areConnected(int v, int w) {
        return (getId(v) == getId(w));
    }
    
    public static void main(String[] args)throws Exception {
    	Scanner scanner = new Scanner(new File("bin/com/datastructures/graphs/small.txt"));
        AdjListGraph graph = new AdjListGraph(scanner);
    	
        ConnectedComponents cc = new ConnectedComponents(graph);

        // number of connected components
        int M = cc.getCount();
        System.out.println("total connected componentes: "+M );

        // compute list of vertices in each connected component
        Queue<Integer>[] components = (Queue<Integer>[]) new LinkedList[M];
        for (int i = 0; i < M; i++) {
            components[i] = new LinkedList<Integer>();
        }
        for (int v = 0; v < graph.getVertices(); v++) {
            components[cc.getId(v)].add(v);
        }

        // print results
        for (int i = 0; i < M; i++) {
            for (int v : components[i]) {
                System.out.print(v + " ");
            }
            System.out.println("\n");
        }
    }  
}
