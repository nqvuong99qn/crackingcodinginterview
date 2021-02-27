package codility;

import java.util.HashSet;
import java.util.Set;

public class TapeEquilibrium {
	
	int solution(int[] A) {
		int sum = 0;
		for(int c : A) sum += c;
		
		int result = Integer.MAX_VALUE;
		int leftSum = 0;
		int rightSum = 0;
		for(int i = 1; i < A.length; i++) {
			leftSum = leftSum + A[i - 1];
			rightSum = sum - leftSum;
			result = Math.min(result, Math.abs(leftSum-rightSum));
		}		
		return result;
	}
	
	int	solution2(int X, int[] A) {
		Set<Integer> set = new HashSet<>();
		for(int i = 1; i <= X; i++) {
			set.add(i);
		}
		for(int i = 0; i < A.length; i++) {
			if(set.contains(A[i])){
				set.remove(A[i]);
			}
			if(set.isEmpty())
				return i;
		}
		return -1;
	}

}
