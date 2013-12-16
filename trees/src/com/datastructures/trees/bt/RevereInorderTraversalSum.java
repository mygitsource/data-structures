package com.datastructures.trees.bt;

import com.datastructures.trees.Node;
import com.datastructures.trees.util.StaticTrees;
import com.datastructures.trees.util.Util;

public class RevereInorderTraversalSum {

	/**
	 * RDL  
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
		Node root = StaticTrees.getBinaryTree1();
		int sum = reverseInorderSum(root, 0);
		//Util.levelOrderTraversalUsingHeight(root);
		Util.printInorderTraversal(root);
		
	}
}
