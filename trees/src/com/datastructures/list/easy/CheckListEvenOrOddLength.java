package com.datastructures.list.easy;

import com.datastructures.list.LinkedList;
import com.datastructures.list.ListNode;
import com.datastructures.trees.util.Util;

public class CheckListEvenOrOddLength {

	// TC : O(n/2) ~ O(n) .. SC: O(1)
	static boolean checkIsEvenLength(ListNode head){
		if(head == null) return false;
		
		while(head != null && head.getNext() != null){
			head = head.getNext().getNext();
		}
		if(head == null){
		  return true;	
		}
		return false;
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
		boolean isEven = checkIsEvenLength(list.getHead());
		System.out.println(isEven);
	}	
	
}
