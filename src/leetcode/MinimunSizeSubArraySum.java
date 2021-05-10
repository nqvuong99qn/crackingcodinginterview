package leetcode;

public class MinimunSizeSubArraySum {
	
	int minSubArrayLen(int target, int[] nums) {
		
		int len = nums.length;
		int result = Integer.MAX_VALUE;
		for(int i = 0; i < len; i++) {
			int currSum = 0;
			for(int j = i; j < len; j++) {
				currSum += nums[j];
				if(currSum >= target) {
					result = Math.min(result, j-i+1);
				}
			}
		}
		return result == Integer.MAX_VALUE ? 0 : result;
	}

	// better solution
	int minSubSlideWindow(int target, int[] nums) {
		
		int len = nums.length;
		int currSum = 0;
		int id = 0;
		int result = 0;
		for(int i = 0; i < len; i++) {
			currSum += nums[i];
			while(currSum >= target) {
				result = Math.min(result, i - id + 1);
				currSum -= nums[id++];
			}
		}
		return result;
		
	}
	
	

}
