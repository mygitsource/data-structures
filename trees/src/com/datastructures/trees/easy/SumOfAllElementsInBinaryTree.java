package com.datastructures.trees.easy;

import com.datastructures.trees.Node;
import com.datastructures.trees.util.UtilTrees;

public class SumOfAllElementsInBinaryTree {

	static int sumOfAllElements(Node root){
		if(root == null) return 0;
		return(root.getData() + sumOfAllElements(root.getLeft()) + sumOfAllElements(root.getRight()));
	}
	
	public static void main(String[] args) {
		System.out.println(sumOfAllElements(UtilTrees.getBinaryTree1()));
	}
	
}
