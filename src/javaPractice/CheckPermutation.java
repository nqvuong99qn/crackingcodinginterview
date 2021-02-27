package javaPractice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// 	problem
//	Given two strings,write a method to decide if one is a permutation of the
//	other.

public class CheckPermutation {
	
	
	
	// method 1: naive solution
	boolean checkPermutation(String a, String b) {
		
		// check length of string
		int len = a.length();
		if(len != b.length()) {
			throw new IllegalArgumentException("Wrong input parameter!");
		}
		for(int i = 0; i < len; i++) {
			if(!b.contains(a.subSequence(i, i+1)))
				return false;	
		}		
		return true;
	}
	
	//method 2: better solution
	boolean checkPermutation_better(String a, String b) {
		int len = a.length();
		if(len != b.length()) {
			throw new IllegalArgumentException("Wrong input parameter!");
		}
		char[] arr_a = a.toCharArray();
		char[] arr_b = b.toCharArray();
		
		Arrays.sort(arr_a);
		Arrays.sort(arr_b);
		for(int i = 0; i < len; i++) {
			if(arr_a[i] != arr_b[i])
				return false;
		}
		return true;
	}
	
	// method 3; Using set
	boolean checkPermutationBest(String a, String b) {
		
		int len = a.length();
		if(len != b.length()) {
			throw new IllegalArgumentException("Wrong input parameter!");
		}
		Map<Character, Integer> map = new HashMap<>();
		
		
		for(int i = 0; i < len; i++) {
			if(map.containsKey(a.charAt(i)))
				map.replace(a.charAt(i), map.get(a.charAt(i)) + 1);
			else map.put(a.charAt(i), 1);
		}
		
		for(int i = 0; i < len; i++) {
			if(!map.containsKey(b.charAt(i)))
				return false;
			if(map.get(b.charAt(i)) - 1 < 0) {
				return false;
			}
			map.replace(b.charAt(i), map.get(b.charAt(i)) - 1);
		}
		
		
		return true;
	}
	
	// Using like hash Map
	boolean check(String a, String b) {
		
		// check size
		if(a.length() != b.length())
			return false;
		
		int[] char_set = new int[128];
		char[] arr = a.toCharArray();
		for(char item : arr) {
			char_set[item]++;
		}
		
		// check
		for(int i = 0; i < b.length(); i++) {
			char_set[b.charAt(i)]--;
			if(char_set[b.charAt(i)] < 0)
				return false;
		}
		
		
		
		
		return true;
	}
	
	
	public static void main(String[] args) {
		
		System.out.println("Say hi!!!");
		
		CheckPermutation check = new CheckPermutation();
		boolean result = check.check("abbba", "aabbb");
		
		System.out.println("Expected result: " + result);


		
	}
	

}
