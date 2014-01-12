package com.datastructures.list;

import com.datastructures.trees.util.Util;

/*
 * source : 1->2->3->4->5->6->7
 * convert to  : 2->1->4->3->6->5->7
 * 
 * changing links is a better then swapping. if we have more nodes, there will be lot of swaps.
 *  
 */

public class ReverseLinkedListInPairs {
					//next		   next
	//prev  current  prev  current prev  current	   
	//1 -->  2   -->   3 --> 4 -->   5 --> 6  --> 7
/*	
 *  next = curr.next;
	current.next = prev
	prev.next = next.next
	prev = next
	current = prev.next
*/	void reverseLinkedListInPairs(LinkedList list){
		ListNode head = list.getHead();
		//empty or single node list
		if(head == null || head.getNext() == null) return;
		
		//current and temp
		ListNode prevNode = head;
		// node 2 (example)
		ListNode current = head.getNext();
		
		head = current; //2
		list.setHead(head);
		System.out.println("PrevNode: "+prevNode+"  Curr : "+current);
		while(true){
			//example: next : 3 current: 2
			ListNode nextNode = current.getNext();
			current.setNext(prevNode);		// set 2 to 1
			
			if(nextNode == null || nextNode.getNext() == null){
				prevNode.setNext(nextNode);
				break;
			}
			
			prevNode.setNext(nextNode.getNext());
			prevNode = nextNode;
			current = prevNode.getNext();
			System.out.println("PrevNode: "+prevNode+"  Curr : "+current);
		}
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.insertNode(10);
		list.insertNode(20);
		list.insertNode(30);
		list.insertNode(40);
		list.insertNode(50);
		list.insertNode(60);
		list.insertNode(70);
		list.insertNode(80);
		
		Util.printList(list);
		
		ReverseLinkedListInPairs linkedListInPairs = new ReverseLinkedListInPairs();
		linkedListInPairs.reverseLinkedListInPairs(list);
		Util.printList(list);
	}
}
