package com.datastructures.list.easy;

import com.datastructures.list.LinkedList;

public class StackUsingList {

	static class Stack{
		LinkedList  list = new LinkedList();
		
		void push(int data){
			list.insertNode(data);
		}
		
		int pop(){
			return list.pop();
		}
		
		int size(){
			return list.size();
		}
	}
	
	public static void main(String[] args) {
		Stack stack = new Stack();
		int x = 10;
		while(x > 0){
			stack.push(--x);
			System.out.print(x+" ");
		}
		System.out.println();
		while(stack.size() != 0){
			System.out.print(stack.pop()+" ");
		}
	}
}
