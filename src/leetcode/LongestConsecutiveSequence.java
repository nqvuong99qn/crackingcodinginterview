package leetcode;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
	
	int longestConsecutive(int[] nums) {
		if(nums.length == 0 || nums == null) {
			return 0;
		}
		Set<Integer> set = new HashSet<>();
		for(int item : nums) {
			set.add(item);
		}
		int result = 0;
		for(int item : set) {
			if(!set.contains(item-1)) {
				int currMax = 1;
				while(set.contains(item+1)) {
					item++;
					currMax++;
				}
				result = Math.max(result, currMax);
			}
		}
		
		return result;
	}

}
