package com.datastructures.list.easy;

import com.datastructures.list.LinkedList;
import com.datastructures.list.ListNode;
import com.datastructures.trees.util.Util;

public class MiddleOfLinkedList {

	static ListNode middleOfList(ListNode head){
		if(head == null) return null;
		
		ListNode ptr1x = head;
		ListNode ptr2x = head;

		while(ptr2x != null){
			ptr2x = ptr2x.getNext();
			if(ptr2x != null){
				ptr2x = ptr2x.getNext();
				ptr1x = ptr1x.getNext();
			}
			
		}
		
/*		int i = 1;
		while(ptr2x != null){
			if(i == 1){
				ptr2x = ptr2x.getNext();
				i--;
			}else if(i==0){
				ptr2x = ptr2x.getNext();
				ptr1x = ptr1x.getNext();
				i++;
			}
		}
*/		
		
		return ptr1x;
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
		ListNode node = middleOfList(list.getHead());
		System.out.println(node);
	}	
	
}
