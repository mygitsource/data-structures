package com.datastructures.trees.easy;

import java.util.LinkedList;
import java.util.Queue;

import com.datastructures.trees.Node;
import com.datastructures.trees.Traversal;
import com.datastructures.trees.util.Util;
import com.datastructures.trees.util.UtilTrees;


/*
 * since it is binary , we can insert whereever we want , 
 * so traverse the tree, insert node whose left or right node is NULL  
 */
public class InsertNodeIntoBinaryTree {
		
	static void insertNode(Node root, int k){
		if (root == null) return;
		Node nNode = new Node(k);
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		Node temp;
		while(!queue.isEmpty()){
			temp = queue.poll();
			if(temp != null){
				if(temp.getLeft() != null){
					queue.add(temp.getLeft());
				}else{
					temp.setLeft(nNode);
					break;
				}
				
				if(temp.getRight() != null){
					queue.add(temp.getRight());
				}else{
					temp.setRight(nNode);
					break;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Node root = UtilTrees.getBinaryTree1();
//		Util.printTree(root, Traversal.INORDER);
		insertNode(root, 15);
		Util.printTree(root, Traversal.INORDER);
	}
}
