package leetcode;

import java.util.HashMap;
import java.util.Map;

public class SubArrayEqualK {
	
	public int subarraySum(int[] nums, int k) {
		
		
		int count = 0;

		for(int i = 0; i < nums.length; i++) {
			int sum = 0;
			for(int j = i; j < nums.length; j++) {
				sum += nums[j];
				if(sum == k)
					count++;
			}
		}
		return count;
	}
	
	// using hashMap
	public int subarraySum2(int[] nums, int k) {	
		
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		int sum = 0;
		int count = 0;
		for(int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if(map.containsKey(sum - k))
				count += map.get(sum - k);
			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}
		return count;
	}
	
	public static void main(String args[]) {
		System.out.println("Say hi!!");
		
		SubArrayEqualK test = new SubArrayEqualK();
		test.subarraySum2(new int[] {1,3,5,7,9}, 8);
	}

}
