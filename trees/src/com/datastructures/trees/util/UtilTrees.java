package com.datastructures.trees.util;

import com.datastructures.trees.Node;

public class UtilTrees {
/*	
			      1
			    /   \
			   2     3
			 /      /  \  
			4      5    6
			       \     \
			        7     8
			       /       \
			      9         10
			      
*/      
	public static Node getBinaryTree1(){
		Node root = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		Node node7 = new Node(7);
		Node node8 = new Node(8);
		Node node9 = new Node(9);
		Node node10 = new Node(10);
		
		root.setLeft(node2);
		root.setRight(node3);
		node2.setLeft(node4);
		node3.setLeft(node5);
		node3.setRight(node6);
		node5.setRight(node7);
		node6.setRight(node8);
		node7.setLeft(node9);
		node8.setRight(node10);
		
//		Node test = new Node(100);
//		node9.setRight(test);
		return root;
	}

/*	
		    1
		  /   \
		 2     3
		/      / \  
		4      5  6
		       \   \
		      7     8
		     /       \
		    9         11
		    		 /	\
    				10	12
*/      
	
	public static Node getBinaryTree2(){
		Node root = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		Node node7 = new Node(7);
		Node node8 = new Node(8);
		Node node9 = new Node(9);
		Node node10 = new Node(10);
		Node node11 = new Node(11);
		Node node12 = new Node(12);
		
		root.setLeft(node2);
		root.setRight(node3);
		node2.setLeft(node4);
		node3.setLeft(node5);
		node3.setRight(node6);
		node5.setRight(node7);
		node6.setRight(node8);
		node7.setLeft(node9);
		node8.setRight(node11);
		node11.setRight(node12);
		node11.setLeft(node10);
		
		return root;
	}
		/*
					 	1 
				     /      \
				    2        3
				  /   \     /  \
				 4     5   6    7
				/ \    /       /
				8   9  12      10
				  / \           \
				 13  14         11
				     / 
				    15 
		*/
	public static Node getBinaryTree3(){
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		Node node7 = new Node(7);
		Node node8 = new Node(8);
		Node node9 = new Node(9);
		Node node10 = new Node(10);
		Node node11 = new Node(11);
		Node node12 = new Node(12);
		Node node13 = new Node(13);
		Node node14 = new Node(14);
		Node node15 = new Node(15);

		node1.setLeft(node2);
		node1.setRight(node3);
		node2.setLeft(node4);
		node2.setRight(node5);
		node4.setLeft(node8);
		node4.setRight(node9);
		node9.setLeft(node13);
		node9.setRight(node14);
		node14.setLeft(node15);
		node5.setLeft(node12);
		node3.setLeft(node6);
		node3.setRight(node7);
		node7.setLeft(node10);
		node10.setRight(node11);
		
		return node1;
		
	}

/**	
	 	50
     /    	 \
    17         76
   / 	 \     /
  9      23    54
   \	  /	    \
    14  19	     72
    /            / 
   12    		67
   
*/	
	
	public static Node getBinaryTree4(){
		Node node50 = new Node(50);
		Node node17 = new Node(17);
		Node node9 = new Node(9);
		Node node14 = new Node(14);
		Node node12 = new Node(12);
		Node node23 = new Node(23);
		Node node19 = new Node(19);
		Node node76 = new Node(76);
		Node node54 = new Node(54);
		Node node72 = new Node(72);
		Node node67 = new Node(67);
		
		node50.setLeft(node17);
		node50.setRight(node76);
		node17.setLeft(node9);
		node17.setRight(node23);
		node9.setRight(node14);
		node14.setLeft(node12);
		node23.setLeft(node19);
		
		node76.setLeft(node54);
		node54.setRight(node72);
		node72.setLeft(node67);
		
		return node50;
	}
	
	
/**
*
		   12
	     /    \
	   5       7       
	 /          \ 
	3            1

*/
	
	public static Node getBinaryTree5(){
		Node node12 = new Node(12);
		Node node5 = new Node(5);
		Node node3 = new Node(3);
		Node node7 = new Node(7);
		Node node1 = new Node(1);

		node12.setLeft(node5);
		node12.setRight(node7);
		node5.setLeft(node3);
		node7.setRight(node1);

		return node12;
		
	}

	public static Node getBinaryTree6(){
		Node node25 = new Node(25);
		Node node12 = new Node(12);
		Node node30 = new Node(30);
		Node node10 = new Node(10);
		Node node36 = new Node(36);
		Node node15 = new Node(15);
		
		node10.setLeft(node12);
		node10.setRight(node15);
		
		node12.setLeft(node25);
		node12.setRight(node30);
		node15.setLeft(node36);
		
		return node10;
		
	}

	/*
	 			1 
	 		/      \
		   2        3
		 /   \     /  \
		4     5   6    7
	   / \    /       /
	  8   9  12      10
	
*/	

		
	public static Node getBinaryTree7(){
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		Node node7 = new Node(7);
		Node node8 = new Node(8);
		Node node9 = new Node(9);
		Node node10 = new Node(10);
		Node node12 = new Node(12);
		
		node1.setLeft(node2);
		node1.setRight(node3);
		node2.setLeft(node4);
		node2.setRight(node5);
		node4.setLeft(node8);
		node4.setRight(node9);
		node5.setLeft(node12);
		node3.setLeft(node6);
		node3.setRight(node7);
		node7.setLeft(node10);
		
		return node1;
	
	}
	
	
}
