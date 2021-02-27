package mastercodinginterview;

import java.util.HashMap;
import java.util.Map;

public class ArraysSection {

	public String reverse(String str) {

		if (str.length() < 2) {
			throw new IllegalArgumentException("Please check input parameter!");
		}
		int len = str.length();
		String result = new String();
		for (int i = 0; i < len; i++) {
			result = result + str.charAt(len - i - 1);
		}
		return result;
	}

	// assume sorted list

	public int[] twoSum(int[] nums, int target) {

		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			int check = target - nums[i];
			if (map.containsKey(check)) {
				return new int[] { i, map.get(check) };
			}
			map.put(nums[i], i);
		}
		return null;

	}

	// two point
	public int[] twoSum1(int[] nums, int target) {
		
		int len = nums.length;
		
		int firstId = 0;
		int lastId = len - 1;
		
		while(firstId < lastId) {
			int check = nums[firstId] + nums[lastId] - target;
			if(check == 0) {
				return new int[] {firstId, lastId};
			}
			else if(check > 0) {
				lastId--;
			}
			else{
				firstId++;
			}
		}
		return null;
	}

	public static void main(String[] args) {

		System.out.println("Say hi!!!");

		String result = new ArraysSection().reverse("anh yeu em");
		System.out.println("Expected: " + result);

	}
}
