package leetcode;

import java.util.HashMap;
import java.util.Map;
/*
 * Given a list of non-negative numbers and a target integer k, 
 * write a function to check if the array has a continuous subarray of size 
 * at least 2 that sums up to a multiple of k, that is, sums up to n*k where 
 * n is also an integer.
 * 
 *  Input: [23, 2, 4, 6, 7],  k=6
 * Output: True
 * Explanation: Because [2, 4] is a continuous subarray of size 2 and sums up to 6.
 * 
 *    Input: [23, 2, 6, 4, 7],  k=6 
 *    Output: True 
 *    Explanation: Because [23, 2, 6, 4, 7] is an continuous subarray of size 5 and sums up to 42.
 *    
 */


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
