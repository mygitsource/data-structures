package com.datastructures.trees.easy;

import com.datastructures.trees.Node;
import com.datastructures.trees.util.Util;
import com.datastructures.trees.util.UtilTrees;

public class BuildBinaryTreeFromInAndPreOrder {

	static int preIndex;
	static Node buildBinaryTree(int []preOrder, int[] inOrder, int start, int end){
		if(start > end){
			return null;
		}
		int data = preOrder[preIndex];
		preIndex++;
		Node root = new Node(data);
		// when the node does't have children return the same node
		if(start == end){
			return root;
		}
		
		int inIndex = search(inOrder, data, start, end);
		root.setLeft(buildBinaryTree(preOrder, inOrder, start, inIndex-1));
		root.setRight(buildBinaryTree(preOrder, inOrder, inIndex+1, end));
		return root;
	}
	
	static int search(int []inOrder, int k, int start, int end){
		for(; start <= end; start++){
			if(inOrder[start] == k)
				return start;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int []preOrder = new int[]{50, 17, 9, 14, 12, 23, 19, 76, 54, 72, 67};
		int []inOrder = new int[]{9, 12, 14, 17, 19, 23, 50, 54, 67, 72, 76 };
		Node root = buildBinaryTree(preOrder, inOrder, 0, inOrder.length-1);
		Util.printPreOrderTraversal(root);
	}
}
