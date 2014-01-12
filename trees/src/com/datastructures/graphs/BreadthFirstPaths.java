package com.datastructures.graphs;

import java.io.File;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

//Run breadth first search on an undirected graph.
//Runs in O(E + V) time.
//space O(V)
//finding shortest paths (number of edges) from a source vertex
//
public class BreadthFirstPaths {
	private static final int MAX = Integer.MAX_VALUE;
	//visited[v] Is there an path from source to vertex v;	
	private boolean[] visited;
	//edgeTo[v] previous edge on shortest source to vertex v path
	private int[] edgeTo;
	//number of edges shortest from source to vertex v
	private int[] distTo;
	
	BreadthFirstPaths(AdjListGraph graph, int source) {
		visited = new boolean[graph.getVertices()];
		edgeTo = new int[graph.getVertices()];
		distTo = new int[graph.getVertices()];
		bfs(graph, source);
	}
	
	//finds the shortest path 
	void bfs(AdjListGraph graph, int source){
		Queue<Integer> queue = new LinkedList<Integer>();
		distTo[source] = 0;
		visited[source] = true;
		queue.add(source);
		
		while(!queue.isEmpty()){
			int vertex = queue.poll();
			for(int x: graph.getAdjacentVertices(vertex)){
				if(!visited[x]){
					edgeTo[x] = vertex;
					distTo[x] = distTo[vertex] +1;
					visited[x] = true;
					queue.add(x);
				}
			}
		}
	}
	
	void bfs(AdjListGraph graph, Iterable<Integer> sources){
		for (Integer integer : sources) {
			bfs(graph, integer);
		}
	}
	
	// Is there a path between the source vertex (or sources) and vertex
	boolean hasPathTo(int source){
		return visited[source];
	}
	
	//Returns the number of edges in a shortest path between the source vertex (or sources) and vertex
	int distTo(int vertex){
		return distTo[vertex];
	}
	
	//Returns a shortest path between the source vertex 
	Stack<Integer> pathTo(int source){
		if(!hasPathTo(source)) return null;
		Stack<Integer> path = new Stack<>();
		int x;
		for(x = source; distTo[x] != 0; x = edgeTo[x]){
			path.push(x);
		}
		path.push(x);
		return path;
	}
	
	private boolean check(AdjListGraph graph, int s) {

        // check that the distance of s = 0
        if (distTo[s] != 0) {
            System.out.println("distance of source " + s + " to itself = " + distTo[s]);
            return false;
        }

        // check that for each edge v-w dist[w] <= dist[v] + 1
        // provided v is reachable from s
        for (int v = 0; v < graph.getVertices(); v++) {
            for (int w : graph.getAdjacentVertices(v)) {
                if (hasPathTo(v) != hasPathTo(w)) {
                    System.out.println("edge " + v + "-" + w);
                    System.out.println("hasPathTo(" + v + ") = " + hasPathTo(v));
                    System.out.println("hasPathTo(" + w + ") = " + hasPathTo(w));
                    return false;
                }
                if (hasPathTo(v) && (distTo[w] > distTo[v] + 1)) {
                    System.out.println("edge " + v + "-" + w);
                    System.out.println("distTo[" + v + "] = " + distTo[v]);
                    System.out.println("distTo[" + w + "] = " + distTo[w]);
                    return false;
                }
            }
        }

        // check that v = edgeTo[w] satisfies distTo[w] + distTo[v] + 1
        // provided v is reachable from s
        for (int w = 0; w < graph.getVertices(); w++) {
            if (!hasPathTo(w) || w == s) continue;
            int v = edgeTo[w];
            if (distTo[w] != distTo[v] + 1) {
                System.out.println("shortest path edge " + v + "-" + w);
                System.out.println("distTo[" + v + "] = " + distTo[v]);
                System.out.println("distTo[" + w + "] = " + distTo[w]);
                return false;
            }
        }
        return true;
    }
	
	
	
	 public static void main(String[] args)throws Exception {
       Scanner scanner = new Scanner(new File("bin/com/datastructures/graphs/dfs-connected.txt"));
	   AdjListGraph graph = new AdjListGraph(scanner);
//	   System.out.println(graph);
       int source = 0;
	   BreadthFirstPaths bfs = new BreadthFirstPaths(graph, source);
	   
	       for (int v = 0; v < graph.getVertices(); v++) {
	            if (bfs.hasPathTo(v)) {
	                System.out.print(source+" to "+ v+" ("+bfs.distTo(v)+")");
	                Stack<Integer> stack = bfs.pathTo(v);
	                while(!stack.empty()) {
	                	int x = stack.pop();
	                    if (x == source) 
	                    	System.out.print(x);
	                    else        
	                    	System.out.print("-" + x);
	                }
	                System.out.println();
	            }
	            else {
	            	System.out.print(source+" to "+v+"(-):  not connected");
	            }
	        }
	  }	
}
