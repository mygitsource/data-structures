package com.datastructures.graphs.routes1;

import java.util.LinkedList;

class Node {
    private String cityname;
    private LinkedList<Node> connects;
  
    Node(String cityname) {
      this.cityname = cityname ;
      this.connects = new LinkedList<Node>();
    }
  
    void addEdge(Node toNode) {
      this.connects.add(toNode);
    }
  }
