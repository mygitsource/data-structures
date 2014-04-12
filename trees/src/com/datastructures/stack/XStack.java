package com.datastructures.stack;

import java.util.Arrays;

public class XStack<T> {

	private int defaultCapacity = 10;
	private int size;
	private Object[] elements = new Object[defaultCapacity];
	private int mid = 0;
	
	void push(T t){
		if(size == elements.length){
			ensureCapacity();
		}
		elements[size++] = t;
		
		if(size == 1){
			mid = 0;
		}else if(size %2 ==1){
			mid = mid+1;
		}
	}
	
	T pop(){
		if(!(size >= 0)){
			throw new IndexOutOfBoundsException();
		}
		T t = (T) elements[--size];
		elements[size] = null;
		
		if(size%2 == 0 ){
			mid = mid-1;
		}
		return t;
	}
	
	void ensureCapacity(){
		int newLength = elements.length * 2;
		elements = Arrays.copyOf(elements, newLength);
	}
	
	int getSize(){
		return size;
	}
	
	T getMid(){
		return (T)elements[mid];
	}
	public static void main(String[] args) {
		XStack<String> sStack = new XStack<>();
		for(int i =0 ; i< 25; i++){
			sStack.push("numer"+i);
			System.out.println(sStack.getMid()+ " size : "+sStack.getSize());
		}
		
		System.out.println("Size : "+sStack.getSize());
		int x = sStack.getSize();
		for(int i =0 ; i<x; i++){
			System.out.println(sStack.getMid()+ " size : "+sStack.getSize());
			System.out.print(sStack.pop()+" ");
		}

		System.out.println("\nSize : "+sStack.getSize());

	}
}
