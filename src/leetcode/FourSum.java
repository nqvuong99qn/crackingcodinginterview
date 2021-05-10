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
	
	
	List<List<Integer>> FiveSum(int[] arr, int target){
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(arr.length == 0)
			return result;
		return KsumV1(arr, target, 0, 5);
	}
	List<List<Integer>> KsumV1(int[] arr, int target, int index, int K){
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(index > arr.length - 1)
			return result;
		if(K == 2) {
			// two poiter here
			int left = index;
			int right = arr.length - 1;
			while(left < right) {
				List<Integer> temp = new ArrayList<Integer>();
				int check = target - arr[left] - arr[right];
				if(check == 0) {
					temp.add(arr[left]);
					temp.add(arr[right]);
					result.add(temp);
					while(left < right && arr[left] == arr[left+1]) left++;
					while(left < right && arr[right] == arr[right-1]) right--;
					left++;
					right--;
				}
				else if(check > 0) {
					left++;
				}
				else right--;
			}
		}
		else {
			for(int i = index; i < arr.length - K + 1; i++) {
				List<List<Integer>> temp = KsumV1(arr, target - arr[i], index + 1, K - 1);
				if(temp != null) {
					for(List<Integer> item : temp) {
						item.add(arr[i]);
					}
					result.addAll(temp);
				}
				while(i < arr.length - 1 && arr[i] == arr[i+1]) i++;
			}
		}
		return result;
	}
	
	
	public static void main(String[] args) {
		System.out.println("ahihi");
		
		FourSum test = new FourSum(); 
		
		int[] arr = {-2, 1, -1, 2, 0, 0};
		
		List<List<Integer>> result = test.FiveSum(arr, 0);
	}
	

}
