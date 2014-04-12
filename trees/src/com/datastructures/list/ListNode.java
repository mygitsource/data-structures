package com.datastructures.list;

public class ListNode {
	
	public ListNode(){
	}
	public ListNode(int data){
		this.data = data;
	}
	public ListNode(int data, ListNode next) {
		this.data = data;
		this.next = next;
	}
	
	private int data = -1;
	private ListNode next = null;
	
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public ListNode getNext() {
		return next;
	}
	public void setNext(ListNode next) {
		this.next = next;
	}
	
	@Override
	public String toString() {
		return Integer.toString(data);
	}
}
