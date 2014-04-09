package com.datastructures.trees.bst;

import com.datastructures.trees.Node;
import com.datastructures.trees.util.UtilTrees;

/*
 * A balanced tree is defined to be a tree such that the heights of the two subtrees of any 
 * node never differ more than one.
 */
public class ISBSTBalanced_Set1 {

	static int getHeight(Node node){
		if(node == null) return 0;
		return Math.max(getHeight(node.getLeft()), getHeight(node.getRight())) + 1;
	}
	
	static boolean isBalance(Node root) {
		if(root == null) return true;
		int heightDiff = getHeight(root.getLeft()) - getHeight(root.getRight());
		if(Math.abs(heightDiff) > 1){
			return false;
		}else{
			return (isBalance(root.getLeft()) && isBalance(root.getRight()) );
		}
	}
	
	public static void main(String[] args) {
		Node root = UtilTrees.getBinaryTree4();
	    //System.out.println(getHeight(root));
		System.out.println(isBalance(UtilTrees.getBinaryTree7()));
	}
}
