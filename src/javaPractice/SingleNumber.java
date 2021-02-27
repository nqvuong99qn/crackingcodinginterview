package javaPractice;

import java.util.Arrays;

public class SingleNumber {
	
	int singleNumber(int[] nums) {

		Arrays.sort(nums);
			
		int temp = 1;
		for(int i = 1; i < nums.length; i++) {
			if(nums[i] == nums[i-1]) {
				temp++;
			}
			else {
				if(temp == 1) {
					return nums[i-1];
				}
				else temp = 1;
			}
		}
		return nums[nums.length - 1];
			
	}
	
	
	public static void main(String[] args) {
		System.out.println("Say hi!!!!");

		SingleNumber solution = new SingleNumber();
		// init data
		int[] arr = {4, 1, 3, 4, 3};
		

		System.out.println("Expected: " + solution.singleNumber(arr));
		
	}


}
