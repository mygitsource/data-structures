package com.datastructures.trees.bt;

import com.datastructures.trees.Node;
import com.datastructures.trees.util.UtilTrees;

public class LeastCommonAncestor {
 //http://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/
	
	static Node leastCommonAncestor(Node root, int n1, int n2){
		
		if(root == null) return null;
		
		if(root.getData() == n1 || root.getData() == n2){
			return root;
		}
		
		Node left = leastCommonAncestor(root.getLeft(), n1, n2);
		Node right = leastCommonAncestor(root.getRight(), n1, n2);
		
		if(left != null && right != null){
			return root;
		}else{
			return (left != null ? left : right);
		}
	}
	
	public static void main(String[] args) {
		Node node = leastCommonAncestor(UtilTrees.getBinaryTree3(), 9, 4);
		System.out.println(node);
	}
}
