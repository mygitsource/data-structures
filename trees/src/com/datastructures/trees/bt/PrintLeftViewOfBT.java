package com.datastructures.trees.bt;

import java.util.Queue;
import java.util.logging.Level;

import com.datastructures.list.LinkedList;
import com.datastructures.trees.Node;
import com.datastructures.trees.util.UtilTrees;

/**
 * Given a Binary Tree, print left view of it. Left view of a Binary Tree
 * is set of nodes visible when tree is visited from left side. 
 * Left view of following tree is 12, 10, 25.
 *  	 	50
       /    	 \
      17       	  76
     / 	 \        /
    9      23    54
     \	   /	   \
      14  19	   72
      /            / 
     12    		  67
     
Left View: 50, 17, 9, 14, 12
Right View: 50 76, 54, 72, 67     	
          
*/
public class PrintLeftViewOfBT {
//	http://www.geeksforgeeks.org/boundary-traversal-of-binary-tree/
	private static int maxLevel = 0;
	private static void printLeftView(Node root, int level){
		Node temp = null;
		if(root == null)
			return;
		if(maxLevel < level){
			maxLevel= level;
//			System.out.println("left: "+root.getData());
		}

		printLeftView(root.getLeft(), level+1);
		printLeftView(root.getRight(), level+1);
	}
	
	/*
	 *  works for both leftview and rightview. 
	 */
	private static void printLeftViewInLevelOrder(Node root){
		if(root == null) return;
		Queue<Node> queue = new java.util.LinkedList<>();
		queue.add(root);
		queue.add(null);
		Node prev = null;
		int level = 1;
		int maxLevel = 0;
		while (!queue.isEmpty()) {
			Node temp = queue.poll();
			
			if(temp != null && maxLevel < level){
				maxLevel = level;
				//System.out.println("left : "+temp.getData());
			}
			
			if(temp == null){
				if(prev!= null)
					System.out.println("right : "+prev.getData());
				level = level+1;
				if(!queue.isEmpty()){
					queue.add(null);
				}
			}else{
				if(temp.getLeft() != null)
					queue.add(temp.getLeft());
				if(temp.getRight() != null)
					queue.add(temp.getRight());
			}
			prev = temp;
		}
	}
	
	public static void main(String[] args) {
		Node root = UtilTrees.getBinaryTree4();
			
		printLeftView(root, 1);
		//printLeftViewInLevelOrder : works both left/right view and tested.
		//printLeftViewInLevelOrder(root);
	}
}
