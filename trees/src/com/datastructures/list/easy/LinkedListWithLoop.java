package com.datastructures.list.easy;

import com.datastructures.list.LinkedList;
import com.datastructures.list.ListNode;

public class LinkedListWithLoop {

	static int findCycle(ListNode head){
		if(head == null) return -1;
		boolean loopExisted = false;
		
		ListNode slow = head;
		ListNode fast = head;
		while(fast != null){
			fast = fast.getNext();
			if(fast != null)
				fast = fast.getNext();
			slow = slow.getNext();

			if(fast == slow){
				loopExisted = true;
				break;
			}
			
		}
		
		if(slow == null || fast == null) return -1;
		if(loopExisted){
			int count = 1;
			slow = head;
			while(slow != fast){
				slow = slow.getNext();
				fast = fast.getNext();
				count++;
			}
			System.out.println("position : "+count);
		}
		
		return slow.getData();
		
	}
	
	
	static boolean checkForCycle(ListNode head){
		if(head == null) return false;
		ListNode sPtr1 = head;
		ListNode fPtr2 = head;
		int i = 1;
		while(sPtr1 != null || fPtr2 !=null){
			if(i%2 == 0){
				sPtr1 = sPtr1.getNext();
				i++;
			}else{
				i--;
			}
			fPtr2 = fPtr2.getNext();
			if(sPtr1 == fPtr2){
				return true;
			}
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
		ListNode temp = list.getTail();
		list.insertAtEnd(60);
		list.insertAtEnd(70);
		list.insertAtEnd(80);
		list.insertAtEnd(90);
		ListNode tail = list.getTail();
		tail.setNext(temp);
		//Util.printList(list);
		//boolean val = checkForCycle(list.getHead());
		int val = findCycle(list.getHead());
		System.out.println(val);
	}
	
}
