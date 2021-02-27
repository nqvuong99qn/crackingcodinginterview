package leetcode;

import java.util.HashMap;
import java.util.Map;

//Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
//You may assume that the array is non-empty and the majority element always exist in the array.
public class MajorityElement {
	
	int solution(int[] A) {
		int len = A.length;
		if(len == 1) {
			return A[0];
		}
		Map<Integer, Integer> map = new HashMap<>();
		for(int i : A) {
			if(map.containsKey(i) && map.get(i) + 1 > len/2) {
				return i;
			}
			else if(map.containsKey(i)) {
				map.put(i, map.get(i) + 1);
			}
			else map.put(i, 1);
		}
		return -1;
	}

	public static void main(String[] args) {
		System.out.println("Say hi!!!");
		
		MajorityElement test = new MajorityElement();
		 
		System.out.println("Expected result: " + test.solution(new int[] {2, 2, 3, 3, 3}));
		
		
	}

}
