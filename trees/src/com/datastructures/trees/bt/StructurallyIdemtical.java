package com.datastructures.trees.bt;

import com.datastructures.trees.Node;

public class StructurallyIdemtical {

	private static boolean isIdentical(Node n1, Node n2){
		//first end condition then OR condition
		if(n1 == null && n2 == null) return true;
		if(n1 == null || n2 == null) return false;
		
		return ((n1.getData() == n2.getData()) && (isIdentical(n1.getLeft(), n2.getLeft()) && isIdentical(n1.getRight(), n2.getRight())));
	}
	
	
	public static void main(String[] args) {
		System.out.println(isIdentical(getTree1(), getTree2()));
	}
	
	
	private static Node getTree1(){
		
		Node node4 = new Node(4);
		Node node6 = new Node(6);
		Node node7 = new Node(7);
		Node node8 = new Node(8);
		
		Node node5 = new Node(node7, 5, node8);
		Node node2 = new Node(node4, 2, node5);
		Node node3 = new Node(node6, 3, null);
		Node root = new Node(node2, 1, node3);

		return root;
	}

	private static Node getTree2(){
		
		Node node4 = new Node(4);
		Node node6 = new Node(6);
		Node node7 = new Node(7);
		Node node8 = new Node(8);
		
		Node node5 = new Node(node7, 5, node8);
		Node node2 = new Node(node4, 2, node5);
//		Node node3 = new Node(null, 3, node6);
		Node node3 = new Node(node6, 3, null);
		Node root = new Node(node2, 1, node3);

		return root;
	}

}
