package com.datastructures.infix;

import com.datastructures.infix.OperatorUtil.OPERATOR;

public class SimpleMath {

	public int preform(OPERATOR operator, int x, int y){
		switch (operator) {
		case MINUS:
			return sub(x, y);
		case PLUS:
			return add(x, y);
		case DIVISION:
			return division(x, y);
		case MULTIPLICATION:
			return multiplication(x, y);
		}
		return -99999;
	}
	
	public int add(int a, int b){
		return a+b;
	}
	
	public int multiplication(int a, int b){
		return a*b;
	}
	
	public int division(int x, int y){
		if(y == 0) throw new ArithmeticException("y should not be zero");
		return (x/y);
	}
	
	public int sub(int x, int y){
		return x-y;
	}
	
	
}
