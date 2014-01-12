package com.datastructures.graphs;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdjListGraph {
    private final int vertices;
    private int edges;
    private List<Integer>[] adj;
    
    public AdjListGraph(int vertices) {
   		this.vertices = vertices;
        this.edges = 0;
        adj = new ArrayList[vertices];
        for (int v = 0; v < vertices; v++) {
            adj[v] = new ArrayList<Integer>();
        }
    }

    public AdjListGraph(Scanner scanner)throws Exception {
        this(scanner.nextInt());
        int edges = scanner.nextInt();
        if (edges < 0) throw new IllegalArgumentException("edges should be grater then zero");
        for (int i = 0; i < edges; i++) {
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            addEdge(v, w);
        }
    }

    public int getVertices() {
        return vertices;
    }

    public int getEdges() {
        return edges;
    }

     //Adds the undirected edge v-w to the graph.
    
    public void addEdge(int v, int w) {
        if (v < 0 || v >= vertices) throw new IndexOutOfBoundsException();
        if (w < 0 || w >= vertices) throw new IndexOutOfBoundsException();
        edges++;
        adj[v].add(w);
        adj[w].add(v);
    }


    public Iterable<Integer> getAdjacentVertices(int vertex) {
        if (vertex < 0 || vertex >= vertices) throw new IndexOutOfBoundsException();
        return adj[vertex];
    }


    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(vertices + " vertices, " + edges + " edges " + "\n");
        for (int v = 0; v < vertices; v++) {
            s.append(v + ": ");
            for (int w : adj[v]) {
                s.append(w + " ");
            }
            s.append("\n");
        }
        return s.toString();
    }


    public static void main(String[] args)throws Exception {
    	Scanner scanner = new Scanner(new File("bin/com/datastructures/graphs/small.txt"));
//    	Scanner scanner = new Scanner(new File("bin/com/datastructures/graphs/medium.txt"));
//    	Scanner scanner = new Scanner(new BufferedInputStream(new FileInputStream(new File("bin/com/datastructures/graphs/large.txt"))));
        AdjListGraph graph = new AdjListGraph(scanner);
//        System.out.println(graph.getVertices());
//        System.out.println(graph.getEdges());        
//        System.out.println(graph.getAdjacentVertices(9));
        System.out.println(graph);
    }

}