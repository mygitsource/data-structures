package com.datastructures.graphs.sample1;

class GraphNode {

    public int data;
    public State state;

    public GraphNode(int d) {
        this.data = d;
        this.state = State.UnVisited;
    }
}

enum State {
    UnVisited, Visited, Processed;
}