package com.datastructures.trees.bt;

import java.util.Stack;

import com.datastructures.trees.Node;
import com.datastructures.trees.Traversal;
import com.datastructures.trees.util.Util;
import com.datastructures.trees.util.UtilTrees;

/**
 * http://www.geeksforgeeks.org/print-ancestors-of-a-given-binary-tree-node-without-recursion/
 * 
      		  1
		    /   \
		   2     3
		 /      /  \  
		4      5    6
		       \     \
		        7     8
		       /       \
		      9         10
  
  
  example : 8 ---->  6 3 1
 */
		
public class PrintAncestorsOfAGivenBinaryTreeNodeWithoutRecursion {
	
	private static void printAncestorsOfAGivenBinaryTreeNodeWithoutRecursion(Node node, int key){
		if(node == null) return;
		Stack<Node> stack = new Stack<>();
		while (true) {
			//push all the leftnodes to the stack.
			while (node != null && node.getData() != key) {
				stack.push(node);
				node = node.getLeft();
			}
			if(node!= null && node.getData() == key){
				break;
			}
			
			//pop the node , when the right is null, becaus we don't need this node.
			if((!stack.isEmpty()) && stack.peek().getRight() == null ){
				node = stack.pop();
				
				//if the node is the right child of the peek. then remove the top. Which means traversing back from right sub tree.
				/*  2		14 is right child of 2. then remove 2.
					 \
				     14
				*/
				while((!stack.isEmpty()) && stack.peek().getRight() != null && stack.peek().getRight().getData() == node.getData()){
					node = stack.pop();
				}
			}
			
			//start traversing right subtree.
			node = (stack.isEmpty()? null: stack.peek().getRight());
			if(node == null && stack.isEmpty()){
				break;
			}
		}
		
		while (!stack.isEmpty()) {
			System.err.println(stack.pop());
		}
	}
	
	public static void main(String[] args) {
		Node root = UtilTrees.getBinaryTree1();
		printAncestorsOfAGivenBinaryTreeNodeWithoutRecursion(root, 7);
	}
}
