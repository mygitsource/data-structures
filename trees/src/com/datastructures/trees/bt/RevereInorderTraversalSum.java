package com.datastructures.trees.bt;

import com.datastructures.trees.Node;
import com.datastructures.trees.Traversal;
import com.datastructures.trees.util.UtilTrees;
import com.datastructures.trees.util.Util;

public class RevereInorderTraversalSum {

	/**
	 * Given a Binary Search Tree (BST), modify it so that all greater values in the 
	 * given BST are added to every node. For example, consider the following BST.
	 * 
	 * Reverse in order traversal : RDL  
	 *  The idea is to use following BST property. If we do reverse In order traversal of BST, 
	 *  we get all nodes in decreasing order. We do reverse In order traversal and keep 
	 *  track of the sum of all nodes visited so far, we add this sum to every node.
	 *  http://www.geeksforgeeks.org/add-greater-values-every-node-given-bst/
	 */
	public static int reverseInorderSum(Node node, int sum){
		if(node != null ){
			sum = reverseInorderSum(node.getRight(), sum);
		}
		if(node != null){
			node.setData(node.getData()+sum);
			sum = node.getData();
		}
		if(node != null){
			sum = reverseInorderSum(node.getLeft(), sum);
		}
		return sum;
	}
	
	public static void main(String[] args) {
		Node root = UtilTrees.getBinaryTree1();
		int sum = reverseInorderSum(root, 0);
		//Util.levelOrderTraversalUsingHeight(root);
		Util.printTree(root, Traversal.INORDER);
		
	}
}
