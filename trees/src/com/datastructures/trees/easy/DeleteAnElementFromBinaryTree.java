package com.datastructures.trees.easy;

import com.datastructures.trees.Node;
import com.datastructures.trees.util.Util;
import com.datastructures.trees.util.UtilTrees;

public class DeleteAnElementFromBinaryTree {

	static Node deleteAnElementFromBinaryTree(Node root, int k){
		Node kNode = findElement(root, k);
		System.out.println(kNode.getData());
		Node dNode = FindDeepestNodeInBinaryTree.deepestNodeInBinaryTree(root);
		kNode.setData(dNode.getData());
		//Still shows null, we need to set null to parent of this node.
		dNode.setData(null);
		dNode = null;
		return root;
	}
	
	static Node findElement(Node root, int k){
		if(root == null) return null;
		
		if(root.getData() == k){
			return root;
		}
		Node left = findElement(root.getLeft(), k);
		Node right = findElement(root.getRight(), k);
		
		return (right == null? left: right);		
	}
	
	public static void main(String[] args) {
		Node root = UtilTrees.getBinaryTree4();
		 Util.printPreOrderTraversal(root);
		root = deleteAnElementFromBinaryTree(root, 23);
		Util.printPreOrderTraversal(root);
		
	}
	
}
