package com.datastructures.list;

import com.datastructures.trees.util.Util;


/*
	Linked List Before Sorting
	2  1  2  1  1  2  0  1  0
	Linked List After Sorting
	0  0  1  1  1  1  2  2  2

Method :1
	Traverse the list and count the number of 0s, 1s and 2s. Let the counts be n1, n2 and n3 respectively.
	Traverse the list again, fill the first n1 nodes with 0, then n2 nodes with 1 and finally n3 nodes with 2.

*
*/

public class SortALinkedListOf0s1sOr2s {

	static void sortALinkedListOf0s1sOr2s(ListNode head){
		if(head == null) return;
		int array[] = new int[3];
		ListNode tmp = head;
		while(tmp != null){
			array[tmp.getData()] += 1;
			tmp = tmp.getNext();
		}
		int i = 0;
		tmp = head;
		while(tmp != null){
			if(array[i] == 0){
				i++;
			}else{
				tmp.setData(i);
				--array[i];
				tmp = tmp.getNext();
			}
		}
	}
	
	
	public static void main(String[] args) {
		LinkedList likedList  = new LinkedList();
		likedList.insertNode(1);
		likedList.insertNode(0);
		likedList.insertNode(0);
		likedList.insertNode(2);
		likedList.insertNode(2);
		likedList.insertNode(2);
		likedList.insertNode(0);
		likedList.insertNode(0);
		likedList.insertNode(1);
		likedList.insertNode(1);
		sortALinkedListOf0s1sOr2s(likedList.getHead());
		Util.printList(likedList);
	}
}
