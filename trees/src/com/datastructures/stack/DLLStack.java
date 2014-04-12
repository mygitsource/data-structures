package com.datastructures.stack;

import com.datastructures.list.DLLNode;
import com.datastructures.list.DoubleLinkedList;

public class DLLStack {

	DLLNode mid;
	
	DoubleLinkedList linkedList = new DoubleLinkedList();

	/*
	 * insert element at begin
	 * if count == 1 mid = head
	 * otherwise
	 * if count is odd 
	 * 	mid = mid.getPrevv
	 */
	void push(int data){
		linkedList.insertFirst(data);
		int count = linkedList.getSize();
		if(count == 1){
			mid = linkedList.getHead();
		}else{
			if(count%2 == 1){
				mid = mid.getPrev();
			}
		}
	}
	
	int findMiddle(){
		int count = linkedList.getSize();
		if(count == 0){
			return -1;
		}
		return mid.getData();
	}

	/*
	 * retrieve head from Dll.
	 * set head to head.next
	 * adjust the size
	 * if count is event
	 * 	mid = mid.next;
	 */
	
	int pop(){
		if(linkedList.getSize() == 0) return -1;
		DLLNode head = linkedList.getHead();
		int data = head.getData();
		linkedList.SetHead(head.getNext());
		linkedList.setSize(linkedList.getSize() -1);
		int count = linkedList.getSize();
		if(count%2 == 0){
			mid = mid.getNext();
		}

		return data;
	}
	
	
	public static void main(String[] args) {
		DLLStack stack = new DLLStack();
		for(int i =0; i < 10; i++)
			stack.push(i+1);

		System.out.println(stack.findMiddle());
		System.out.println(stack.pop());

		System.out.println(stack.findMiddle());
		System.out.println(stack.pop());

		System.out.println(stack.findMiddle());
		System.out.println(stack.pop());

		System.out.println(stack.findMiddle());
		System.out.println(stack.pop());

	}
	
	
}
