package leetcode;

import java.util.HashMap;
import java.util.Map;



public class checkSubarraySum {
	
	boolean check(int[] nums, int k) {
		if(nums.length < 2) {
			return false;
		}
		
		int currSum = 0;
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		
		for(int i = 0; i < nums.length; i++) {
			currSum += nums[i];
			if(k !=0 ) {
				currSum = currSum % k;
			}
			if(map.containsKey(currSum)) {
				if(i - map.get(currSum) > 1) {
					return true;
				}
			}
			else map.put(currSum, i);
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println("say hi!!");
		
		checkSubarraySum test = new checkSubarraySum();
		
		test.check(new int[]{2, 4, 5, 6}, 6);
	}
	
	

}
