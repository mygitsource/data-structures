package com.datastructures.trees.easy;

import java.util.Stack;

import com.datastructures.trees.Node;
import com.datastructures.trees.util.UtilTrees;

public class PrintAllAncestors {

	static boolean printAllancestors(Node root, int k){
		if(root == null) return false;
		if(root.getData() == k){
			System.out.println(root.getData());
			return true;
		}
		if(printAllancestors(root.getLeft(), k) || printAllancestors(root.getRight(), k)){
			System.out.println(root.getData());
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		printAllancestors(UtilTrees.getBinaryTree1(), 7);
		//printAllAncestorsWithoutRecursion(UtilTrees.getBinaryTree1(), 7);
	}
	
	/*static void printAllAncestorsWithoutRecursion(Node root, int k){
		if(root == null) return;
		Stack<Node> stack = new Stack<>();
		
		while(true){
			while(root != null && root.getData() != k){
				stack.push(root);
				root = root.getLeft();
			}
			
			if(root != null && root.getData() == k){
				break;
			}
			
			if(!stack.isEmpty() && stack.peek().getRight() == null){
				root = stack.pop();
				
				while((!stack.isEmpty()) && (stack.peek().getRight() != null && stack.peek().getRight().getData() == root.getData())){
					root = stack.pop();
				}
			}
			
			root = (stack.isEmpty()? null : stack.peek().getRight());
			if(root == null && stack.isEmpty()){
				break;
			}
			
		}
		
		while(!stack.isEmpty()){
			System.out.println(stack.pop());
		}
	}*/
	
}
