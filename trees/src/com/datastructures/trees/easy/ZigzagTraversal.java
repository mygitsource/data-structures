package com.datastructures.trees.easy;

import java.util.Stack;

import com.datastructures.trees.Node;
import com.datastructures.trees.util.Util;
import com.datastructures.trees.util.UtilTrees;

public class ZigzagTraversal {

	/**
	 *  We can use one stack for printing from left to right and other stack for printing from right to left. In every iteration, we have nodes of one level in one of the stacks. We print the nodes, and push nodes of next level in other stack.
	 *  take two stacks first add root to stack1 then while print stack1 add children to stack2, then while printing stack2 add children to stack1.
	 *   
	 *  Complexity o(n) and space o(n)  
	 */
	static void zigzag(Node root){
		if(root == null)return;
		
		Stack<Node> stack1 = new Stack<>();
		Stack<Node> stack2 = new Stack<>();
		stack1.push(root);
		
		while(!stack1.isEmpty() || !stack2.isEmpty()){
		
			while(!stack1.empty()){
				root = stack1.pop();
				System.out.print(root+" ");
				if(root.getLeft() != null){
					stack2.push(root.getLeft());
				}
				if(root.getRight() != null){
					stack2.push(root.getRight());
				}
			}
			System.out.println();
			while(!stack2.empty()){
				root = stack2.pop();
				System.out.print(root+" ");
				if(root.getRight() != null){
					stack1.push(root.getRight());
				}
				if(root.getLeft() != null){
					stack1.push(root.getLeft());
				}
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		zigzag(UtilTrees.getBinaryTree1());
	}
	
	/* ************************* Set 2 O(n^2)******************************************
	 * 1. print each level elements in different order
	 * 
	 *   static Stack<Node> reversLevelOrderZigzag = new Stack<>(); 
	 * 2. case if we need print zigzag in reversordr we need to add the same to stack. 
	 *   complexity is O(n^2)
	 * */
	static Stack<Node> reversLevelOrderZigzag = new Stack<>();
	static void printLevel(Node root, int level, boolean isReverse){
		if(root == null) return;
		
		if(level == 0){
			System.out.print(root.getData()+" ");
			reversLevelOrderZigzag.push(root);
		}else{
			if(!isReverse){
				printLevel(root.getLeft(), level-1, isReverse);
				printLevel(root.getRight(), level-1, isReverse);
			}else{
				printLevel(root.getRight(), level-1, isReverse);
				printLevel(root.getLeft(), level-1, isReverse);
			}
		}
	}
	
	public static void main2(String[] args) {
		Node root = UtilTrees.getBinaryTree1();
		int height = Util.height(root);
		boolean isReverse  = true;
		for (int i = 0; i < height; i++) {
			printLevel(root, i, isReverse );
			System.out.println();
			isReverse = !isReverse;
		}
		
		while(!reversLevelOrderZigzag.isEmpty())
			System.out.print(reversLevelOrderZigzag.pop()+" ");
		
	}
}
