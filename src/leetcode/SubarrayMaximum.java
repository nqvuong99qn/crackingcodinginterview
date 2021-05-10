package leetcode;

public class SubarrayMaximum {
	
	
	int maxSumArray(int[] nums) {
		int len = nums.length;
		if(len == 1) {
			return nums[0];
		}
		int max = Integer.MIN_VALUE;
		int curr = 0;
		for(int i = 0; i < nums.length; i++) {
			curr += nums[i];
			max = Math.max(max, curr);
			if(curr < 0) {
				curr = 0;
			}	
		}
		return max;
	}
	
	
	
	public static void main(String[] args) {

		System.out.println("Say hi!!!!");

		Subset2 test = new Subset2();
		
		test.subsetsWithDup(new int[] {1, 2, 2});
		

	}

}
