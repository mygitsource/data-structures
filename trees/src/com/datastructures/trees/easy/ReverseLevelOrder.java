package com.datastructures.trees.easy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import com.datastructures.trees.Node;
import com.datastructures.trees.util.Util;
import com.datastructures.trees.util.UtilTrees;

public class ReverseLevelOrder {

	static void reverseLevelOrder(Node root){
		if(root == null) return;
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		Stack<Node> stack = new Stack<>(); 
		Node temp = null;
		while(!queue.isEmpty()){
			temp = queue.poll();
			if(temp != null){
				stack.push(temp);
				if(temp.getLeft() != null)
					queue.add(temp.getLeft());
				if(temp.getRight() != null)
					queue.add(temp.getRight());
			}
		}
		
		while(!stack.isEmpty()){
			System.out.print(stack.pop()+" ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Util.levelOrderTraversal(UtilTrees.getBinaryTree1());
		reverseLevelOrder(UtilTrees.getBinaryTree1());
	}
}
