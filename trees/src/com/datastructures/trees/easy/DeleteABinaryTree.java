package com.datastructures.trees.easy;

import com.datastructures.trees.Node;
import com.datastructures.trees.util.Util;
import com.datastructures.trees.util.UtilTrees;

/**
 * @author ravi
 * Delete a binary tree. First delete children before going to delete parent. So lets use postorder
 *
 */
public class DeleteABinaryTree {

	static void deleteBinaryTree(Node root){
		if(root == null) return;
		deleteBinaryTree(root.getLeft());
		deleteBinaryTree(root.getRight());
		root.setData(null);
		root.setLeft(null);
		root.setRight(null);
		root = null;		
		return;
	}
	
	public static void main(String[] args) {
		Node root = UtilTrees.getBinaryTree1();
		Util.printInOrderTraversal(root);
		deleteBinaryTree(root);
		Util.printInOrderTraversal(root);
	}
}
