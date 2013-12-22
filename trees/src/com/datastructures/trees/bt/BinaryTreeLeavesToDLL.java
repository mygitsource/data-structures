package com.datastructures.trees.bt;

import com.datastructures.list.LinkedList;
import com.datastructures.trees.Node;
import com.datastructures.trees.Traversal;
import com.datastructures.trees.util.UtilTrees;
import com.datastructures.trees.util.Util;

/**
 * Given a Binary Tree, extract all leaves of it in a Doubly Linked List (DLL). 
 * Note that the DLL need to be created in-place. Assume that the node structure of
 * DLL and Binary Tree is same, only the meaning of left and right pointers are different. 
 * In DLL, left means previous pointer and right means next pointer.
 * http://www.geeksforgeeks.org/connect-leaves-doubly-linked-list/ 
 *  
 * @author ravi
 * 
*/
public class BinaryTreeLeavesToDLL {
	
	public static LinkedList extractLeaves(Node node, Node parent,LinkedList list){
		if(node == null || list == null) return null;
		
		if(node.getLeft() == null && node.getRight() == null){
			list.insertNode(node.getData());
			
			if(parent.getLeft() != null && parent.getLeft().getData() == node.getData()){
				parent.setLeft(null);
			}else if(parent.getRight() != null && parent.getRight().getData() == node.getData()){
				parent.setRight(null);
			}
		}
		extractLeaves(node.getLeft(), node, list);
		extractLeaves(node.getRight(), node, list);
		return list;
	}

	
	public static void main(String args[])	{
		Node node = UtilTrees.getBinaryTree2();
		Util.printTree(node, Traversal.INORDER);
		System.out.println("********************");
		LinkedList list = new LinkedList();
		list = extractLeaves(node, node, list);
		Util.printList(list);
		System.out.println("********************");
		Util.printTree(node, Traversal.INORDER);
	}
	
}
