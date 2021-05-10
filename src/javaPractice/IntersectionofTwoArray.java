package javaPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IntersectionofTwoArray {
	
	
	boolean IsExisted(int[] arr, int value) {
		if( arr == null || arr.length == 0) {
			return false;
		}
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == value) {
				return true;
			}
		}
		return false;
	}
	
	// naive solution
	public int[] intersect(int[] nums1, int[] nums2) {
		if(nums1.length == 0 || nums2.length == 0) {
			return null;
		}
		Set<Integer> set = new HashSet<>();
		for(int i = 0; i < nums1.length; i++) {
			for(int j = 0; j < nums2.length; j++) {
				if(nums2[j] == nums1[i] && !set.contains(nums1[i])) {
					set.add(nums1[i]);
				}
			}
		}
		
		int index = 0;
		int[] result = new int[set.size()];
		for(int c : set) {
			result[index++] = c;
		}
		return result;
	}
	
	// Sort and Binary Search
	boolean binarySearch(int[] arr, int key) {
		int left = 0;
		int right = arr.length - 1;
		while(left < right) {
			int mid = left + (right - left) / 2;
			if(arr[mid] == key)
				return true;
			else if(arr[mid] > key){
				right = mid - 1;
			}
			else left = mid + 1;
		}
		return true;
	}
	public int[] s2(int[] n1, int[] n2) {
		if(n1.length == 0 || n2.length == 0) {
			return null;
		}
		// Assume n1.length > n2.length
		Arrays.sort(n1);
		
		Set<Integer> set = new HashSet<>();
		for(int i = 0; i < n2.length; i++) {
			if(binarySearch(n1, n2[i]) && !set.contains(n2[i])) {
				set.add(n2[i]);
			}
		}
		int[] result = new int[set.size()];
		int id = 0;
		for(int item : set) {
			result[id++] = item;
		}
		return result;
	}
	
	// method 3: sort two arrays, using two pointer
	
	int[] intersecter3(int[] n1, int[] n2) {
		// check input
		if(n1.length == 0 || n2.length == 0) {
			return  null;
		}
		
		Arrays.sort(n1);
		Arrays.sort(n2);
		
		int i = 0;
		int j = 0;
		Set<Integer> set = new HashSet<>();
		while(i < n1.length && j < n2.length) {
			int check = n1[i] - n2[j];
			if(check == 0) {
				set.add(n1[i]);
				i++;
				j++;
			}
			else if(check > 0) {
				j++;
			}
			else i++;
		}
		int[] result = new int[set.size()];
		int id  = 0;
		for(int item : set) {
			result[id++] = item;
		}
		return result;
	}
	
	// method 4: using hash table!
	
	int[] interset4(int[] n1, int[] n2){
		Set<Integer> set = new HashSet<>();
		for(int item : n1) {
			set.add(item);
		}
		List<Integer> lst = new ArrayList<>();
		for(int item : n2) {
			if(set.contains(item)) {
				lst.add(item);
			}
		}
		int[] result = new int[lst.size()];
		int id = 0;
		for(int item : lst) {
			result[id++] = item;
		}
		return result;
	}
	
	
	public static void main(String[] args) {
		System.out.println("Say hi!!!!");

		IntersectionofTwoArray solution = new IntersectionofTwoArray();
		// initial data
		int[] arr1 = new int[4];
		arr1[0] = 7;
		arr1[1] = 6;
		arr1[2] = 5;
		arr1[3] = 7;
		
		int[] arr2 = new int[4];
		arr2[0] = 7;
		arr2[1] = 6;
		arr2[2] = 5;
		arr2[3] = 7;

		int[] result = solution.intersect(arr1, arr2);
		System.out.println("Expected: " + "[" + result[0] + "," + result[1] + "]");

	}


}
