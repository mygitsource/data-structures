package com.datastructures.trees.bst;

import com.datastructures.trees.Node;
import com.datastructures.trees.util.Util;
import com.datastructures.trees.util.UtilTrees;

public class ISBST {

	private static boolean isBST(Node node, int min, int max){
		if(node == null) return true;
		
		if(((node.getData() > min && node.getData() < max))){
			return (isBST(node.getLeft(), min, node.getData()) &&  isBST(node.getRight(), node.getData(), max));
		}
		return false;
	}
	
/*
 * 	 	50
     /    	 \
    17         76
   / 	 \     /
  9      23    54
   \	  /	    \
    14  19	     72
    /            / 
   12    		67

 * */
	public static void main(String[] args) {
		Node node = UtilTrees.getBinaryTree4();
		System.out.println(isBST(node, Integer.MIN_VALUE, Integer.MAX_VALUE));
		
	}
}
