package com.datastructures.trees.bt;

import com.datastructures.trees.Node;
import com.datastructures.trees.Traversal;
import com.datastructures.trees.util.UtilTrees;
import com.datastructures.trees.util.Util;

/**
 *
 * Given a binary tree, a complete path is defined as a path from root to a leaf. 
 * The sum of all nodes on that path is defined as the sum of that path. Given a number K, 
 * you have to remove (prune the tree) all nodes which don’t lie in any path with sum>=k.
 * Note: A node can be part of multiple paths. 
 * So we have to delete it only in case when all paths from it have sum less than K.
 *
 */
public class BinaryTreeSumAndDeleteLeaf {
	
	public static Node sumAndDelete(Node root, int k, int sum){
		if(root == null) return root;
		int lsum = sum + root.getData();
		int rsum = lsum;
		
		root.setLeft(sumAndDelete(root.getLeft(), k, lsum));
		root.setRight(sumAndDelete(root.getRight(), k, rsum));

		sum = (lsum > rsum?rsum:lsum);
		if(root.getLeft() == null && root.getRight()== null && sum < k){
//			System.err.println("S: "+sum+" "+root.getData());
			root = null;
		}
		return root;
	}
	
	public static void main(String[] args) {
		int k = 20; //20;
		int sum = 0;
		Node root = UtilTrees.getBinaryTree3();
		//Util.printInorderTraversal(root);
		System.out.println("********");
		Node node1 = sumAndDelete(root, k, sum);
		Util.printTree(node1, Traversal.INORDER);
//		Util.levelOrderTraversalUsingHeight(node1);
		System.out.println("********");
	}
}
