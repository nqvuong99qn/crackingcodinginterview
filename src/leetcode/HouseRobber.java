package leetcode;

public class HouseRobber {
	
	int solution(int[] nums) {
		
		// using Dynamic Programming
		
		// check input
		if(nums.length == 0) {
			return 0;
		}
		if(nums.length == 1) {
			return nums[0];
		}		
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		dp[1] = nums[0] > nums[1] ? nums[0] : nums[1];
		for(int i = 2; i < nums.length; i++) {
			dp[i] = Math.max(dp[i] + dp[i-2], dp[i-1]);
		}
		return dp[nums.length - 1];
	}
	
	
	
	public static void main(String[] args) {
		
		System.out.println("Say hi!!");
		
		
		
	}

}
