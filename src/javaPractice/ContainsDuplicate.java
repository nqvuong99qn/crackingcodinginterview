package javaPractice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
	
	// using set. 
//	public boolean containsDuplicate(int[] nums) {
//		if(nums.length == 0)
//			return false;
//		Arrays.sort(nums);
//		Set set = new HashSet<>();
//		set.add(nums[0]);
//		for(int i = 1; i < nums.length; i++) {
//			if(set.contains(nums[i]))
//				return true;
//			set.add(nums[i]);
//		}
//		return false;
//	}
	
	// more simple
	public boolean containsDuplicate(int[] nums) {
		if(nums.length == 0)
			return false;
		Arrays.sort(nums);
		for(int i = 1; i < nums.length; i++) {
			if(nums[i] == nums[i-1]) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println("Say hi!!!!");

		ContainsDuplicate solution = new ContainsDuplicate();
		// init data
		int[] arr = new int[4];
		arr[0] = 7;
		arr[1] = 6;
		arr[2] = 5;
		arr[3] = 7;

		System.out.println("Expected: " + solution.containsDuplicate(arr));
		
	}

}
