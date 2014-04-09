package com.datastructures.trees.easy;

import java.util.LinkedList;
import java.util.Queue;

import com.datastructures.trees.Node;
import com.datastructures.trees.util.UtilTrees;

/**
 * 
 * @author ravi
 * deepest node, deepest left/right node.
 */

public class FindDeepestNodeInBinaryTree {

	static Node deepestNodeInBinaryTree(Node root){
		if(root == null) return null;

		Node temp = null;
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		
		while(!queue.isEmpty()){
			temp = queue.poll();
			if(temp != null){
				if(temp.getLeft() != null){
					queue.add(temp.getLeft());
				}
				if(temp.getRight() != null){
					queue.add(temp.getRight());
				}
			}
		}
		return temp;		
	}
	
	//recursion
	static Node deepestNodeInBinaryTree(Node root, DeepestNode node, int level, int maxLevel ){
		if(root == null) return null;
		
		if(level > maxLevel){
			maxLevel = level;
			node.node = root;
		}
		
		deepestNodeInBinaryTree(root.getLeft(), node, level+1, maxLevel);
		deepestNodeInBinaryTree(root.getRight(), node, level+1, maxLevel);
		
		return node.node;
	}	
	
	static class DeepestNode{
		Node node;
	}

	//recursion
	static Node deepestLeftNodeInBinaryTree(Node root, DeepestNode node, int level, int maxLevel, boolean isLeft ){
		if(root == null) return null;
		
		if(level > maxLevel){
			maxLevel = level;
			if(isLeft){
				node.node = root;
			}
		}
		//change the left/right flag for the deepest node
		deepestLeftNodeInBinaryTree(root.getLeft(), node, level+1, maxLevel, true);
		deepestLeftNodeInBinaryTree(root.getRight(), node, level+1, maxLevel, false);
		
		return node.node;
	}	

	
	public static void main(String[] args) {
/*		Node node = deepestNodeInBinaryTree(UtilTrees.getBinaryTree2());
		System.out.println(node.getData());
*/	
		
		DeepestNode node = new DeepestNode();
		deepestNodeInBinaryTree(UtilTrees.getBinaryTree2(), node, 0, 0 );
		System.out.println(node.node);

		
/*		DeepestNode node = new DeepestNode();
		deepestLeftNodeInBinaryTree(UtilTrees.getBinaryTree2(), node, 0, 0, false);
		System.out.println(node.node);
*/
		
		
	}
	
	
}
