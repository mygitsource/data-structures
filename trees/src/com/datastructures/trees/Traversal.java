package com.datastructures.trees;

public enum Traversal {
	PREORDER("preorder"), INORDER("inorder"), POSTORDER("postorder");
	
	private String traversal;
	private Traversal(String traversal) {
		this.traversal = traversal;
	}

	@Override
	public String toString() {
		return traversal;
	}
}
