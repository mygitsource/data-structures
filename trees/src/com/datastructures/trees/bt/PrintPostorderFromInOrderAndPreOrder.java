package com.datastructures.trees.bt;

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

	private static int printPostorderFromInOrderAndPreOrder(int inorder[], int preorder[], int start, int end){
		if(start > end){
			return -1;
		}
		int data = inorder[preIndex];
		preIndex++;
		if(start == end){
			System.out.println(data);
			return data;
		}else{
			int inInd = getIndexOfX(inorder, data, start, end);
			printPostorderFromInOrderAndPreOrder(inorder, preorder, start, inInd -1);
			printPostorderFromInOrderAndPreOrder(inorder, preorder, inInd +1, end);
			System.out.println(inorder[inInd]);
			return data;
		}
		
	}

	public static void main(String[] args) {
		int inOrder[] = {4, 2, 5, 1, 3, 6};
		int preOrder[] = {1, 2, 4, 5, 3, 6};
		printPostorderFromInOrderAndPreOrder(inOrder, preOrder, 0, 5);
		
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
