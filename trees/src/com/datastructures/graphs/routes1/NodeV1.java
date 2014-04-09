package com.datastructures.graphs.routes1;

import java.util.List;

public class NodeV1 {
	    private String cityname;
	    private List<Node> connects;
	  
	    NodeV1(String cityname, List<Node> connects) {
	      this.cityname = cityname;
	      this.connects = connects;
	    }
}