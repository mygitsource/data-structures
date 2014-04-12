package com.datastructures.trees.bst;

import com.datastructures.trees.Node;
import com.datastructures.trees.util.UtilTrees;

//binary search tree
public class LowestORLeastCommonAncestorInABinarySearchTree {
	
	static Node lowestCommonAncestor(Node root, int n1, int n2){
		if(root == null) return null;
		
		// If both n1 and n2 are smaller than root, then LCA lies in left
		if(root.getData() > n1 && root.getData() > n2){
			return lowestCommonAncestor(root.getLeft(), n1, n2);
		}
		
		// If both n1 and n2 are greater than root, then LCA lies in right
		if(root.getData() < n1 && root.getData() < n2){
			return lowestCommonAncestor(root.getRight(), n1, n2);
		}
		
		return root;
	} 
	
	
	static Node lowestCommonAncestorWithOutRecursion(Node root, int n1, int n2){
		while(root != null){
			// If both n1 and n2 are smaller than root, then LCA lies in left
			if(root.getData() > n1 && root.getData() > n2){
				root = root.getLeft();
				
				// else : If both n1 and n2 are greater than root, then LCA lies in right
			}else if(root.getData() < n1 && root.getData() < n2){	
				root = root.getRight();
			}
		}
		return root;
	} 
	
	public static void main(String[] args) {
		Node root = UtilTrees.getBinaryTree4();
		root = lowestCommonAncestor(root,14,19);
		//root = lowestCommonAncestorWithOutRecursion(root, 14, 19);
		System.out.println(root);
	}
}
