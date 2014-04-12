package com.datastructures.trees.bst;

import com.datastructures.trees.Node;
import com.datastructures.trees.util.UtilTrees;

/*
 * A balanced tree is defined to be a tree such that the heights of the two subtrees of any 
 * node never differ more than one.
 */

public class ISBSTBalanced_Set2 {

	static int checkHeight(Node root){
		if(root  == null){
			return 0;
		}
		
		int leftHeight = checkHeight(root.getLeft());
		if(leftHeight == -1){
			return -1;
		}
		
		int rightHeight = checkHeight(root.getRight());
		if(rightHeight == -1){
			return -1;
		}
		
		int heightDiff = leftHeight - rightHeight;
		if(Math.abs(heightDiff) > 1){
			return -1;
		}else{
			return Math.max(leftHeight, rightHeight) +1;
		}
	}
	
	static boolean isBalanced(Node root){
		if(checkHeight(root) == -1){
			return false;
		}else{
			return true;
		}
	}
	
	public static void main(String[] args) {
		Node root = UtilTrees.getBinaryTree7();
		System.out.println(isBalanced(root));
	}
}
