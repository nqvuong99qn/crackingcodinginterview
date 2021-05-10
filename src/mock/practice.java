package mock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class practice {
	
	int addDigit(int num) {
		
		while(num >= 10) {
			int temp = 0;
			while(num > 0) {
				temp += num % 10;
				num /= 10;
			}
			num = temp;
		}
		return num;
	}
	
	int majorEle(int[] nums) {
		
		if(nums.length == 0) {
			return -1;
		}
		// using map
		int len = nums.length;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int item : nums) {
			if(map.containsKey(item) && map.get(item) + 1 > len / 2 ) {
				return item;
			}
			else map.put(item, map.getOrDefault(item, 0) + 1);
		}
		return -1;
	}
	
	
	public class Node{
		Node next;
		int val;
		Node(int data){
			val = data;
		}
	}
	
	Node addTwoNumber(Node n1, Node n2) {
		Node result = new Node(0);
		Node temp = result;
		int carry = 0;
		while(n1 != null || n2 != null) {
			int x = n1 != null ? n1.val : 0;
			int y = n2 != null ? n2.val : 0;
			int digit = x + y + carry;
			temp.next = new Node(digit % 10);
			temp = temp.next;
			if(n1 != null) n1 = n1.next;
			if(n2 != null) n2 = n2.next;
		}
		if(carry != 0) {
			temp.next = new Node(carry);
		}
		return result.next;
	}
	
	
	public class TreeNode{
		TreeNode left;
		TreeNode right;
		int val;
		
		TreeNode(int data){
			val = data;
		}
	}
	
	//convert sorted to BST
	TreeNode arrayToBST(int[] arr) {
		if(arr.length == 0)
			return null;
		return helper(arr, 0, arr.length - 1);
	}
	TreeNode helper(int[] arr, int left, int right) {
		if(left <= right) {
			int mid = left + (right - left) / 2;
			TreeNode curr = new TreeNode(arr[mid]);
			curr.left = helper(arr, 0, mid - 1);
			curr.right = helper(arr, mid + 1, right);
			return curr;
		}
		return null;
	}
	
	
	List<List<Integer>> levelOrder(TreeNode root){
		
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(root == null)
			return result;
		Queue<TreeNode> currQ = new LinkedList<>();
		currQ.add(root);
		List<Integer> rootVal = new ArrayList<Integer>();
		rootVal.add(root.val);
		result.add(rootVal);
		
		while(!currQ.isEmpty()) {
			Queue<TreeNode> tempQ = new LinkedList<practice.TreeNode>();
			List<Integer> tempVal = new ArrayList<Integer>();
			while(!currQ.isEmpty()) {
				TreeNode curr = currQ.poll();
				if(curr.left != null) {
					tempQ.add(curr.left);
					tempVal.add(curr.left.val);
				}
				if(curr.right != null) {
					tempQ.add(curr.right);
					tempVal.add(curr.right.val);
				}
			}
			if(tempVal.size() != 0) {
				result.add(tempVal);
			}
			currQ = tempQ;
		}
		return result;	
	}
	
	
	
	
	public static void main(String args[]) {
		
		System.out.println("say hi!!");
		practice test = new practice();
		
		// test
		Node n1 = test.new Node(3);
		n1.next = test.new Node(5);
		n1.next = test.new Node(6);
		
		
		
		
		
		
		
		
	}
}
