package com.datastructures.list;

import com.datastructures.trees.util.Util;

public class QuickSortOnSingleLinkedList {

	/*
	 *  first call partition() 
	 *  which places pivot at correct position and returns pivot. 
	 *  After pivot is placed at correct position,
	 *  we find tail node of left side (list before pivot) and 
	 *  recur for left list. Finally, we recur for right list.
	 */
	//TODO *****
	static ListNode tmpHead = null, tmpEnd = null;
	static LinkedList list;
	ListNode quickSort(ListNode head, ListNode endNode){
		if(head == null || head == endNode){
			return head;
		}	
		
		ListNode pivot = partition(head, endNode);
		System.out.println("p : "+pivot);
		// if the pivot is the smallest , no need to recur the left part
		if(tmpHead != pivot ){
			//set the node before the pivot node as null
			ListNode tmp = tmpHead;
			while(tmp.getNext() != pivot){
				tmp = tmp.getNext();
			}
			tmp.setNext(null);
			tmpHead = quickSort(tmpHead, tmp);
			tmp = getTail(tmpHead);
			tmp.setNext(pivot);
		}
		
		//Recur for the list after the pivot element.
		pivot.setNext(quickSort(pivot.getNext(), tmpEnd));
		return tmpHead;
	}
	
	public ListNode getTail(ListNode currNode){
		while(currNode != null && currNode.getNext() != null){
			currNode = currNode.getNext();
		}
		return currNode;
	}
	
	/*
	 * we consider last element as pivot. 
	 * We traverse through the current list and if a node has value greater than pivot, 
	 * we move it after tail. If the node has smaller value, 
	 * we keep it at its current position.
	 * 
	 */
	ListNode partition(ListNode head, ListNode end){
		//pivot is endnode
		ListNode pivot = end;
		ListNode prev = null, current = head, tail = end;
		
		while(current != null && current != pivot){
			if(current.getData() < pivot.getData()){
				if(tmpHead == null){
					tmpHead = current;
				}
				prev = current;
				current = current.getNext();
			}else{
				//if the current node is greater then pivot
				//move the current node to next of tail and change tail
				if(prev != null){
					prev.setNext(current.getNext()); 	
				}
				ListNode tmp = current.getNext();
				current.setNext(null);
				tail.setNext(current);
				tail = current;
				current = tmp;
			}
		}
		
		//if the pivot is smallest then pivot will be the head
		if(tmpHead == null){
			tmpHead = pivot;
		}
		
		//update tmpEnd to current last node
		tmpEnd = tail;
		
		return pivot;
	}
	
	
	public static void main(String[] args) {
		list = new LinkedList();
		list.insertNode(3);
		list.insertNode(9);
		list.insertNode(4);
		list.insertNode(2);
		list.insertNode(5);
		
		Util.printList(list);
		QuickSortOnSingleLinkedList quickSort = new QuickSortOnSingleLinkedList();
		tmpHead = quickSort.quickSort(list.getHead(), list.getTail());
/*		while(tmpHead != null){
			System.out.print(tmpHead);
			tmpHead = tmpHead.getNext();
			if(tmpHead != tmpEnd)
				System.out.print("->");
		}
		System.out.println("\n");
*/	}
}
