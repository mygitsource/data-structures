package com.datastructures.trees.bst;

import com.datastructures.trees.Node;
import com.datastructures.trees.util.UtilTrees;

public class InOrderSuccessor_Set2 {

	
	static Node inOrderSuccessor(Node root , Node node ){
//		1) If right subtree of node is not NULL, then succ lies in right subtree. Do following.
//		Go to right subtree and return the node with minimum key value in right subtree.
		
		if(node.getRight() != null){
			return minValue(node.getRight());
		}
		
//		2) If right sbtree of node is NULL, then start from root and us search like technique. Do following.
//		Travel down the tree, if a node’s data is greater than root’s data then go right side, otherwise go to left side.
		Node succ = null;
		while(root != null){
			
			if(node.getData() < root.getData()){
				succ = root;
				root = root.getLeft();
			}else if(node.getData() > root.getData()) {
				root = root.getRight();
			}else{
				break;
			}
			
		}
		return succ;
	}
	
	
	static Node minValue(Node node){
		Node current = node;
		while(current.getLeft() != null){
			current = current.getLeft();
		}
		return current;
	}
	
	public static void main(String[] args) {
		Node root = UtilTrees.getBinaryTree4();
		Node node = inOrderSuccessor(root, root.getLeft().getRight());
		System.out.println(node);
	}
}
