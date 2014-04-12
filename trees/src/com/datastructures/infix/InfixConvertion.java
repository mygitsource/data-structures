package com.datastructures.infix;

import java.util.Stack;
import java.util.StringTokenizer;

import com.datastructures.infix.OperatorUtil.OPERATOR;

public class InfixConvertion {
/**
 * 
 * The most straightforward method is to start by inserting all the implicit brackets that show the order of evaluation e.g.:
	Infix					Postfix					Prefix
	((A * B) + (C / D) ) 	( (A B *) (C D /) +) 	(+ (* A B) (/ C D) )
	((A * (B + C) ) / D) 	( (A (B C +) *) D /) 	(/ (* A (+ B C) ) D)
	( A * (B + (C / D) ) ) 	(A (B (C D /) +) *) 	(* A (+ B (/ C D) ) )
	
	You can convert directly between these bracketed forms simply by moving the operator within the brackets 
		e.g. (X + Y) or (X Y +) or (+ X Y). Repeat this for all the operators in an expression, 
		and finally remove any superfluous brackets.

 * 
    You can use a similar trick to convert to and from parse trees - 
    each bracketed triplet of an operator and its two operands (or sub-expressions) 
    corresponds to a node of the tree. The corresponding parse trees are:
    
					      	  /			   *
		      +			     / \		  / \
		     / \		    *   D		 A   +
		    /   \		   / \			    / \
		   *     /		  A   +			   B   /
		  / \   / \		     / \		      / \
		 A   B C   D		B   C		     C   D
		
		((A*B)+(C/D))		((A*(B+C))/D) 		(A*(B+(C/D)))

 */
	
	
	private String infixToPrefix(String expression){
		if(expression == null) return null;
		Stack<String> stackExp = new Stack<>();
		//Put the expression into stack OR .. revers the string using stringbuild.
		StringTokenizer tokenizer = new StringTokenizer(expression, "+-*/^()",true);
		while(tokenizer.hasMoreElements()){
			stackExp.push((String)tokenizer.nextElement());
		}
		
		Stack<Character> stack = new Stack<>();
		StringBuilder prefix = new StringBuilder();
				
		while(!stackExp.empty()){
			String exp = stackExp.pop();
			if(OperatorUtil.isSpace(exp)) continue;
			
			if(OperatorUtil.isOperand(exp)){
				//if operand append to postfix
				prefix.append(exp).append(" ");
			}else if (OperatorUtil.isOperator(exp)){
				//if it is operator and it is higher precedence then on top of the stack then append to prefix 
				// till the top of the stack is closing parentheses
				while(!stack.isEmpty() && !OperatorUtil.isClosingParentheses(stack.peek()) && OperatorUtil.isHighPrecedence(stack.peek(), exp.charAt(0))){
					prefix.append(stack.pop()).append(" ");
				}
				stack.push(exp.charAt(0));
			}else if( OperatorUtil.isOpeningParentheses(exp.charAt(0))){
				//if it opening parenthese append all the operators from stack 
				//till the top of the stack is closing parentheses.

				while(!stack.empty() && !OperatorUtil.isClosingParentheses(stack.peek())){
					prefix.append(stack.pop()).append(" ");
				}
				if(!stack.empty())
					stack.pop();
			}else if( OperatorUtil.isClosingParentheses(exp.charAt(0))){
				stack.push(exp.charAt(0));
			}
		}
		
		while (!stack.empty()) {
			prefix.append(stack.pop()).append(" ");
		}

		return prefix.reverse().toString();
		
	}

	/*
	 * evaluation should start from right side, 
	 * so we should put into stack and read from stack OR reveres the string.  
	 */
	private int prefixEvaluation(String expression){
		if(expression == null) return 0;
		SimpleMath math = new SimpleMath();
		Stack<Integer> stack = new Stack<>();
		String[] strings = expression.split(" ");
		int length = strings.length;
		for(int i = length-1; i >0; i--){
			String token = strings[i];
			if(OperatorUtil.isSpace(token)) continue;
			if(OperatorUtil.isOperand(token)){
				stack.push(Integer.valueOf(token));
			}else if(OperatorUtil.isOperator(token)){
				//first will be the first operand, there is no change in prefix evalution
				int operand1 = stack.pop();
				int operand2 = stack.pop();
				int result = math.preform(OPERATOR.toPerator(token), operand1, operand2);
				stack.push(result);
			}
		}
		return stack.pop();

	}
	
	public static void main(String[] args) {
		InfixConvertion convertion = new InfixConvertion();
		String expression = "((a+b)*(c+d))";
		System.out.println(convertion.infixToPrefix(expression));
		expression = "((2+3)*(4-5)*6)";
		expression = convertion.infixToPrefix(expression);
		System.out.println(expression);
		System.out.println(convertion.prefixEvaluation(expression));
	}
	
	
}
