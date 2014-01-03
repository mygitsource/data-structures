package com.datastructures.trees.bt;

import com.datastructures.trees.Node;
import com.datastructures.trees.util.UtilTrees;

/*
 * 1) Fix Left Pointers: In this step, we change left pointers to point to previous nodes in DLL. 
 * The idea is simple, we do inorder traversal of tree. In inorder traversal, 
 * we keep track of previous visited node and change left pointer to the previous node. 
 * See fixPrevPtr() in below implementation.

	2) Fix Right Pointers: The above is intuitive and simple. 
	How to change right pointers to point to next node in DLL? The idea is to use left pointers fixed in 
	step 1. We start from the rightmost node in Binary Tree (BT). The rightmost node is the last node in DLL. 
	Since left pointers are changed to point to previous node in DLL, 
	we can linearly traverse the complete DLL using these pointers. 
	The traversal would be from last to first node. While traversing the DLL, 
	we keep track of the previously visited node and change the right pointer to the previous node. 
	See fixNextPtr() in below implementation.
	
	Set - 2
 */
public class ConvertAGivenBinaryTreeToDoublyLinkedList {

	static Node prev1;
	private static void setPreviousNode(Node root){
		if(root == null) return;
		
		setPreviousNode(root.getLeft());
		root.setLeft(prev1);
		prev1 = root;
		setPreviousNode(root.getRight());
	}
	
	private static Node setRightNode(Node root){
		Node prev = null;
		while(root != null && root.getRight() != null){
			root = root.getRight();
		}
		
		while (root != null && root.getLeft() != null) {
			prev = root;
			root = root.getLeft();
			root.setRight(prev);
		}
		
		return root;
	}
	
	
	public static void main(String[] args) {
		Node node = UtilTrees.getBinaryTree6();
		
		setPreviousNode(node);
		node = setRightNode(node);
		
		Node first = node;
		Node last = null;
		while(node != null){
			System.out.println(node);
			node = node.getRight();
			if(node != null){
				last = node;
			}
		}
		
		System.out.println("**********");
		node = last;
		while(node != null){
			System.out.println(node);
			node = node.getLeft();
		}
		
	}
	
	
	/*
	
	Another approch.
	
1. If left subtree exists, process the left subtree
…..1.a) Recursively convert the left subtree to DLL.
…..1.b) Then find inorder predecessor of root in left subtree (inorder predecessor is rightmost node in left subtree).
…..1.c) Make inorder predecessor as previous of root and root as next of inorder predecessor.
2. If right subtree exists, process the right subtree (Below 3 steps are similar to left subtree).
…..2.a) Recursively convert the right subtree to DLL.
…..2.b) Then find inorder successor of root in right subtree (inorder successor is leftmost node in right subtree).
…..2.c) Make inorder successor as next of root and root as previous of inorder successor.
3. Find the leftmost node and return it (the leftmost node is always head of converted DLL).
	
	 */
}
