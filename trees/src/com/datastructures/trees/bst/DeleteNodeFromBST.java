package com.datastructures.trees.bst;

import com.datastructures.trees.Node;
import com.datastructures.trees.util.Util;
import com.datastructures.trees.util.UtilTrees;

public class DeleteNodeFromBST {

	/*
	 * 1. check if the key is less then the root, then it exists in left subtree
	 * 2. check if the key is greater then the root, then it exists in right subtree
	 * 
	 * 3. if it is equal,
	 *    1. check if left child exists, if not delete the node and return right node.
	 *    2. check if right child exists, if not delete the node and return left node.
	 *    
	 *    3. if the node comes with left & right child, get the inorder successor which is smallest in right subtree.
	 *       Copy the data root and delete the inorder successor. 
	 */
	static Node deleteLeafNode(Node root, int k){
		if(root == null) return null;
		
		//If the key to be deleted is smaller than the root's key,
	    //then it lies in left subtree
		if(k < root.getData()){
			root.setLeft(deleteLeafNode(root.getLeft(), k));
			
		}else if (k > root.getData()){
			root.setRight(deleteLeafNode(root.getRight(), k));
		}else{
			// node with only one child or no child
			if(root.getLeft() == null){
				Node temp = root.getRight();
				root.setData(null);
				root = null;
				return temp;
			}else if (root.getRight() == null){
				Node temp = root.getLeft();
				root.setData(null);
				root = null;
				return temp;
			}
			//node with two childern
			//Get the inorder successor (smallest in the right subtree)
			Node temp = minValue(root.getRight());
			root.setData(temp.getData());
			root.setRight(deleteLeafNode(root.getRight(),temp.getData()));
		}
		return root;
	}
	
	static Node minValue(Node root){
		Node current = root;
		while(current.getLeft() != null){
			current = current.getLeft();
		}
		return current;
	}

	public static void main(String[] args) {
		Node root = UtilTrees.getBinaryTree4();
		Util.printInOrderTraversal(root);
		root = deleteLeafNode(root, 17);
		Util.printInOrderTraversal(root);
		
		
	}
}
