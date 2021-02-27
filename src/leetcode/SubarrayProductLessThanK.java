package leetcode;

public class SubarrayProductLessThanK {
	
	
	// using two pointer
	public int Solution(int[] nums, int k) {
		
		int i = 0;
		int j = 0;
		long p = 1l;
		int count = 0;
		
		while(j < nums.length) {
			p *= nums[j];
			while(j >= i && p >= k) {
				p = p / nums[i];
				i++;
			}
			count += (j - i + 1);
			
		}
		return count;
		
		

	}

}
