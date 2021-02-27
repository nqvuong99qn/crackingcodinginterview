package leetcode;

import java.util.Arrays;

public class ThreeSumClosest {
	
	
	int solution(int[] nums, int target) {
		
		int min = Integer.MAX_VALUE;
		int result = 0;
		Arrays.sort(nums);
		for(int i = 0; i < nums.length; i++) {
			int left = i + 1;
			int right = nums.length - 1;
			while(left < right) {
				int check = nums[i] + nums[left] + nums[right] - target;
				if(Math.abs(check) < min) {
					min = Math.abs(check);
					result = target + check;
				}
				if(check == 0)
					return target;
				if(check > 0) {
					right--;
				}
				else {
					left++;
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println("Say hi!!");
		
		ThreeSumClosest test = new ThreeSumClosest();
		
		test.solution(new int[] {1,2,5,10,11}, 12);
	}

}
