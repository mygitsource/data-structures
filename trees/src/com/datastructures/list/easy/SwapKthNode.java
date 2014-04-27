package com.datastructures.list.easy;

import com.datastructures.list.LinkedList;
import com.datastructures.list.ListNode;
import com.datastructures.trees.util.Util;

public class SwapKthNode {

	static void swapKthNode(ListNode head, int k){
		if(head == null) return;
		int len = length(head);
		if(k > len || k < 1) return;
		
		int to = (len-k);
		k = k-1;
		if(k == to) return;		
		ListNode temp = head;
		ListNode node1=null, node1Prv = null, node2 = null, node2Prv = null;
		
		int location = 1;
		while(temp != null){
			
			if(location == k) {
				node1Prv = temp;
				node1 = temp.getNext();
			}
				
			if(location == to){
				node2Prv = temp;
				node2 = temp.getNext();
			}
			location++;
			temp = temp.getNext();
		}
		
		ListNode nextNode2 = node2.getNext();
		node1Prv.setNext(node2);
		node2.setNext(node1.getNext());
		
		node2Prv.setNext(node1);
		node1.setNext(nextNode2);
		
		System.out.println(len+" "+k+" "+to);
	}
	
	static int length(ListNode head){
		int size = 1;
		ListNode temp = head.getNext();
		while(temp != null){
			size++;
			temp = temp.getNext();
		}
		return size;
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
		swapKthNode(list.getHead(),1);
		Util.printList(list);
	}		
}
