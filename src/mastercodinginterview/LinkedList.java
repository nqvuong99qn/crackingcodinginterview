// Problem

/*	Write code to remove duplicates from an unsorted linked list.
	FOLLOW UP
	
 *	How would you solve this problem if a temporary buffer is not allowed? 
 */

package mastercodinginterview;

import java.util.HashSet;

import java.util.Set;
import java.util.Stack;



public class LinkedList {
	
	Node head;
	int size;
	
	public LinkedList(Node node) {
		this.head = node;
		if(node == null)
			this.size = 0;
		Node curr = node;
		while(curr != null) {
			size++;
			curr = curr.next;
		
		}
			
		
	}
	
	public class Node{
		int data;
		Node next;
		
		Node(int a){
			this.data = a;
			this.next = null;
		}
	}
	
	
	Node init(int a) {
		return new Node(a);
	}
	
	void addFirst(int data) {
		Node newNode = new Node(data);
		if(head == null) {
			head = newNode;
		}
		else {
			newNode.next = head;
			head = newNode;
		}
		size++;
	}
	
	void addLast(int data) {
		Node newNode = new Node(data);
		if(head == null) {
			head = newNode;
		}
		else {
			Node curr = head;
			while(curr.next != null) {
				curr = curr.next;
			}
			curr.next = newNode;
		}
		size++;
	}
	
	void reverse() {
		Node prev = null;
		Node curr = head;
		Node next = null;
		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		head = prev;	
		
	}
	
	
	void print() {
		Node curr = head;
		while(curr.next != null) {
			System.out.print(curr.data + "-->");
			curr = curr.next;
		}
		System.out.println(curr.data);
		System.out.println("size:" + size);
	}
	
	
	// method 1: using buffer
	void removeDuplicate_1() {
		Set set = new HashSet<>();
		Node curr = head;
		Node temp = null;
		while(curr != null) {
			if(set.contains(curr.data)) {
				temp.next = curr.next;
			}
			else {
				set.add(curr.data);
				temp = curr;				
			}
			curr = curr.next;	
		}
	}
	// method 2:   not using buffer
	void removeDuplicate_2() {
		Set set = new HashSet<>();
		Node curr = head;
		
		while(curr != null) {
			Node runner = curr;
			while(runner.next != null) {
				if(runner.next.data == curr.data) {
					runner.next = runner.next.next;
				}
				else {
					runner = runner.next;
				}
			}
			curr = curr.next;
		}
	}
	
	// problem 
	// Implement an algorithm to find the kth to last element of a singly linked list.
	
	int kThLastElement(int k) {
		
		if(head == null) {
			throw new IllegalArgumentException("LinkedList is null!");
		}
		// find size of linkedList
		Node curr = head;
		int count = 0;
		while(curr != null) {
			count++;
			curr = curr.next;
		}
		// find element
		Node temp = head;
		
		int len = count  - k;
		if(len < 0)
			throw new IllegalArgumentException("Out of length LinkedList!");
		for(int i = 0; i < len; i++)
			temp = temp.next;
		
		return temp.data;
	}
	
	
	boolean checkPalindrome(Node head) {
		// reverse
		Node reversed = reverse(head);
		// compare
		return compare(head, reversed);
	}
	
	// reverse
	Node reverse(Node head) {
		
		Node curr, pre, next;
		curr = head;
		pre = null;
		
		while(curr != null) {
			next = curr.next;
			curr.next = pre;
			pre = curr;
			curr = next;
		}
		return pre;
	}
	
	// compare
	boolean compare(Node head1, Node head2) {
		while(head1 != null) {
			if(head1.data != head2.data) {
				return false;
			}
			head1 = head1.next;
			head2 = head2.next;
		}
		return true;
	}
	
	// Using stack
	
	boolean isPalindrome(Node head) {
		
		// check size
		// size is odd or even
		Stack<Integer> stack = new Stack<>();
		Node curr = head;
		for(int i = 0; i < size / 2; i++) {
			stack.push(curr.data);
			curr = curr.next;
		}
		if(size % 2 != 0)
			curr = curr.next;
		
		while(curr != null) {
			if(stack.pop() != curr.data) {
				return false;
			}
			curr = curr.next;	
		}
		return true;
	}
	
	boolean isPalindDrome2(Node head) {
		// fast runner
		// slow runner
		
		Node fast = head;
		Node slow = head;
		
		Stack<Integer> stack = new Stack<>();
		
		while(fast != null && fast.next != null) {
			stack.push(slow.data);
			slow = slow.next;
			fast = fast.next.next;
		}
		
		// check odd or even
		
		if(fast != null) {
			slow = slow.next;
		}
		
		while(slow != null) {
			if(stack.pop() != slow.data)
				return false;
			slow = slow.next;
		}
			
		
		return true;
	}
	
	LinkedList findIntersection(LinkedList l1, LinkedList l2) {
		
		LinkedList result = new LinkedList(null);
		// check null
		if(l1 == null || l2 == null)
			return null;
		
		
		// get tails and check the same
		Node tail1 = l1.head;
		while(tail1.next != null) {
			tail1 = tail1.next;
		}
		
		Node tail2 = l2.head;
		while(tail2.next != null) {
			tail2 = tail2.next;
		}
		
		if(tail1.data != tail2.data) {
			return null;
		}
		
		Node longer = l1.size < l2.size ? l2.head : l1.head;
		Node shorter = l1.size > l2.size ? l2.head : l1.head;
		
		int temp = Math.abs(l1.size - l2.size);
		while(temp > 0) {
			longer = longer.next;
			temp--;
		}
		
		while(longer != shorter) {
			longer = longer.next;
			shorter= shorter.next;
		}
		return new LinkedList(longer);
		
		
	}
	
	
	
	public static void main(String[] args) {
		
		System.out.println("Say hi!!!");
		
		// init data
		LinkedList list = new LinkedList(null);
//		list.addLast(0);
//		list.addLast(1);
//		list.addLast(2);
//		list.addLast(3);
		
		
		
		Node n1 = list.init(1);
		Node n2 = list.init(2);
		Node n3 = list.init(3);
		Node n4 = list.init(4);
		
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n2;
		
		list.head = n1;
		
		// detect loop in linkedlist
		
		Node curr = list.head;
		
		Stack<Integer> stack = new Stack<>();
		
		
		
		
		
		
//		list.addFirst(0);
//		list.addFirst(1);
//		list.addFirst(0);
//		list.addFirst(2);
//		list.addFirst(0);
	
	
	//	list.print();
		
//		LinkedList list2 = new LinkedList(list.head.next.next);
//		 
//		
//		list2.addFirst(100);
//		
//		list2.print();
//		System.out.println("Expected result: " + list.kThLastElement(2));
		
		
		
//		LinkedList result = list.findIntersection(list, list2);
//		
//		result.print();
		
		
		
	}
	
	
	
	
	
	

}
