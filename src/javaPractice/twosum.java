package javaPractice;

import java.util.HashMap;
import java.util.Map;

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
