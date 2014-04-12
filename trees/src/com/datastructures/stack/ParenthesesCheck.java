package com.datastructures.stack;

import java.util.Stack;

public class ParenthesesCheck {

	private static final String OPENING_PARENTHESES = "({[";
//	private static final String CLOSEING_PARENTHESES = "]})";
	private static final String CLOSEING_PARENTHESES = ")}]";

	
	private static boolean isParenthesesBalanced(String expression){
		int length = expression.length();
		char[] array = expression.toCharArray();
		Stack<Character> stack = new Stack<Character>();
		boolean isBalanced = false;
		for (int i = 0; i < array.length; i++) {
			if(OPENING_PARENTHESES.indexOf(array[i]) > -1){
				stack.push(array[i]);
			}else if(CLOSEING_PARENTHESES.indexOf(array[i]) > -1){
				if(stack.empty()) return false;
				//if closing parentheses .. pop the stack with opening parentheses and 
				// check the index for closing and opening parentheses.
				isBalanced = (OPENING_PARENTHESES.indexOf(stack.pop()) == CLOSEING_PARENTHESES.indexOf(array[i]));
			}
		}
		
		return (isBalanced && stack.isEmpty());
	}
	
	public static void main(String[] args) {
		String expression = "{[]([])}";
		System.out.println(isParenthesesBalanced(expression));
	}
}
