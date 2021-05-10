package mastercodinginterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class QuickSort {
			
//	int partition(int[] arr, int l, int r) {	
//		int pivot = arr[r];
//		int left = l;
//		int right = r - 1;
//		while(true) {
//			while(left <= r && arr[left] < pivot) left++;
//			while(right >= l && arr[right] > pivot) right--;
//			if(left >= right) break;
//			// swap 
//			swap(arr, left, right);
//			left++;
//			right--;
//		}
//		swap(arr, left, r);
//		return left;	
//	}
//	
//	void swap(int[] arr, int i, int j) {
//		int temp = arr[i];
//		arr[i] = arr[j];
//		arr[j] = temp;
//	}
//	
//	void quickSort(int[] arr, int l, int r ) {
//		if(l < r) {
//			int p = partition(arr,  l, r);
//			quickSort(arr, l, p-1);
//			quickSort(arr, p+1, r);
//		}
//	}
	
	// swap
	void swap(int[] arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	//partition
	int partition(int[] arr, int l, int r) {
		int pivot = arr[l];
		int left = l + 1;
		int right = r;
		while(true) {
			while(left <= r && arr[left] < pivot) left++;
			while(right >= l && arr[right] > pivot) right--;
			if(left >= right) break;
			swap(arr, left, right);
			left++;
			right--;
		}
		swap(arr, l, right);
		return right;
				
	}
	// quickSort
	
	
	
	void quickSort(int[] arr, int l, int r) {
		if(l < r) {
			int part = partition(arr, l, r);
			quickSort(arr, l, part-1);
			quickSort(arr, part + 1, r);
		}
	}
	//
	// merge sort
	void merge(int[] arr, int l, int m, int r) {
		int[] result = new int[r - l + 1];
		int i = l;
		int j = m + 1;
		int k = 0;
		while(i <= m && j <= r) {
			if(arr[i] <= arr[j]) {
				result[k++] = arr[i++];
			}
			else result[k++] = arr[j++];
		}
		while(i <= m) {
			result[k++] = arr[i++]; 
		}
		while(j <= r) {
			result[k++] = arr[j++]; 
		}
		for(int item = l; item <= r; item++) {
			arr[item] = result[item-l];
		}	
	}
	
	void mergeSort(int arr[], int l, int r) {
		if(l < r) {
			int mid = (r + l) / 2;
			mergeSort(arr, l, mid);
			mergeSort(arr, mid + 1, r);
			merge(arr, l, mid, r);
		}
	}
	
	
	// implement a set
	public class Entry<K>{
		Entry<K> next;
		K key;
		public Entry(K key) {
			this.key = key;
		}
	}
	
	public class Set<K>{
		
		int SIZE;
		Entry<K>[] buckets;
		int size = 0;
		
		public Set(int size) {
			this.buckets = new Entry[size];
			this.SIZE = size;
		}
		
		// contain
		boolean contains(K key) {
			if(buckets.length == 0) {
				return false;
			}
			int idx = key.hashCode() % SIZE;
			Entry<K> entry = buckets[idx];
			while(entry != null) {
				if(entry.key.equals(key))
					return true;
				entry = entry.next;
			}
			return false;
		}
		// add
		void add(K key){
			if(this.size == SIZE) {
				return;
			}
			Entry<K> newEntry = new Entry<K>(key);
			if(contains(key)) {
				return;
			}
			else {
				int idx = key.hashCode() % SIZE;
				Entry<K> curr = buckets[idx];
				if(curr == null) {
					buckets[idx] = newEntry;
					return;
				}
				while(curr.next != null) {
					curr = curr.next;
				}
				curr.next = newEntry;
				size++;
			}
		}
		
		boolean remove(K key) {
			int idx = key.hashCode() % SIZE;
			Entry<K> curr = buckets[idx];
			if(curr == null) {
				return false;
			}
			Entry<K> pre = curr;
			while(curr != null) {
				if(curr.key.equals(key)) {
					pre = curr.next;
					return true;
				}
				pre = curr;
				curr = curr.next;
			}
			return false;
		}
		
		
	}
	
	
	
	public static void main(String[] args) {
		System.out.println("Say hi!!!!");
		
		int[] arr = {234,234,12,4,5,23,5,7,5};
		
		QuickSort sort = new QuickSort();
//		sort.quickSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
		
		sort.mergeSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
		
		
		Set<Integer> set = sort.new Set<>(10);
		
		set.add(1);
		set.add(2);
		set.add(3);
		set.add(4);
		set.add(11);
		
		
		
		

	}

}
