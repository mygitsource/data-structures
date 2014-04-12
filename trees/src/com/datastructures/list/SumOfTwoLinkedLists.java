package com.datastructures.list;

import com.datastructures.trees.util.Util;

public class SumOfTwoLinkedLists {
	static int carry = 0;
	static ListNode sumOfTwoLinkedListsWithSameSize(ListNode head1, ListNode head2){
		if(head1 == null) return null;
		
		int sum  = 0;
		ListNode result = new ListNode();
		result.setNext(sumOfTwoLinkedListsWithSameSize(head1.getNext(), head2.getNext()));
		
		sum = head1.getData()+head2.getData()+carry;
		carry = sum/10;
		sum = sum%10;
		result.setData(sum);
		return result;
	}
	
	static void swapNodes(ListNode node1, ListNode node2){
		ListNode tmp = node1;
		node1 = node2;
		node2 = tmp;
	}

	static void addCarryToRemaining(ListNode head1, ListNode current, LinkedList result){
		int sum = 0;
		if(head1 != current){
			addCarryToRemaining(head1.getNext(), current, result);
			sum = head1.getData()+carry;
			carry = sum/10;
			sum = sum%10;
			result.insertAtBegin(sum);
		}
		
	}
	
	static void addTwoLists(ListNode head1, ListNode head2, LinkedList result){
		ListNode current;
		
		if(head1 == null){
			result.setHead(head2);
		}else if(head2 == null){
			result.setHead(head1);
		}
		
		int len1 = Util.size(head1);
		int len2 = Util.size(head2);
		
		int diff = Math.abs(len1 - len2);
		
		if(len1 < len2){
			swapNodes(head1, head2);
		}
		
		for(current = head1; diff-- > 0; current = current.getNext());
		
		ListNode res = sumOfTwoLinkedListsWithSameSize(current, head2);
		result.setHead(res);
		addCarryToRemaining(head1, current, result);
		if(carry > 0){
			result.insertAtBegin(carry);
		}
	}
	
	
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.insertNode(1);	
		list.insertNode(0);
		list.insertNode(0);
		list.insertNode(0);
		LinkedList list2 = new LinkedList();
		list2.insertNode(7);
		list2.insertNode(6);
		list2.insertNode(5);
		LinkedList result = new LinkedList();
		addTwoLists(list.getHead(), list2.getHead(), result);
		Util.printList(result);
	}
}
