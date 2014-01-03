package com.datastructures.trees.bt;

import com.datastructures.trees.Node;
import com.datastructures.trees.Traversal;
import com.datastructures.trees.util.Util;
import com.datastructures.trees.util.UtilTrees;

public class MirrorOfBinaryTree {
	
	private static Node mirrorOfBinaryTree(Node root){
		if(root == null) return null;
		
		mirrorOfBinaryTree(root.getLeft());
		mirrorOfBinaryTree(root.getRight());
		//swap the nodes
		Node temp = root.getLeft();
		root.setLeft(root.getRight());
		root.setRight(temp);
		
		return root;
	}
	
	/*
	 * Input
		   12
	     /    \
	   5       7       
	 /          \ 
	3            1

	output
		   12
	     /    \
	   7       5       
	 /          \ 
	1            3

	
	 * 
	 */
	
	public static void main(String[] args) {
		Node node = mirrorOfBinaryTree(UtilTrees.getBinaryTree5());
		Util.printTree(node, Traversal.INORDER);
	}
}
