package com.datastructures.stack;

import java.util.Stack;


public class ReverseStack {

	
	static void reverseStack(Stack stack){
		if(stack.isEmpty()) return;
		int temp = (int)stack.pop();
		reverseStack(stack);
		insertAtBottom(stack, temp);
	}
	
	static void insertAtBottom(Stack stack, int data){
		
		if (stack.isEmpty()){
			stack.push(data);
			return;
		}
		
		int temp = (int)stack.pop();
		insertAtBottom(stack, data);
		stack.push(temp);
	}
	
	public static void main(String[] args) {
		Stack stack = new Stack<>();
		for(int i=0; i < 10; i++){
			stack.push(i);
		}
		while(!stack.isEmpty())
			System.out.print(stack.pop());
		System.out.println("\n");
		reverseStack(stack);
		while(!stack.isEmpty())
			System.out.print(stack.pop());
	
	}
}
