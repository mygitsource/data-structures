package com.datastructures.trees.bst;


public class InOrderSuccessor_Set1 {
/*
 * In Binary Tree, Inorder successor of a node is the next node in Inorder traversal of the Binary Tree. 
 * Inorder Successor is NULL for the last node in Inoorder traversal.
 * 
 * In Binary Search Tree, 
 * Inorder Successor of an input node can also be defined as the node with the 
 * smallest key greater than the key of input node.
 * So, it is sometimes important to find next node in sorted order.
 *
 */
	
	static class Node{
		private int data;
		private Node left;
		private Node right;
		private Node parent;
		
		public Node(int data){
			this.data = data;
		}
		public Node(Node left, Node right, Integer data, Node parent){
			this.data = data;
			this.left = left;
			this.right = right;
			this.parent = parent;
		}
		@Override
		public String toString() {
			return this.data+"";
		}
	}
	
	
	static Node inOrderSuccessor(Node root, Node k){
		//1) If right subtree of node is not NULL, then succ lies in right subtree.
		//Go to right subtree and return the node with minimum key value in right subtree.
		
		if(k.right != null){
			return minValue(k.right);
		}
		
		//2) If right sbtree of node is NULL, then succ is one of the ancestors. 
		//Travel up using the parent pointer until you see a node which is left child of it’s parent.
		//The parent of such a node is the succ.
		Node parent = k.parent;
		//TODO :: Need to test second condition with full tree
		while((parent != null && parent.right != null)  && (k.data == parent.right.data)){
			k = parent;
			parent = parent.parent;
		}
		return parent;
	}
	
	static Node minValue(Node node){
		Node current = node;
		while(current.left != null){
			current = current.left;
		}
		return current;
	}
	
	public static void main(String[] args) {
		Node root = getBinaryTree4();
		Node temp = root.left.left;
		Node inS = inOrderSuccessor(root, temp);
		System.out.println(inS.data);
	}
	
/**	
		 	50
		 /    	 \
		 17       76
		/ 	\     /
	   9    23    54
		\	 /	    \
		14  19	     72
		/            / 
	   12    		67

*/	
	
	public static Node getBinaryTree4(){
		Node root = null;
		root = insert(root, 50);
		root = insert(root, 17);
		root = insert(root, 9);
		root = insert(root, 23);
		root = insert(root, 14);
		root = insert(root, 19);
		root = insert(root, 12);
		root = insert(root, 76);
		root = insert(root, 54);
		root = insert(root, 72);
		root = insert(root, 67);
		return root;
	}
	
	static Node insert(Node node, int data) {
	  /* 1. If the tree is empty, return a new, single node */
	  if (node == null)
	    return(new Node(data));
	  else {
	    Node temp = null; 
	    /* 2. Otherwise, recur down the tree */
	    if (data <= node.data) {   
	         temp = insert(node.left, data);
	         node.left  = temp;
	         temp.parent= node;
	    }else{
	        temp = insert(node.right, data);
	        node.right = temp;
	        temp.parent = node;
	    }   
	  
	    /* return the (unchanged) node pointer */
	    return node;
	  }
	} 
	
}
