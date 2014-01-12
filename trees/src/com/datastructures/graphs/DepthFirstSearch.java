package com.datastructures.graphs;

import java.io.File;
import java.util.Scanner;

import sun.print.resources.serviceui;

//Run depth first search on an undirected graph.
//Runs in O(E + V) time. & sampe O(V)
//determining the vertices connected to a given source vertex in an undirected graph
public class DepthFirstSearch {

	private boolean[] visited;	//is there is an source to v path.
	private int count;			// number of vertices connted to source
	
	DepthFirstSearch(AdjListGraph graph) {
		visited = new boolean[graph.getVertices()];
	}
	
	//find vertices connected to source vertex
	void dfs(AdjListGraph graph, int vertex){
		count++;
		visited[vertex] = true;
		for(int w: graph.getAdjacentVertices(vertex)){
			System.out.println("x: "+w);
			if(!visited[w]){
				dfs(graph, w);
			}
		}
	}
	
	//is there a path from source to find vertex.
	boolean isVisted(int vertex){
		return visited[vertex];
	}
	
	int getCount(){
		return count;
	}
	
	
	public static void main(String[] args)throws Exception {
       Scanner scanner = new Scanner(new File("bin/com/datastructures/graphs/small.txt"));
	   AdjListGraph graph = new AdjListGraph(scanner);
	   DepthFirstSearch search = new DepthFirstSearch(graph);
	   search.dfs(graph, 0);
	   for(int v = 0; v<graph.getVertices(); v++){
		   if(search.isVisted(v))
			   System.out.print(v+" ");
	   }
	   System.out.println("\n"+search.getCount()+"\n");
	   if(search.getCount() != graph.getVertices()){
		   System.out.println("Not Connected");
	   }else{
		   System.out.println("Connected");
	   }
	   
	}
}
