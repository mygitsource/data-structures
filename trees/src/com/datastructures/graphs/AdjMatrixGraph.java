package com.datastructures.graphs;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

public class AdjMatrixGraph {

	private int vertices;
	private int edges;
	private boolean[][] adj;
	
	AdjMatrixGraph(int vertices){
		if(vertices < 0) throw new IllegalArgumentException("vertices must be grater then zero");
		this.vertices = vertices;
		this.edges = 0;
		this.adj = new boolean[vertices][vertices];
	}
	
	AdjMatrixGraph(int vertices, int edges){
		this(vertices);
		if(edges < 0) throw new IllegalArgumentException("edges must be grater then zero");
		int _edges = (vertices * (vertices - 1))/2;
		if(edges > _edges) throw new RuntimeException("too many edges..!");
		
		//random graph..
		Random random = new Random();
		while(this.edges != edges){
			int v = random.nextInt(vertices);
			int w = random.nextInt(vertices);
			addEdge(v,w);
		}
	}
	
	void addEdge(int v, int w){
		if(!adj[v][w]) edges++;
		adj[v][w]=true;
		adj[w][v]=true;
	}
	
	boolean contains(int v, int w){
		return adj[v][w];
	}
	
	Iterable<Integer> getAdjecentVertices(int v){
		return new AdjIterator(v);
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(vertices).append(" ").append(edges).append("\n");
		for(int v=0; v<vertices; v++){
			builder.append(v).append(" : ");
			for(int w: getAdjecentVertices(v)){
				builder.append(w).append(" ");				
			}
			builder.append("\n");
		}
		return builder.toString();
	}
	
	int getVertices(){
		return vertices;
	}
	
	int getEdges(){
		return edges;
	}
	
	
	 private class AdjIterator implements Iterator<Integer>, Iterable<Integer> {
	        int v, w = 0;
	        AdjIterator(int v) { this.v = v; }

	        public Iterator<Integer> iterator() { return this; }

	        public boolean hasNext() {
	            while (w < vertices) {
	                if (adj[v][w]) return true;
	                w++;
	            }
	            return false;
	        }

	        public Integer next() {
	            if (hasNext()) { 
	            	return w++;                         
	            }
	            else{ 
	            	throw new NoSuchElementException(); 
	            }
	        }

	        public void remove()  { throw new UnsupportedOperationException();  }
	    }
	 
	 
	 public static void main(String[] args) {
		 int vertices = 100;
		 int edges = 4900;
		 AdjMatrixGraph graph = new AdjMatrixGraph(vertices, edges);
		 System.out.println(graph);
	 }
}
