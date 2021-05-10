package mock;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheV1 {
	
	
	public static class Node{
		int key;
		int val;
		Node next;
		public  Node(int key, int val) {
			this.key = key;
			this.val = val;
		}
	}
	
	public static class LL{
		Node head;
		
		// add to the first
		void addFirst(Node node) {
			if(head == null)
				head = node;
			else {
				node.next = head;
				head = node;
			}
		}
		
		// deleteNode
		void deleteNode(Node node) {
			if(head == null)
				return;
			Node curr = head;
			Node pre = null;
			while(curr != null) {
				if(curr.key == node.key) {
					if(pre == null) {
						head = null;
						return;
					}
					else {
						pre.next = curr.next;
					}
				}
				pre = curr;
				curr = curr.next;
			}
		}
		Node deleteLast() {
			Node lastNode = null;
			if(head == null) {
				return null;
			}
			Node curr = head;
			while(curr.next.next != null) {
				curr = curr.next;
			}
			lastNode = curr.next;
			curr.next = null;
			return lastNode;
		}
	}
	
	
	LL ll;
	Map<Integer, Node> map;
	int count;
	int SIZE;
	
	public LRUCacheV1(int SIZE) {
		map = new HashMap<>();
		this.SIZE = SIZE;
		ll = new LL();
	}
	
	
	int get(int key) {
		if(map.containsKey(key)) {
			Node currNode = map.get(key);
			int value = currNode.val;
			ll.deleteNode(currNode);
			ll.addFirst(currNode);
			return value;
		}
		return -1;
	}
	
	void put(int key, int value) {
		if(map.containsKey(key)) {
			Node currNode = map.get(key);
			currNode.val = value;
			ll.deleteNode(currNode);
			ll.addFirst(currNode);
		}
		else{
			Node newNode = new Node(key, value);
			map.put(key, newNode);
			if(count < SIZE) {
				count++;
				ll.addFirst(newNode);
			}
			else {
				Node lastNode = ll.deleteLast();
				map.remove(lastNode.key);
				ll.addFirst(newNode);
			}
		}

	}
	
	void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	int partition(int[] arr, int l, int r) {
		
		int pivot = l;
		int left = l+1;
		int right = r;
		
		while(true) {
			while(left <= r && arr[left] < arr[pivot]) left++;
			while(right >= l && arr[right] > arr[pivot]) right--;
			if(left >= right) break;
			swap(arr, left, right);
			left++;
			right--;
		}
		swap(arr, l, right);
		return right;
	}
	
	
	int largestKth(int[] arr, int K) {
		int left = 0;
		int right = arr.length - 1;
		// update check var
		int check = arr.length - K;
		while(left <= right) {
			int pi = partition(arr, left, right);
			
			if(pi == check ) {
				return arr[pi];
			}
			else if(pi < check) {
				left = pi + 1;
			}
			else {
				right = pi - 1;
			}
		}
		return -1;
	}
	
	
	public static void main(String args[]) {
		
		System.out.println("Say hi!!!");
		
		LRUCacheV1 cache = new LRUCacheV1(5);
		
		cache.put(1, 11);
		cache.put(2, 11);
		cache.put(3, 11);
		cache.put(4, 11);
		cache.put(5, 11);
		cache.put(6, 11);
		
		cache.put(2, 12);
		
		
		int[] arr = {1, 2, 3, 4, 5, 6, 7};
		
		cache.largestKth(arr, 7);
		
	
		
		
		
		
		
		
		
	}
}
