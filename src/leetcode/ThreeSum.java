package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	
	List<List<Integer>> threeSum(int[] nums) {
		
		Arrays.sort(nums);
		
		List<List<Integer>> result = new ArrayList<>();
		
		for(int i = 0; i < nums.length - 2; i++) {
			if(i > 0 && nums[i] == nums[i +1] ) {
				continue;
			}
			int j = i + 1;
			int k = nums.length - 1;
			int target = - nums[i];
			
			while(j < k) {
				if(nums[j] + nums[j] == target) {
					List<Integer> temp = new ArrayList<>();
					temp.add(nums[i]);
					temp.add(nums[j]);
					temp.add(nums[k]);
					result.add(temp);
					j++;
					k--;
					while(j < k && nums[j] == nums[j-1])	j++;
					while(j < k && nums[k] == nums[k+1])	k--;
				}
				else if(nums[j] + nums[j] > target) {
					k--;
				}
				else j++;
			}	
		}
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println("Say hi!!");
		
		ThreeSum test = new ThreeSum();
		
		
		
		
	}

}
