package com.datastructures.list.easy;

import java.util.HashMap;
import java.util.Map;

import com.datastructures.list.LinkedList;
import com.datastructures.list.ListNode;
import com.datastructures.trees.util.Util;

public class ConvergentORIntersentPoint {

	/*
	 *  1.find length of both the lists  .. o(n) + o(m) = o(max(m,n));
	 *  2.diff d of lengths O(1);
	 *  
	 *  3. make d steps to the longest list O(d).
	 *  4. compare the lists in parallel until links to next node match -- O(min(m,n));
	 *  total = O(max(m,n));
	 *  space is O(1)
	 *  
	 */
	static ListNode convergentPoint(ListNode head1, ListNode head2){
		if(head1 == null || head2 == null) return null;
		
		ListNode temp1 = head1, temp2 = head2;
		int len1 = length(temp1);
		int len2 = length(temp2);
		
		int diff = len1 - len2;
		
		if(len1 < len2){
			temp1 = head2;
			temp2 = head1;
			diff = len2-len1;
		}
		
		for (int i = 0; i < diff; i++) {
			temp1 = temp1.getNext();
		}
		
		while(temp1 != null && temp2 != null){
			if(temp1 == temp2){
				return temp1;
			}
			
			temp1 = temp1.getNext();
			temp2 = temp2.getNext();
		}
		
		
		
		
		
		
		
/*		if(head1 == null || head2 == null) return null;
		ListNode temp1 = head1, temp2 = head2;
		int len1 = length(temp1);
		int len2 = length(temp2);
		
		int diff = len1 - len2;
		//make head1 as larger list, which we want to compare the smaller one.
		if(len1 < len2){
			temp1 = head2;
			temp2 = head1;
			diff = len2 - len1;
		}
//		else{
//			temp1 = head1;
//			temp2 = head2;
//		}
		
		//make diff steps to the longest list
		for(int i=0; i<diff; i++){
			temp1 = temp1.getNext();
		}
		
		while(temp1 != null && temp2 != null){
			if(temp1 == temp2){
				return temp1;
			}
			temp1 = temp1.getNext();
			temp2 = temp2.getNext();
		}
*/	
		return null;
	}

	
	static int length(ListNode head){
		if(head == null) return 0;
		int size=0;
		ListNode temp = head;
		while(temp != null){
			size++;
			temp = temp.getNext();
		}
		return size;
	}

	static ListNode convergentPoint_set2(ListNode head1, ListNode head2){
		if(head1 == null || head2 == null) return null;
		Map<ListNode, Byte> map = new HashMap<>();
		byte val = 1;
		while(head1 != null || head2 != null){
			if(map.get(head1) != null){
				return head1;
			}else{
				map.put(head1, val);
			}
			
			if(map.get(head2) != null){
				return head2;
			}else{
				map.put(head2, val);
			}
			head1 = head1.getNext();
			head2 = head2.getNext();
		}
		return null;
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
		ListNode temp = list.getTail(); 
		list.insertAtEnd(100);
		list.insertAtEnd(110);
		list.insertAtEnd(120);
		list.insertAtEnd(130);
		
		LinkedList list2 = new LinkedList();
		list2.insertAtEnd(100);
		list2.insertAtEnd(200);
		list2.insertAtEnd(300);
		list2.insertAtEnd(400);
		list2.insertAtEnd(500);
		ListNode tail = list2.getTail();
		tail.setNext(temp);
		System.out.print("size : "+length(list.getHead())+" : ");
		Util.printList(list);
		System.out.print("size : "+length(list2.getHead())+" : ");
		Util.printList(list2);

		ListNode point = convergentPoint(list.getHead(), list2.getHead());
		System.out.println(point);
		
//		point = convergentPoint_set2(list.getHead(), list2.getHead());
//		System.out.println(point);
	}	
}
