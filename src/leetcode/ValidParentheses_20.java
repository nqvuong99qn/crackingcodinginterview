package leetcode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class ValidParentheses_20 {
	
	boolean isValid(String s) {
		
		if(s.length() % 2 != 0) {
			return false;
		}
		
		Stack<Character> stack = new Stack<>();
		
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '[' || s.charAt(i) == '(' || s.charAt(i) == '{') {
				stack.push(s.charAt(i));
			}
			else if(s.charAt(i) == ']' && !stack.isEmpty() && stack.peek() == '[') {
				stack.pop();
			}
			else if(s.charAt(i) == ')' && !stack.isEmpty() && stack.peek() == '(') {
				stack.pop();
			}
			else if(s.charAt(i) == '}' && !stack.isEmpty() && stack.peek() == '{') {
				stack.pop();
			}
			else{
				return false;
			}
		}
		return stack.isEmpty();
	
	}
	
	
	public static void main(String[] args) {
		System.out.println("Say hi!!!");
		
		String s = "[]{}()";
		ValidParentheses_20 test = new ValidParentheses_20();
		
		 
		System.out.println("Expected result: " + test.isValid(s));
		
		
	}

}
