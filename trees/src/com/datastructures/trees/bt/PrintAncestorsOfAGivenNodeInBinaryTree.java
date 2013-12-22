package com.datastructures.trees.bt;

import com.datastructures.trees.Node;
import com.datastructures.trees.util.UtilTrees;

/**
 * http://www.geeksforgeeks.org/print-ancestors-of-a-given-node-in-binary-tree/
 *
 */
public class PrintAncestorsOfAGivenNodeInBinaryTree {

	private static boolean printAncestors(Node root, int key){
		if(root == null) return false;
		
		if(root.getData() == key){
			return true;
		}
		
		if(printAncestors(root.getLeft(), key) || printAncestors(root.getRight(), key)){
			System.out.println(root.getData());
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		Node root = UtilTrees.getBinaryTree1();
		printAncestors(root, 10);
	}
}
