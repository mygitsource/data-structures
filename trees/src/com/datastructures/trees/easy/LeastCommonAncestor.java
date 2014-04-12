package com.datastructures.trees.easy;

import com.datastructures.trees.Node;
import com.datastructures.trees.util.UtilTrees;

public class LeastCommonAncestor {

	//this is not binary serach tree, this only binary tree
	//do pre order traversal 
	static Node leastCommonAncestor(Node root, int x , int y){
		if(root == null) return null;
		
		if(root.getData() == x || root.getData() == y){
			return root;
		}
		
		Node left = leastCommonAncestor(root.getLeft(), x, y);
		Node right = leastCommonAncestor(root.getRight(), x, y);
		
		if(left != null && right != null) return root;
		return (left != null ? left: right);
		
	}
	
	public static void main(String[] args) {
		Node node = leastCommonAncestor(UtilTrees.getBinaryTree4(), 14, 19);
		System.out.println(node);
	}
}
