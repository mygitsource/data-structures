package com.datastructures.trees.bt;

import java.util.LinkedList;
import java.util.Queue;

import com.datastructures.trees.Node;
import com.datastructures.trees.util.UtilTrees;

@Deprecated
public class DeepestLeftLeafNode {
	
	public static void main(String[] args) {
//		inorderTraversalMethod();
		
		//levelorder traversal is not finished.
		levelOrderTraversalMethod();
		
	}
	
	private static void levelOrderTraversalMethod(){
		Node node = UtilTrees.getBinaryTree1();
		int level = 0;
		int maxLevel = 0;
		levelOrderTraversalMethod(node);
		//System.out.println("DeepestLeftLeafNode : "+value.getData());
	}
	
	/**
	 * in level order traversal if we want to know the deepest left node, we need to store the 
	 * left or right of the node information. otherwise we don't know that 
	 * the node is left/right at the time of processing.
	 */
	
	//XXX: levelorder traversal is not finished.
	private static Node levelOrderTraversalMethod(Node node){
		int level = 0;
		int maxLevel = 0;
		int value = 0;
		if(node == null) return null;
		Queue<Node> queue = new LinkedList<>();
		queue.add(node);
		queue.add(null);
		Node temp = null;
		while(!queue.isEmpty()){
			temp = queue.poll();
			//System.out.println(temp.getData());
			if(temp == null){
				//increment level , when temp.data == null, which was inserted as end of level.
				level++;
				if(!queue.isEmpty())
					queue.add(null);
			}else{
				if(temp.getLeft() != null){
					queue.add(temp.getLeft());
				}
				if(temp.getRight() != null){
					queue.add(temp.getRight());
				}
			}
			
			if(temp != null){
				//when right is null check the level and keep the node value. 
				if(level > maxLevel){
					maxLevel = level;
					value = temp.getData();
				}
			}
			
		}
		System.err.println(value);
		return temp;
	}
	
	
	
	
	
	private static void inorderTraversalMethod(){
		Node node = UtilTrees.getBinaryTree1();
		int level = 0;
		int maxLevel = 0;
		Node value = inorderTraversalMethod(node, false, level, maxLevel);
		System.out.println("DeepestLeftLeafNode : "+value.getData());
	}
	
	/**
	 * Get deepest left node of the tree. Do inorder traversal of the given tree.
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
