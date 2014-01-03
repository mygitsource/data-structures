package com.datastructures.trees.bt;

public class test {

	/* The main function that checks if two arrays a[] and b[] of size n construct
	  same BST. The two values 'min' and 'max' decide whether the call is made for
	  left subtree or right subtree of a parent element. The indexes i1 and i2 are
	  the indexes in (a[] and b[]) after which we search the left or right child.
	  Initially, the call is made for INT_MIN and INT_MAX as 'min' and 'max'
	  respectively, because root has no parent.
	  i1 and i2 are just after the indexes of the parent element in a[] and b[]. */
	
	static boolean isSameBST(int a[], int b[], int n, int i1, int i2, int min, int max) {
	   int j, k;
	 
	   /* Search for a value satisfying the constraints of min and max in a[] and
	      b[]. If the parent element is a leaf node then there must be some
	      elements in a[] and b[] satisfying constraint. */
	   for (j=i1; j<n; j++){
	       if (a[j]>min && a[j]<max){
	           break;
	       }
	   }
	   
	   for (k=i2; k<n; k++){
	       if (b[k]>min && b[k]<max){
	           break;
	       }
	   }
	   /* If the parent element is leaf in both arrays */
	   if (j==n && k==n){
		   return true;
	   }
	 
	   /* Return false if any of the following is true	      a) If the parent element is leaf in one array, but non-leaf in other.
	      b) The elements satisfying constraints are not same. We either search
	         for left child or right child of the parent element (decinded by min
	         and max values). The child found must be same in both arrays */
	   if (((j==n)^(k==n)) || a[j]!=b[k])
	       return false;
	 
	   /* Make the current child as parent and recursively check for left and right
	      subtrees of it. Note that we can also pass a[k] in place of a[j] as they
	      are both are same */
	   return isSameBST(a, b, n, j+1, k+1, a[j], max) &&  // Right Subtree
	          isSameBST(a, b, n, j+1, k+1, min, a[j]);    // Left Subtree
	}
	
	/*
      		8
         /    \
       3       10
     /  \        \
    1     6       14
        /   \     /
       4     7   13  
       	
		 int a[] = {8, 3, 6, 1, 4, 7, 10, 14, 13};
		 int b[] = {8, 10, 14, 3, 6, 4, 1, 7, 13};
       	
	 */
	
	
	public static void main(String[] args) {
		 int a[] = {8, 3, 6, 1, 4, 7, 10, 14, 13};
		 int b[] = {8, 10, 14, 3, 6, 4, 1, 7, 13};
		 
		 boolean res = isSameBST(a, b, 9, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
		 System.out.println("result: "+res);
	}
	
}