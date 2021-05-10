package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset2 {

	public List<List<Integer>> subsetsWithDup(int[] nums) {
		
		Arrays.sort(nums);
		
		List<List<Integer>> result = new ArrayList<>();
		if(nums.length == 0 || nums == null) {
			return result;
		}
		find(nums, new ArrayList<>(), 0, result);
		
		return result;

	}
	void find(int[] nums, List<Integer> curr, int index, List<List<Integer>> result) {
		result.add(curr);
		for(int i = index; i < nums.length; i++) {
			if(i > index && nums[i] == nums[i-1]) {
				continue;
			}
			List<Integer> newCurr = new ArrayList<>(curr);
			newCurr.add(nums[i]);
			find(nums, newCurr, i+1, result);
		}
	}


	public static void main(String[] args) {

		System.out.println("Say hi!!!!");

		Subset2 test = new Subset2();
		
		test.subsetsWithDup(new int[] {1, 2, 2});
		
	}

}
