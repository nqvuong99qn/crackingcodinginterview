package codility;

import java.util.HashSet;
import java.util.Set;

public class PermutationCheck {
	
	int solution(int[] A) {
		
		Set<Integer> set = new HashSet<>();
		for(int c : A) {
			set.add(c);
		}
		for(int i = 1; i <= A.length; i++) {
			if(!set.contains(i))
				return 0;
		}
		return 1;
	}

}
