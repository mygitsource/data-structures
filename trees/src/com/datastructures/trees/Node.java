package com.datastructures.trees;

/*
The depth of a node is the number of edges from the node to the tree's root node.
The height of a node is the number of nodes on the longest path from the node to a leaf.
For example, when looking at the root node of the tree, 
	the depth would be 0 and the height would be the number of nodes on the longest path to a leaf.
*/
public class Node {
	
	public Node(Integer data){
		this.data = data;
	}
	
	private Integer data = null;
	private Node left;
	private Node right;
	
	public Integer getData() {
		return data;
	}
	public void setData(Integer data) {
		this.data = data;
	}
	public Node getLeft() {
		return left;
	}
	public void setLeft(Node left) {
		this.left = left;
	}
	public Node getRight() {
		return right;
	}
	public void setRight(Node right) {
		this.right = right;
	}
	
	@Override
	public String toString() {
		return data.toString();
	}
}
