package com.datastructures.trees.bst;

import com.datastructures.list.LinkedList;
import com.datastructures.list.ListNode;
import com.datastructures.trees.Node;
import com.datastructures.trees.util.Util;

public class SortedLinkedListToBalancedBst {

	static Node sortedLinkedListToBalancedBst(Node root, ListNode head){
		ListNode p,q;
		if(head == null)return null;
		if(head.getNext() == null){
			return new Node(head.getData());
		}
		ListNode mid = midNode(head);
		
		p = head;
		while(p.getNext() != mid){
			p = p.getNext();
		}
		p.setNext(null);
		q = mid.getNext();
		mid.setNext(null);
		root.setLeft(sortedLinkedListToBalancedBst(new Node(mid.getData()),head));
		root.setRight(sortedLinkedListToBalancedBst(new Node(mid.getData()),q));
		return new Node(mid.getData());
	}
	
	static Node sortedLinkedListToBalancedBst(ListNode head){
		if(head == null || head.getNext() == null) return null;
		ListNode mid = midNode(head);
		Node root = new Node(mid.getData());
		
		ListNode p,q;
		p = head;
		while(p.getNext() != mid){
			p = p.getNext();
		}
		p.setNext(null);
		q = mid.getNext();
		mid.setNext(null);
		root.setLeft(sortedLinkedListToBalancedBst(root, head));
		root.setRight(sortedLinkedListToBalancedBst(root, q));
		return root;
	}

	static ListNode midNode(ListNode head){
		ListNode tmp1 = head;
		ListNode tmp2 = head;
		int i = 0;
		while(tmp1.getNext() != null){
			if(i == 0){
				tmp1 = tmp1.getNext();
				i = 1;
			}else if(i ==1){
				tmp1 = tmp1.getNext();
				tmp2 = tmp2.getNext();
				i = 0;
			}
		}
		return tmp2;
	}
	
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.insertNode(9);
		list.insertNode(8);
		list.insertNode(7);
		list.insertNode(6);
		list.insertNode(5);
		list.insertNode(4);
		list.insertNode(3);
		list.insertNode(2);
		list.insertNode(1);
		Util.printList(list);
		sortedLinkedListToBalancedBst(list.getHead());
		
	}
}
