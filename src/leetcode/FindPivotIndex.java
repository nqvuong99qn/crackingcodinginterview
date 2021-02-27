package leetcode;

public class FindPivotIndex {
	int pivotIndex(int[] nums) {
		int sumAll = 0;
		int leftSum = 0;
		
		for(int x : nums) sumAll += x;
		
		for(int i = 0; i < nums.length; i++) {
			if(leftSum == sumAll - leftSum - nums[i])
				return i;
			leftSum += nums[i];
		}
		return -1;
	}

}
