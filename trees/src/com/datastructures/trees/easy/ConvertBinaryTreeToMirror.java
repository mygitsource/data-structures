package com.datastructures.trees.easy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import com.datastructures.trees.Node;
import com.datastructures.trees.util.Util;
import com.datastructures.trees.util.UtilTrees;

public class ConvertBinaryTreeToMirror {

	static Node convertToMirror(Node root){

		if(root != null){
			convertToMirror(root.getLeft());
			convertToMirror(root.getRight());
			
			Node temp = root.getRight();
			root.setRight(root.getLeft());
			root.setLeft(temp);
		}
	return root;
	}
	
	public static void main(String[] args) {
		Node root = UtilTrees.getBinaryTree1();
		Util.printInOrderTraversal(root);
		convertToMirror(root);
		Util.printInOrderTraversal(root);
//		==============================
		root = convertToMirrorWithoutRecursion(root);
		Util.printInOrderTraversal(root);
	}

	static Node convertToMirrorWithoutRecursion(Node root){
		if(root == null) return null;
		Node temp = null;
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		Stack<Node> stack = new Stack<>();
		while(!queue.isEmpty()){
			temp = queue.poll();
			if(temp != null){
				stack.add(temp);
				if(temp.getLeft() != null){
					queue.add(temp.getLeft());
				}
				if(temp.getRight() != null){
					queue.add(temp.getRight());
				}
			}
		}
		
		while(!stack.isEmpty()){
			root = stack.pop();
			Node _temp = root.getRight();
			root.setRight(root.getLeft());
			root.setLeft(_temp);
		}
		return root;
			
	}

}
