package javaPractice;

import java.util.HashMap;
import java.util.Map;

import leetcode.LRUCache;

public class SeaPractice {
	
	// find kth largest element in array, not using build-in function
	
	// using quick sort
	int partition(int[] arr, int l, int r) {
		int pivot = l;
		int left = l + 1;
		int right = r;
		while(true) {
			while(left <= r && arr[left] < arr[pivot]) left++;
			while(right >= l && arr[right] > arr[pivot]) right--;
			if(left >= right) break;
			swap(arr, left, right);
			left++;
			right--;
		}
		swap(arr, pivot, right);
		return right;
	}
	void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	void quickSort(int arr[], int l, int r) {
		if(l < r) {
			int pivot = partition(arr, l, r);
			quickSort(arr, l, pivot -1);
			quickSort(arr, pivot+1, r);
		}
	}
	
	int kthLargestElement(int[] arr, int k) {
		quickSort(arr,  0, arr.length-1);
		return arr[arr.length - k];
	}
	
	public class Node{
		Node next;
		int val;
		public Node(int val) {
			this.val = val;
		}
	}
	
	public class LL{
		Node head;
		Node tail;
		
		void addFirst(int data) {
			Node newNode = new Node(data);
			if(head == null) {
				head = newNode;
				tail = newNode;
			}
			else {
				newNode.next = head;
				head = newNode;
				tail = head;
				while(tail.next != null) {
					tail = tail.next;
				}
			}
		
		}
		void addLast(int data) {
			Node newNode = new Node(data);
			if(head == null) {
				head = newNode;
				tail = newNode;
			}
			else {
				tail.next = newNode;
				tail = newNode;
			}
		}
		void remove(int key) {
			Node curr = head;
			Node pre = head;
			while(curr != null) {
				if(curr.val == key)
					break;
				pre = curr;
				curr = curr.next;
			}
			pre.next = curr.next;
		}
		void removeLast() {
			Node curr = head;
			while(curr.next != null) {
				curr = curr.next;
			}
			curr.next = null;
			curr = tail;
		}
		
		void print() {
			Node curr = head;
			while(curr != null) {
				System.out.print(curr.val + "-->");
				curr = curr.next;
			}
		}
	
	}
	
	public class LRUCache{
		LL l;
		Map<Integer, Integer> map;
		int size;
		
		public LRUCache(int size) {
			l = new LL();
			this.size = size;
			map = new HashMap<>();
		}
		
		int get(int key) {
			if(map.containsKey(key)) {
				int val = map.get(key);
				l.remove(key);
				l.addFirst(key);
				return val;
			}
			else return -1;
		}
		
		void put(int key, int val) {
			if(map.containsKey(key)) {
				l.remove(key);
				l.addFirst(key);
			}
			else if(map.size() >= size) {
				l.removeLast();
				l.addFirst(key);
				map.remove(l.tail.val);	
			}
			map.put(key, val);
		}
	}
	
	
	// implement hash table
	public class Entry<K, V>{
		K key;
		V value;
		Entry<K, V> next;
		public Entry(K key, V value, Entry<K, V> next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}
		
		
		
	}
	public class MM<K, V>{
		Entry<K, V>[] buckets;
		final int SIZE = 16;
		int size = 0;
		
		public MM() {

		}
		public int getHash(K key) {
			return (int)key.hashCode();
		}
		
		public boolean equals(Object obj1, Object obj2) {
			return obj1.equals(obj2);
		}
		
		void put(K key, V value) {
			Entry<K, V> entry = new Entry<>(key, value, null);
			int bucket = getHash(key) % SIZE;
			Entry<K, V> curr = buckets[bucket];
			if(curr == null) {
				buckets[bucket] = entry;
				size++;
			}
			else {
				while(curr.next != null) {
					if(curr.key.equals(key)) {
						curr.value = value;
						return;
					}
					curr = curr.next;
				}
				if(curr.key.equals(key)) {
					curr.value = value;
				}
				else {
					curr.next = entry;
					size++;
					return;
				}
			}
		}
		
		V get(K key) {
			Entry<K, V> curr = buckets[getHash(key) % SIZE];
			
			while(curr != null) {
				if(curr.key.equals(key)) {
					return curr.value;
				}
				curr = curr.next;
			}
			return null;
		}
	
		
		
	}
		
	
	
	
	
	
	public static void main(String args[]) {
		
		SeaPractice test = new SeaPractice();
		
		LL l = test.new LL();
		
		l.addFirst(1);
		l.addFirst(2);
		l.addFirst(3);
		l.addFirst(4);
		l.addFirst(5);
		l.addLast(6);
		l.print();
		
		
	
		
		

		
	}

}
