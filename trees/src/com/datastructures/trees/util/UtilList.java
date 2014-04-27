package com.datastructures.trees.util;

import com.datastructures.list.LinkedList;
import com.datastructures.list.ListNode;

public class UtilList {

	public static ListNode getList1(){
		LinkedList linkedList = new LinkedList();
		linkedList.addNext(10);
		linkedList.addNext(20);
		linkedList.addNext(30);
		linkedList.addNext(40);
		linkedList.addNext(50);
		linkedList.addNext(60);
		linkedList.addNext(70);
		linkedList.addNext(80);
		return linkedList.getHead();
	}
	
	public static void main(String[] args) {
		Util.printListNode(getList1());
	}
}
