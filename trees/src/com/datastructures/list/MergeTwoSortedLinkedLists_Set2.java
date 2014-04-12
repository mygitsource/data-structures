package com.datastructures.list;

import com.datastructures.sort.MergeSort;

public class MergeTwoSortedLinkedLists_Set2 {

	static ListNode mergeTwoSortedLinkedLists(LinkedList list1, LinkedList list2){
		ListNode head1 = list1.getHead();
		ListNode head2 = list2.getHead();
		
		if(head1 == null) return head2;
		if(head2 == null) return head1;
		
		ListNode current = head1;
		ListNode temp = head2;
		ListNode prev = head2;
		//TODO : need to finish
		while(current != null){
			while(temp != null){
				if(current.getData() < temp.getData()){
					list2.insertAt(current.getData(), prev);
					break;
				}
				prev = temp;
				temp = temp.getNext();
			}
			current = current.getNext();
		}		
		return head2;
		
	}
	
	
	static void insertAtEnd(LinkedList list, int data){
		list.addNext(data);
	}
	
	
	public static void main(String[] args) {
		LinkedList list = getLinkedList1(1);
		LinkedList list2 = getLinkedList1(0);
		ListNode temp = mergeTwoSortedLinkedLists(list2, list);
		
		while(temp != null){
			System.out.print(temp);
			temp = temp.getNext();
			if(temp != null){
				System.out.print("->");
			}
		}
		System.out.print("\n");
	}
	
	public static LinkedList getLinkedList1(int even){
		LinkedList likedList  = new LinkedList();
		for (int i = 0; i < 11; i++) {
			if(i%2 == even)
				likedList.addNext(i);
		}
		return likedList;
	}	
	
}
