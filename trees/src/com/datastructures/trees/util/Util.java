package com.datastructures.trees.util;

import java.util.Queue;
import java.util.Stack;

import com.datastructures.list.LinkedList;
import com.datastructures.list.ListNode;
import com.datastructures.trees.Node;
import com.datastructures.trees.Traversal;

public class Util {
	
	public static void main(String[] args) {
//		postOrderTraversalMethod1(UtilTrees.getBinaryTree1());	
		postOrderTraversal(UtilTrees.getBinaryTree1());
//		printTree(UtilTrees.getBinaryTree1(), Traversal.POSTORDER);
	}
	
	public static void postOrderTraversalTwoStack(Node root){
		Stack stack1 = new Stack<>();
		Stack stack2 = new Stack<>();
		stack1.push(root);
		while (!stack1.empty()) {
			Node node = (Node) stack1.pop();
			stack2.push(node);
			
			if(node.getLeft() != null){
				stack1.push(node.getLeft());
			}
			if(node.getRight() != null){
				stack1.push(node.getRight());
			}
		}
	
		while (!stack2.isEmpty()) {
			System.out.println(stack2.pop());
		}
	}
	
	/**
	 * 1. push all the left nodes to the stack.
	 * 2. pop the node, when the right is null, because we don't need this node.
	 * 3. if the node is the right child of the stack's peek then remove the top. Which means traversing back from right sub tree.
	 * 4. end of the look : start traversing right subtree.
	 */
	public static void postOrderTraversalMethod1(Node root){
		if(root == null) return;
		Stack<Node> stack = new Stack<>();
		while(true){
			// push all the left nodes to the stack.
			while(root != null){
				stack.push(root);
				root = root.getLeft();
			}
			//pop the node, when the right is null, because we don't need this node.
			if((!stack.isEmpty()) && stack.peek().getRight() == null){
				root = stack.pop();
				System.out.println(root);
				//if the node is the right child of the stack's peek then remove the top. Which means traversing back from right sub tree.
				while ((!stack.empty()) && stack.peek().getRight() !=null && stack.peek().getRight().getData() == root.getData()) {
					root = stack.pop();
					System.out.println(root);
				}
			}
			
			root = (stack.isEmpty()? null: stack.peek().getRight());
			if(root == null && stack.isEmpty()){
				break;
			}			
			
		}
		
	}
	
	/**
	 * http://www.geeksforgeeks.org/iterative-postorder-traversal-using-stack/
	 * The idea is to move down to leftmost node using left pointer. 
	 * While moving down, push root and root’s right child to stack. 
	 * Once we reach leftmost node, print it if it doesn’t have a right child. 
	 * If it has a right child, then change root so that the right child is processed before
	 * 
	 * 	 -------  LRD	----------
	 * 			1
	 * 		 /	    \
	 * 		2		 3
	 * 	   / \     /  \
	 * 	  4	  5	  6	   7
	 * 
	 *	1. Right child of 1 exists.
	 *	   Push 3 to stack. Push 1 to stack. Move to left child.
	 *     Stack: 3, 1
	 *  2. Right child of 2 exists.
	 *     Push 5 to stack. Push 2 to stack. Move to left child.
	 *     Stack: 3, 1, 5, 2
	 *  3. Right child of 4 doesn't exist. '
	 *     Push 4 to stack. Move to left child.
	 *     Stack: 3, 1, 5, 2, 4
	 *  4. Current node is NULL.
	 *     Pop 4 from stack. Right child of 4 doesn't exist.
	 *     Print 4. Set current node to NULL.
	 *     Stack: 3, 1, 5, 2
	 *  5. Current node is NULL.
	 *     Pop 2 from stack. Since right child of 2 equals stack top element,
	 *     pop 5 from stack. Now push 2 to stack.
	 *     Move current node to right child of 2 i.e. 5
	 *     Stack: 3, 1, 2
	 *     
	 * postOrder traversal without recursion
	 */
	public static void postOrderTraversal(Node root){
		if(root == null) return;
		Stack<Node> stack = new Stack<>();
		
		while(true){
			while(root != null){
				if(root.getRight() != null){
					stack.push(root.getRight());
				}
				stack.push(root);
				root = root.getLeft();
			}
			if(stack.isEmpty())break;
			
			root = stack.pop();
			//check that, the item on stack is the right child root. then remove right child and push the root.
			if((!stack.isEmpty()) && root.getRight() != null && (stack.peek().getData() == root.getRight().getData())){
				stack.pop(); //remove right child
				stack.push(root);
				root = root.getRight();
			}else{
				System.out.println(root.getData());
				root = null;
			}
		}
		
	}
	
	/**
	 * 		LDR
	 * inorder traversal without recursion
	 * @param root
	 */
	public static void inOrderTraversal(Node root){
		if(root == null) return;
		Stack stack = new Stack();
		while(true){
			while(root != null){
				stack.push(root);
				root = root.getLeft();
			}
			if(stack.isEmpty())break;
			root = (Node)stack.pop();
			System.out.println(root.getData());
			root = root.getRight();
		}
			
	}
	
	
	/**
	 * 	DLR
	 * preorder without recursion. 
	 * @param root
	 */
	public static void preOrderTraversal(Node root){
		if(root == null) return;
		Stack stack = new Stack();
		while(true){
			while(root != null){
				System.out.println(root.getData());
				stack.push(root);
				root = root.getLeft();
			}
			if(stack.empty())break;
			
			root = (Node)stack.pop();
			root = root.getRight();
		}
	}
	
	
	public static void printList(LinkedList node){
		ListNode temp = node.getHead();
		while(temp != null){
			System.out.print(temp);
			temp = temp.getNext();
			if(temp != null){
				System.out.print("->");
			}
		}
		System.out.println("\n");
	}
	
	public static void printInOrderTraversal(Node node){
		printTree(node, Traversal.INORDER);
		System.out.println();
	}
	public static void printPostOrderTraversal(Node node){
		printTree(node, Traversal.POSTORDER);
		System.out.println();
	}
	public static void printPreOrderTraversal(Node node){
		printTree(node, Traversal.PREORDER);
		System.out.println();
	}
	public static void printTree(Node node, Traversal traversal){
		if(node == null) return;
		if(traversal == Traversal.PREORDER)
			System.out.print(node.getData()+" ");
		printTree(node.getLeft(), traversal);
		if(traversal == Traversal.INORDER)		
			System.out.print(node.getData()+" ");
		printTree(node.getRight(), traversal);
		if(traversal == Traversal.POSTORDER)
			System.out.print(node.getData()+" ");
	}
	
	public static  int height(Node node){
		if(node == null) return 0;
		
		int lHeight = height(node.getLeft());
		int rHeight = height(node.getRight());
		
		if(lHeight > rHeight){
			return lHeight+1;
		}else{
			return rHeight+1;
		}
	}
	
	/**
	 * Level order traversal using queue
	 * @param node
	 */
	public static  void levelOrderTraversal(Node node){
		if(node == null) return;
		Queue<Node> queue = new java.util.LinkedList<>();
		queue.add(node);
		while(!queue.isEmpty()){
			Node temp = queue.poll();
			System.out.print(temp.getData()+" ");
			if(temp.getLeft() != null){
				queue.add(temp.getLeft());
			}
			if(temp.getRight() != null){
				queue.add(temp.getRight());
			}
		}
		System.out.println();
	}
	
	/**
	 * level order traversal using height
	 * @param node
	 */
	public static  void levelOrderTraversalUsingHeight(Node node){
		int height = height(node);
		for(int i =1; i <= height; i++){
			levelOrderTraversal(node, i);
			System.out.print("\n");
		}
	}
	
	/**
	 * print the nodes at given level.
	 * @param node
	 * @param level
	 */
	
	public static  void levelOrderTraversal(Node node, int level){
		if(node == null) return;
		if(level == 1){
			System.out.print(node);
		}else{
			levelOrderTraversal(node.getLeft(), level-1);
			levelOrderTraversal(node.getRight(), level-1);
		}

	}

	
}
