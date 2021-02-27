package javaPractice;

import java.util.Arrays;

public class MoveZeroes {

	public void moveZeroes(int[] nums) {
		
		int len = nums.length;
		
		int j = 0;
		for(int i = 1; i < len; i++) {
			if(nums[i] != 0) {
				nums[j] = nums[i];
				j++;
			}
		}
		j++;
		while(j < len) {
			nums[j] = 0;
			j++;
		}
	
	
		System.out.println("result" + Arrays.toString(nums));
	}
	
	
	public static void main(String args[]) {
		
		System.out.println("Say hi !!!" );
		
		
		int[] r1 = {0, 0, 0, 1, 0, 2, 3, 1};
		
		new MoveZeroes().moveZeroes(r1);
		
		
		
		
		
		
		
	}

}
