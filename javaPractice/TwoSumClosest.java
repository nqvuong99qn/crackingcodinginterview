package javaPractice;

import java.util.Arrays;

public class TwoSumClosest {
	
	
	public int[] twosum(int[] r1, int[] r2, int target) {
		// sort two arrays
		Arrays.sort(r1);
		Arrays.sort(r2);
		
		int idr1 = r1.length - 1;
		int idr2 = 0;
		
		int smallestDis = Math.abs(r1[idr1] + r2[idr2] - target);
		
		int[] result = {r1[idr1], r2[idr2]};
		
		while(idr1 >= 0 && idr2 < r1.length) {
			int temp = r1[idr1] + r2[idr2] - target;
			if(Math.abs(temp) < smallestDis) {
				smallestDis = Math.abs(temp);
				result[0] = r1[idr1];
				result[1] = r2[idr2];
			}
			if(temp == 0) {
				return result;
			}
			
			else if(temp > 0)
				idr1--;
			else
				idr2++;
			
		}
		return result;
	}
	
	
	public static void main(String args[] ) {
		System.out.println("Say hi !!!");
		
		int[] r1 = {4, 2, 3, 7, 1};
		int[] r2 = {1, 2, 3, 4, 5};
		
		
		TwoSumClosest solution = new TwoSumClosest();
		
		int[] result = solution.twosum(r1, r2, 9);
		System.out.println("Expected: " + result[0] + " , " + result[1]);
		
	}

}
