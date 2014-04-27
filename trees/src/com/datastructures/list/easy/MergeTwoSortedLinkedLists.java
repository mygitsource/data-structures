package com.datastructures.list.easy;

import com.datastructures.list.LinkedList;
import com.datastructures.list.ListNode;
import com.datastructures.trees.util.Util;

public class MergeTwoSortedLinkedLists {
	
	static ListNode mergeSortedLists_set2(ListNode head1, ListNode head2){
		ListNode result = null;
		if(head1 == null) return head2;
		if(head2 == null) return head1;
		
		if(head1.getData() <= head2.getData()){
			result = head1;
			result.setNext(mergeSortedLists_set2(head1.getNext(), head2));
		}else {
			result = head2;
			result.setNext(mergeSortedLists_set2(head1, head2.getNext()));
		}
		return result;
		
	}
	
	static ListNode mergeSortedLists_set1(ListNode head1, ListNode head2){
		if(head1 == null) return head2;
		if(head2 == null) return head1;
		LinkedList list = new LinkedList();
		
		while(head1 != null && head2 != null){
			if(head1.getData() < head2.getData()){
				list.insertAtEnd(head1.getData());
				head1 = head1.getNext();
			}else {
				list.insertAtEnd(head2.getData());
				head2 = head2.getNext();
			}
		}
		if(head1 != null){
			while(head1 != null){
				list.insertAtEnd(head1.getData());
				head1 = head1.getNext();
			}
			
		}
		
		if(head2 != null){
			while(head2 != null){
				list.insertAtEnd(head2.getData());
				head2 = head2.getNext();
			}
		}
		
		return list.getHead();
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
		
		LinkedList list3 = new LinkedList();
		list3.insertAtEnd(15);
		list3.insertAtEnd(25);
		list3.insertAtEnd(35);
		list3.insertAtEnd(45);
		list3.insertAtEnd(55);
		list3.insertAtEnd(65);
		
		Util.printList(list3);
		
		ListNode head = mergeSortedLists_set1(list.getHead(), list3.getHead());
		
		Util.printListNode(head);

		
	}	

}
