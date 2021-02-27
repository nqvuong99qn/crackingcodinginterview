package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
	
	int len = 0;
	public List<List<Integer>> fourSum(int[] nums, int target){
		len = nums.length;
		Arrays.sort(nums);
		return kSum(nums, target, 0, 4);
	}
	List<List<Integer>> kSum(int[] nums, int target, int index, int k){
		List<List<Integer>> result = new ArrayList<>();
		
		if(index >= len) {
			return result;
		}
		if(k == 2) {
			int left = index;
			int right = len - 1;
			while(left < right) {
				if(target == nums[left] + nums[right]) {
					List<Integer> temp = new ArrayList<>();
					temp.add(nums[left]);
					temp.add(nums[right]);
					result.add(temp);
					while(left < right && nums[left] == nums[left+1]) left++;
					while(left < right && nums[right] == nums[right-1]) right--;
					left++;
					right--;
				}
				else if(target > nums[left] + nums[right]) {
					left++;
				}
				else {
					right--;
				}
			}
		}
		else {
			for(int i = index; i < len - k + 1; i++) {
				List<List<Integer>> temp = kSum(nums, target - nums[i], i+ 1, k-1);
				if(temp != null) {
					for(List<Integer> t : temp) {
						t.add(0, nums[i]);
					}
					result.addAll(temp);
				}
				while(i < len - 1 && nums[i] == nums[i+1]) {
					i++;
				}
				
			}
		}
		return result;
	}
	
	

}
