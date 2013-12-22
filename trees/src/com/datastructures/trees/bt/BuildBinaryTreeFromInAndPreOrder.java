package com.datastructures.trees.bt;

import com.datastructures.trees.Node;
import com.datastructures.trees.Traversal;
import com.datastructures.trees.util.Util;

/**
 * Constructing a binary tree from inorder and preorder.
 * 
 * @author ravi
 *
 */
public class BuildBinaryTreeFromInAndPreOrder {

	static int preIndex = 0;
	
	private static Node buildBinaryTree(int[] inOrder, int[] preOrder, int strInd, int endInd){
		if(strInd > endInd){
			return null;
		}
		
		Node node = new Node(preOrder[preIndex]);
		preIndex++;
		/*if this node has no childern then return*/
		if(strInd == endInd){	
//			System.out.println(node.getData());
			return node;
		}else{
			/*find the index of this node in inorder traversal */
			int inIndex = search(inOrder, strInd, endInd, node.getData());
			
			//Using index in Inorder traversal, construct left and right subtrees
			node.setLeft(buildBinaryTree(inOrder, preOrder, strInd, inIndex -1));
			node.setRight(buildBinaryTree(inOrder, preOrder, inIndex+1, endInd));
//			System.out.println(node.getData());
			return node;
		}
	}
	
	public static void main(String[] args) {
		int inOrder[] = {4, 2, 5, 1, 3, 6};
		int preOrder[] = {1, 2, 4, 5, 3, 6};
		Node root = buildBinaryTree(inOrder, preOrder, 0, 5);
		//print in post order
		//Util.printTree(root, Traversal.POSTORDER);
	}
	
	private static int search(int array[], int start, int end, int find){
		for( ; start <= end; start++) {
			if(array[start] == find){
				return start;
			}
		}
		return -1;
	}

}
