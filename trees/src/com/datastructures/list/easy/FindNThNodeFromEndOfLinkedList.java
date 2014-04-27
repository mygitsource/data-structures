package com.datastructures.list.easy;

import com.datastructures.list.ListNode;
import com.datastructures.trees.util.Util;
import com.datastructures.trees.util.UtilList;

public class FindNThNodeFromEndOfLinkedList {

	static int findNthNode(ListNode head, int k){
		if(head == null) return -1;
		
		ListNode node1 = head;
		ListNode node2 = head;
		int count = 0;
		while(node2 != null){
			count++;
			if(k - count < 0){
				node1 = node1.getNext();
			}
			node2 = node2.getNext();
		}
		if(count >= k) return (node1 != null? node1.getData() : -1);
		return -1;
	}

	//recursive
	static int value;
	static ListNode findNthNodeRec(ListNode head, int k){
		if(head == null) return null;
		ListNode tmp = findNthNodeRec(head.getNext(), k);
		value = value+1;
		if(value == k){
			return head;
		}
		return tmp;
	}
	
	
	public static void main(String[] args) {
		ListNode node = UtilList.getList1();
		Util.printListNode(node);
		int x = findNthNode(node, 7);
		System.out.println(x);
		ListNode tmp = findNthNodeRec(node, 7);
		System.out.println(tmp);
	}
}
