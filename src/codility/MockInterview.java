package codility;

import java.util.Stack;

public class MockInterview {
	
	int Brackets(String S) {
		
		Stack<Character> s = new Stack<>();
		for(int i = 0; i < S.length(); i++) {
			if(S.charAt(i) == '(' || S.charAt(i) == '[' || S.charAt(i) == '{') {
				s.push(S.charAt(i));
			}
			else if(S.charAt(i) == ')' && !s.isEmpty() && s.peek() == '(' ) {
				s.pop();
			}
			else if(S.charAt(i) == '}' &&  !s.isEmpty() && s.peek() == '{' ) {
				s.pop();
			}
			else if(S.charAt(i) == ']' && !s.isEmpty() && s.peek() == '[') {
				s.pop();
			}
			else {
				return 0;
			}
		}
		return s.isEmpty() ? 1 : 0;
	}
	
	int nesting(String S) {
		
		Stack<Character> s = new Stack<>();
		for(int i = 0; i < S.length(); i++) {
			if(S.charAt(i) == '(') {
				s.push(S.charAt(i));
			}
			else if(S.charAt(i) == ')' && !s.isEmpty() && s.peek() == '(') {
				s.pop();
			}
			else return 0;
		}
		return s.isEmpty() ? 1 : 0;
		
	}
	int maxProfit(int[] A) {
		
		int max  = 0;
		int min = A[0];
		for(int i = 1; i < A.length; i++) {
			int check = A[i] - min;
			if(check < 0) {
				min = A[i];
			}
			else {
				max = Math.max(max, check);
			}
		}
		return max;
	}
	
	
	
	
	
	

	public static void main(String[] args) {
		System.out.println("say hi!!");

		MockInterview test = new MockInterview();
		
		test.Brackets("([)()]");


	}

}
