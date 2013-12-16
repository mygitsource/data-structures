package com.datastructures.trees.bt;

import java.util.LinkedList;
import java.util.Queue;

import com.datastructures.trees.Node;
import com.datastructures.trees.util.StaticTrees;

public class DeepestLeftLeafNode {
	
	//private static Node value = null;
	
	public static void main(String[] args) {
		inorderTraversalMethod();
		//levelOrderTraversalMethod();
		
	}
	
	private static void levelOrderTraversalMethod(){
		Node node = StaticTrees.getBinaryTree1();
		int level = 0;
		int maxLevel = 0;
//		Node leftLeafNode = null;
		//levelOrderTraversalMethod(node);
		inorderTraversalMethod();
		//System.out.println("DeepestLeftLeafNode : "+value.getData());
	}
	
	/**
	 * in level order traversal if we want to know the deepest left node, we need to store the 
	 * left or right of the node information. otherwise we don't know that 
	 * the node is left/right at the time of processing.
	 */
	
	private static Node levelOrderTraversalMethod(Node node){
		int level = 0;
		int maxLevel = 0;
		int value = 0;
		if(node == null) return null;
		Queue<Node> queue = new LinkedList<>();
		queue.add(node);
		queue.add(StaticTrees.dummy);
		while(!queue.isEmpty()){
			Node temp = queue.poll();
			//System.out.println(temp.getData());
			if(temp.getData() == -9999){
				level++;
				if(!queue.isEmpty())
					queue.add(StaticTrees.dummy);
			}else{
				if(temp.getLeft() != null){
					queue.add(temp.getLeft());
				}else if(temp.getRight() == null){
					if(level >= maxLevel){
						maxLevel = level;
						value = temp.getData();
					}
				}
				if(temp.getRight() != null){
					queue.add(temp.getRight());
				}
			}
			
		}
		System.err.println(value);
		return null;
	}
	
	private static void inorderTraversalMethod(){
		Node node = StaticTrees.getBinaryTree1();
		int level = 0;
		int maxLevel = 0;
		Node value;
		value = inorderTraversalMethod(node, false, level, maxLevel);
		System.out.println("DeepestLeftLeafNode : "+value.getData());
	}
	
	/**
	 * Get deepest leftnode of the tree. Do inorder traversal of the given tree.
	 * check for each leave and check if the node isleft and there is no left node.
	 * keep that node value in variable.   
	 */
	private static Node inorderTraversalMethod(Node node, boolean isLeft, int level, int maxLevel){
		if(node == null) return null;
		Node value = null;
		Node temp1 = null;
		Node temp2 = null;
		if((level >= maxLevel) && isLeft && (node.getLeft() == null) ){
			maxLevel = level;
			value = node;
		}
		if(node.getLeft() != null)
		temp1 = inorderTraversalMethod(node.getLeft(), true, level+1, maxLevel);
		if(node.getRight() != null)
		temp2 = inorderTraversalMethod(node.getRight(), false, level+1, maxLevel);
		
		if(temp2 != null)
			value = temp2;
		else if (temp1 != null)
			value = temp1;
		
		return value;
	}
	
	
}
