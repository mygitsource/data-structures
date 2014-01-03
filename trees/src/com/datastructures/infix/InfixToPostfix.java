package com.datastructures.infix;

import java.util.Stack;
import java.util.StringTokenizer;

import com.datastructures.infix.OperatorUtil.OPERATOR;

public class InfixToPostfix {
	/*
	 * Any operator in the stack having higher precedence then the operator we are looking at can be 
	 * poped and placed into the postfix expression.
	 * 
	 * When we see operator, we need to look into the stack , if it's operator of higher precedence, it can 
	 * be poped into postfix expression, but we should stop when we see opening parentheses.
	 *  
	 *  When we see closing parentheses, we need to pop all the operators till we see opening parentheses, 
	 *  then pop that opening parentheses as well. 
	 * 
	 */
	
	/*
	 * 	Order of precedence :
	 * 	1.	() {} [] 
	 *  2. Exponents (a^b)		(right to left)
	 *  3. * , /, %				(left to right)
	 *  4. + , -				(left to right)
	 *  
	 */
	
	//((a+b)*c-d)*e  ===> ab+c*d-e*
	private String infixToPostfix(String expression){
		if(expression == null|| expression.length() ==0) return null;
		Stack<Character> stack = new Stack<>();
		StringTokenizer tokenizer = new StringTokenizer(expression, "+-*/^() ", true);
		StringBuilder postFix = new StringBuilder();
		while(tokenizer.hasMoreElements()){
			String exp = tokenizer.nextToken();
			if(OperatorUtil.isSpace(exp)) continue;
			
			if(OperatorUtil.isOperand(exp)){
				//if operand append to postfix
				postFix.append(exp).append(" ");
			}else if (OperatorUtil.isOperator(exp)){
				//if it is operator and it is higher precedence then on top of the stack then append to postfix 
				// till the top of the stack is opening parentheses
				while(!stack.isEmpty() && !OperatorUtil.isOpeningParentheses(stack.peek()) && OperatorUtil.isHighPrecedence(stack.peek(), exp.charAt(0))){
					postFix.append(stack.pop()).append(" ");
				}
				stack.push(exp.charAt(0));
			}else if( OperatorUtil.isOpeningParentheses(exp.charAt(0))){
				stack.push(exp.charAt(0));
			}else if( OperatorUtil.isClosingParentheses(exp.charAt(0))){
				//if it closing parentheses append all the operators from stack 
				//till the top of the stack is opening parentheses.
				while(!stack.empty() && !OperatorUtil.isOpeningParentheses(stack.peek())){
					postFix.append(stack.pop()).append(" ");
				}
				if(!stack.empty())
					stack.pop();
			}
		}
		while (!stack.empty()) {
			postFix.append(stack.pop()).append(" ");
		}
		return postFix.toString();
	}
	
	private int evaluatePostfix(String expression){
		SimpleMath math = new SimpleMath();
		Stack<Integer> stack = new Stack<>();
		StringTokenizer tokenizer = new StringTokenizer(expression, " ");
		
		while(tokenizer.hasMoreTokens()){
			String token = tokenizer.nextToken();
			if(OperatorUtil.isOperand(token)){
				stack.push(Integer.valueOf(token));
			}else if(OperatorUtil.isOperator(token)){
				//first will be the second operand
				int operand2 = stack.pop();
				int operand1 = stack.pop();
				int result = math.preform(OPERATOR.toPerator(token), operand1, operand2);
				stack.push(result);
			}
		}
		return stack.pop();
	}
	
	
	
	public static void main(String[] args) {
		String expression = "((a+b)*c-d)*e";
		InfixToPostfix postfix  = new InfixToPostfix();
		System.out.println(postfix.infixToPostfix(expression));
		expression = "((2+3)*(4-5)*6)";
		expression = postfix.infixToPostfix(expression);
		System.out.println(expression);
		System.out.println(postfix.evaluatePostfix(expression));
		
//		System.out.println(new InfixToPostfix().isHighPrecedence('+', '+'));
	}
	
	
}
