package javaPractice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class twosum {

	// naive solution!!!
//	public int[] twoSum(int[] nums, int target) {
//		int len = nums.length;
//		for(int i = 0; i < len; i++) {
//			for(int j = i + 1; j < len; j++) {
//				if(nums[i] + nums[j]  == target) {
//					return new int[] {i, j};
//				}
//			}
//		}
//		return null;
//	}
//
	// naive approach
	// O(n2): Time Complexity
	// O(1): Space Complexity
	public boolean twosum1(int[] nums, int target) {

		int len = nums.length;

		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j < len; j++) {
				if (nums[i] + nums[j] == target) {
					return true;
				}
			}
		}
		return false;
	}

	// better approach
	// O(nlog(n): Time complexity
	// O(1): Space Complexity
	public boolean twosum2(int[] nums, int target) {

		Arrays.sort(nums); // O(nlog(n))
		int lastIndex = nums.length - 1;
		int firstIndex = 0;
		while (firstIndex < lastIndex) {
			int check = nums[firstIndex] + nums[lastIndex] - target;
			if (check == 0) {
				return true;
			} else if (check > 0) {
				lastIndex--;
			} else
				firstIndex++;
		}
		return false;
	}

	// optimal solution
	// evaluate:
	// O(n): time complexity
	// O(n): space complexity
	public boolean twosum3(int[] nums, int target) {

		Set set = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			if (set.contains(target - nums[i])) {
				return true;
			}
			set.add(nums[i]);
		}
		return false;
	}

	public int[] twoSum(int[] nums, int target) {

		Map<Integer, Integer> map = new HashMap<>();

		map.put(nums[0], 0);
		for (int i = 1; i < nums.length; i++) {
			int temp = target - nums[i];
			if (map.containsKey(temp)) {
				return new int[] { i, map.get(temp) };
			}
			map.put(nums[i], i);
		}

		return null;
	}

	public static void main(String[] args) {
		System.out.println("Say hi!!!!");

		twosum solution = new twosum();
		// init data
		int[] arr = new int[4];
		arr[0] = 7;
		arr[1] = 6;
		arr[2] = 5;
		arr[3] = 7;

		int[] result = solution.twoSum(arr, 14);
		System.out.println("Expected: " + "[" + result[0] + "," + result[1] + "]");

	}

}
