package codility;

import java.util.HashSet;
import java.util.Set;

public class Caterpillar {
	
	int AbsDistinc(int[] A) {
		Set<Integer> set = new HashSet<>();
		for(int i : A) {
			set.add(Math.abs(i));
		}
		return set.size();
	}
	
	boolean subArrayConsecutive(int[] A, int s) {
		
		int left = 0;
		int right = A.length - 1;
		
		int sum = 0;
		int i = 0;
		while(left < right) {
			sum += A[left++];
			
			if(sum > s) {
				sum -= A[i];
				i++;
			}
			if(sum == s) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		
		System.out.println("Say hi!!!");
		
		Caterpillar test = new Caterpillar();
		
		test.subArrayConsecutive(new int[] {1, 2, 3, 4}, 8);
		
		
	}
	
	
	
	

}
