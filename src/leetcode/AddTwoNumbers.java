package leetcode;

import java.awt.SystemColor;



public class AddTwoNumbers {
	
	
	public class ListNode{
		ListNode next;
		int data;
		ListNode(int x) {
			this.data = x;
			
		}
		
		void print(ListNode head) {
			ListNode curr = head;
			while(curr != null) {
				System.out.print(curr.data + "-->");
				curr = curr.next;
			}
		}
		
	}
	
	
	public class Solution{
		
		ListNode addTwoNumbers(ListNode l1, ListNode l2) {
			ListNode temp = new ListNode(0);
			
			ListNode p = l1, q = l2, curr = temp;
			
			int carry = 0;
			
			while(p != null || q != null) {
				int x = (p != null)? p.data : 0;
				int y = (q != null)? q.data : 0;
				
				int digit = carry + x + y;
				carry = digit / 10;
				
				curr.next = new ListNode(digit % 10);
				curr = curr.next;
				
				if(p != null) p = p.next;
				if(q != null) q = q.next;
					
			}
			if(carry != 0)
				curr.next = new ListNode(carry);
			
			return temp.next;
		}
		
		
		ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
			ListNode currl1 = l1;
			ListNode currl2 = l2;
			
			ListNode temp = new ListNode(0);
			ListNode curr = temp;
			
			int carry = 0;
			while(currl1 != null && currl2 != null) {
				if(currl1 != null) {
					carry += currl1.data;
					currl1 = currl1.next;
				}
				if(currl2 != null) {
					carry += currl2.data;
					currl2 = currl2.next;
				}
				curr.next = new ListNode(carry%10);
				carry /= 10;
				curr = curr.next;
				
				
			}
			if(carry != 0)
				curr.next = new ListNode(carry);
		
			return temp.next;
		}
		
		
	}
	public static void main(String[] args) {
		System.out.println("say hi!!");
		
		
		AddTwoNumbers test = new AddTwoNumbers();
		
		ListNode n1 = test.new ListNode(1);
		ListNode n2 = test.new ListNode(2);
		ListNode n5 = test.new ListNode(2);
		ListNode n3 = test.new ListNode(3);
		ListNode n4 = test.new ListNode(4);
		
		n1.next = n2;
		n2.next = n5;
		n3.next = n4;
		
		Solution s = test.new Solution();
		
		ListNode result = s.addTwoNumbers2(n1, n3);
		
		
		
		
		result.print(result);
		
		
	
		
		
		
		
		
		
	}
	
	
	
		
	

}
