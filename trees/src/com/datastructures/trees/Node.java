package com.datastructures.trees;

public class Node {
	
	public Node(int data){
		this.data = data;
	}
	
	private int data = -1;
	private Node left;
	private Node right;
	
	public int getData() {
		return data;
	}
	public void setData(int data) {
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
		return Integer.toString(data);
	}
}
