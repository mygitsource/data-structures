package com.datastructures.infix;

public class OperatorUtil {
	
	static enum OPERATOR {
		MINUS('-'), PLUS('+'), DIVISION('/'), MULTIPLICATION('*'), MODULES('%');
		
		char opetator;
		OPERATOR(char operator){
			this.opetator = operator;
		}
		
		static OPERATOR toPerator(String operator){
			return toPerator(operator.charAt(0));
		}
		static OPERATOR toPerator(Character operator){
			if(operator == null) return null;
			if(operator.equals('+')){
				return OPERATOR.PLUS;
			}else if(operator.equals('-')){
				return OPERATOR.MINUS;
			}else if(operator.equals('*')){
				return OPERATOR.MULTIPLICATION;
			}if(operator.equals('/')){
				return OPERATOR.DIVISION;
			}if(operator.equals('%')){
				return OPERATOR.MODULES;
			}
			return null;
		}
			
		@Override
		public String toString() {
			return opetator+"";
		}
	}
	
	static final String OPENING_PARENTHESES = "({[";
	static final String CLOSEING_PARENTHESES = "]})";

	static boolean isHighPrecedence(char op1, char op2){
		int x = OPERATOR.toPerator(op1).compareTo(OPERATOR.toPerator(op2));
		if(x > 0)return true;
		else if (x < 0) return false;
		return true;
	}

	static boolean isOpeningParentheses(char ch){
		return (OPENING_PARENTHESES.indexOf(ch) > -1);
	}

	static boolean isClosingParentheses(char ch){
		return (CLOSEING_PARENTHESES.indexOf(ch) > -1);
	}

	static boolean isSpace(String string){
		if(string == null) return true;
		string = string.trim();
		if( string.equals(" ")){
			return true;
		}
		return false;
	}
	
	static boolean isOperator(String operator){
		if(OPERATOR.toPerator(operator.charAt(0)) != null){
			return true;
		}
		return false;
	}
	
	static boolean isOperand(String string){
		if(Character.isLetterOrDigit(string.charAt(0))){
			return true;
		}
		return false;
	}
	
}
