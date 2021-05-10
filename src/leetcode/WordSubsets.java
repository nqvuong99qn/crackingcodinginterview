package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordSubsets {
	
	
	List<String> wordSubset(String[] A, String[] B){
		
		List<String> result = new ArrayList<>();
		int temp = 0;
		for(int i=0; i < A.length; i++) {
			for(String item : B) {
				if(!isSubset(item, A[i])) {
					temp = i + 1;
					break;
				}
			}
			if(temp - i == 1) {
				continue;
			}
			else {
				result.add(A[i]);
			}
		}
		return result;
	}
	boolean isSubset(String a, String b) {
		int i = 0;
		int j = 0;
		char[] ac = a.toCharArray();
		char[] bc = b.toCharArray();
		Arrays.sort(ac);
		Arrays.sort(bc);
				
		while(i < a.length() && j < b.length()) {
			if(ac[i] == bc[j]) {
				i++;
				j++;
			}
			else {
				j++;
			}
		}
		if(i == a.length()) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {

		System.out.println("Say hi!!");
		
		WordSubsets test = new WordSubsets();
		
		test.isSubset("da", "cdcabd");

	}

}
