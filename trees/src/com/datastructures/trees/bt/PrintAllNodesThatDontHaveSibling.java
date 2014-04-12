package com.datastructures.trees.bt;

import java.util.LinkedList;
import java.util.Queue;

import com.datastructures.trees.Node;

public class PrintAllNodesThatDontHaveSibling {

	
	static void printAllNodesThatDontHaveSibling(Node node){
		if(node == null) return;
		
		Queue<Node> queue = new LinkedList<>();
		queue.add(node);
		Node temp = null;
		while(!queue.isEmpty()){
			temp = queue.poll();
			
			if(temp != null){
				if(temp.getLeft() != null){
					queue.add(temp.getLeft());
				}
				if(temp.getRight() != null){
					queue.add(temp.getRight());
				}
				
				if(temp.getLeft() != null && temp.getRight() == null){
					System.out.println(temp.getLeft());
				}else if(temp.getRight() != null && temp.getLeft() == null){
					System.out.println(temp.getRight());
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		Node root = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		
		root.setLeft(node2);
		root.setRight(node3);
		node2.setRight(node4);
		node3.setLeft(node5);
		node5.setLeft(node6);
	
		
		printAllNodesThatDontHaveSibling(root);
		
	}
}
