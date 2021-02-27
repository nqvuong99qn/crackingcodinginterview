package codility;

import java.util.HashSet;
import java.util.Set;

public class Caterpillar {
	
	int AbsDistinc(int[] A) {
		Set<Integer> set = new HashSet<>();
		for(int i : A) {
			set.add(Math.abs(i));
		}
		return set.size();
	}
	
	
	
	

}
