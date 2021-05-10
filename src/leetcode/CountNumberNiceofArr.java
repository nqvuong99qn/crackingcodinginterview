package leetcode;

/*
 * Given an array of integers nums and an integer k. 
 * A continuous subarray is called nice if there are k odd numbers on it.
 * Return the number of nice sub-arrays.
 * 
 * 
 * Input: nums = [1,1,2,1,1], k = 3
 * Output: 2 
 * Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].
 */


public class CountNumberNiceofArr {
	
	int numberOf(int[] A, int k) {
		
		
		int res = 0, i = 0, count = 0, n = A.length;
        for (int j = 0; j < n; j++) {
            if (A[j] % 2 == 1) {
                --k;
                count = 0;
            }
            while (k == 0) {
                k += A[i++] & 1;
                ++count;
            }
            res += count;
        }
        return res;
		
	}
	
	public static void main(String args[]) {
		
		CountNumberNiceofArr test = new CountNumberNiceofArr();
		
		test.numberOf(new int[] {2,2,2,1,2,2,1,2,2,2}, 2);
		
		
		System.out.println(14 & 1);



	}

}
