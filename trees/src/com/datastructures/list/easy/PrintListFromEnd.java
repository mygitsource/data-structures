package com.datastructures.list.easy;

import com.datastructures.list.LinkedList;
import com.datastructures.list.ListNode;
import com.datastructures.trees.util.Util;

public class PrintListFromEnd {

	//print list in reverse
	static void printListFromEnd(ListNode head ){
		if(head == null) return;
		
		printListFromEnd(head.getNext());
		System.out.print(head+"->");
	}
	
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.insertAtEnd(10);
		list.insertAtEnd(20);
		list.insertAtEnd(30);
		list.insertAtEnd(40);
		list.insertAtEnd(50);
		list.insertAtEnd(60);
		list.insertAtEnd(70);
		list.insertAtEnd(80);
		list.insertAtEnd(90);
		Util.printList(list);
		printListFromEnd(list.getHead());
	}	
	
}
