package com.datastructures.trees.bt;

import com.datastructures.trees.Node;
import com.datastructures.trees.util.UtilTrees;

public class PrintAllAncestors {

	static boolean printAllAncestors(Node root, int data){
		if(root == null) return false;
		
		if(root.getData() == data){
			return true;
		}
		/* If target is present in either left or right subtree of this node,
	     then print this node */
		if(printAllAncestors(root.getLeft(), data) || printAllAncestors(root.getRight(), data)){
			System.out.print(root.getData()+" - ");
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		printAllAncestors(UtilTrees.getBinaryTree3(), 11);
	}
}
