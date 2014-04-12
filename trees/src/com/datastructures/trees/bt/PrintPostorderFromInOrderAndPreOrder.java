package com.datastructures.trees.bt;

import com.datastructures.trees.util.Util;
import com.datastructures.trees.util.UtilTrees;

/*
 * We can print postorder traversal without constructing the tree. 
 	The idea is, root is always the first item in preorder traversal and 
 	it must be the last item in postorder traversal. 
  	
  	We first recursively print left subtree, 
    then recursively print right subtree. Finally, print root.
     
 *  To find boundaries of left and right subtrees in pre[] and in[], 
 	we search root in in[], all elements before root in in[] are elements of left subtree and 
 	all elements after root are elements of right subtree.
 	 
 *  In pre[], all elements after index of root in in[] are elements of right subtree. 
 *  And elements before index (including the element at index and excluding the first element) 
 * are elements of left subtree.
 * 
 * Input:
	Inorder traversal in[] = {4, 2, 5, 1, 3, 6}
	Preorder traversal pre[] = {1, 2, 4, 5, 3, 6}

	Output:
	Postorder traversal is {4, 5, 2, 6, 3, 1}
	//0,2,1,5,4,3
*/

// This is without building a tree , print post order
//XXX: not working..
public class PrintPostorderFromInOrderAndPreOrder {
	
	static int preIndex = 0;

	static void printPostorderFromInOrderAndPreOrder(int inorder[], int preorder[], int start, int end){
		int data = inorder[preIndex];
		preIndex++;
		int root = getIndexOfX(inorder, data, start, end);
		if(root != start){
			printPostorderFromInOrderAndPreOrder(inorder, preorder, start, root);
		}
		if(root != end){
			printPostorderFromInOrderAndPreOrder(inorder, preorder, start, end-root);
		}
			
		System.out.println(preorder[preIndex]);
		
	}

	public static void main(String[] args) {
	int []preOrder = new int[]{50, 17, 9, 14, 12, 23, 19, 76, 54, 72, 67};
	int []inOrder = new int[]{9, 12, 14, 17, 19, 23, 50, 54, 67, 72, 76 };
//	12 14 9 19 23 17 67 72 54 76 50
	
	printPostorderFromInOrderAndPreOrder(inOrder, preOrder, 0, inOrder.length -1);
		
	}

	
	private static int getIndexOfX(int array[], int x, int start, int end){
		for( ; start <= end; start++) {
			if(array[start] == x){
				return start;
			}
		}
		return -1;
	}
	
}
