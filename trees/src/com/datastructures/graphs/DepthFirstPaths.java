package com.datastructures.graphs;

import java.io.File;
import java.util.Scanner;
import java.util.Stack;

import javax.sound.midi.Soundbank;

//Run depth first search on an undirected graph.
//Runs in O(E + V) time.
//finding paths from a source vertex source to every other vertex in an undirected graph.

public class DepthFirstPaths {

	private boolean[] visited;	//is there is an source to v path.
	private int[] edgeTo;
	private int source;			// number of vertices connted to source
	
	DepthFirstPaths(AdjListGraph graph, int source) {
		visited = new boolean[graph.getVertices()];
		this.source = source;
		edgeTo = new int[graph.getVertices()];
	}
	
	//find vertices connected to source vertex
	void dfs(AdjListGraph graph, int source){
		visited[source] = true;
		for(int w: graph.getAdjacentVertices(source)){
			if(!visited[w]){
				//store the edge , which we visited
				edgeTo[w] = source;
				dfs(graph, w);
			}
		}
	}
	
	//is there a path from source to find vertex.
	boolean hasPathTo(int vertex){
		return visited[vertex];
	}

	Stack<Integer> pathTo(int vertex){
		if(!hasPathTo(vertex)) return null;
		Stack<Integer> path = new Stack<>();
		for(int i = vertex; i !=source; i = edgeTo[i]){
			path.push(i);
		}
		
		path.push(source);
		return path;
	}
	
	public static void main(String[] args)throws Exception {
       Scanner scanner = new Scanner(new File("bin/com/datastructures/graphs/dfs-connected.txt"));
	   AdjListGraph graph = new AdjListGraph(scanner);
	   int source  = 4;
	   DepthFirstPaths paths = new DepthFirstPaths(graph, source);
	   paths.dfs(graph, source);
	   for(int v = 0; v<graph.getVertices(); v++){
		   if(paths.hasPathTo(v)){
			   System.out.print(source+" to "+v+" : ");
			   Stack<Integer> stack = paths.pathTo(v);
			   while(!stack.isEmpty()){
				   int x = stack.pop();
				   if(x == source){
					   System.out.print(x);
				   }else{
					   System.out.print("-"+x);
				   }
			   }
			   System.out.println("\n");
		   }else{
			   System.out.print("Not Connected");
		   }
	   }
	}
	
}
