package leetcode;

public class MaxConsecutiveOnes {

	
	// find max substring have most K zeros
	public int longestOnes(int[] A, int K) {
		
		int i = 0;
		int j;
		for(j = 0; j < A.length; j++) {
			if(A[j] == 0)
				K--;
			if(K < 0 && A[i++] == 0) {
				K++;
			}
		}
		return j - i;
		
	}

}
