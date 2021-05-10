package mock;

import java.util.Stack;

public class MinStack {
	
	Stack<Integer> s;
	Stack<Integer> minArr;
	
	void push(int x) {
		if(minArr.isEmpty()) {
			minArr.add(x);
		}
		else {
			if(x <= minArr.peek()) {
				minArr.push(x);
			}
		}
		s.push(x);
	}
	
	void pop() {
		if(s.peek() == minArr.peek()) {
			minArr.pop();
		}
		s.pop();
	}
	
	int top() {
		if(!s.isEmpty()) {
			return s.peek();
		}
		return -1;
	}
	int getMin() {
		if(!minArr.isEmpty()) {
			return minArr.peek();
		}
		return -1;
	}
	
	public class MinStackv2{
		Stack<Integer> stack;
		int min = Integer.MAX_VALUE;
		
		
		void push(int x) {
			if(!stack.isEmpty()) {
				if(x < min) {
					stack.push(2 * x - min);
					min = x;
				}
			}
			else {
				stack.push(x);
				min = x;
			}
		}
		
		void pop() {
			if(stack.peek() < min) {
				min = 2 * min - stack.peek();
				stack.pop();
			}
			else {
				stack.pop();
			}
		}
		
		int top() {
			if(!stack.isEmpty()) {
				return stack.peek();
			}
			return -1;
		}
		
		int getMin() {
			return min;
		}
	}
	

}
