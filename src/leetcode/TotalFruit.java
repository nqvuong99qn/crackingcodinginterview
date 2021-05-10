package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TotalFruit {
	
	int totalFruit(int[] tree) {
		
		Map<Integer, Integer> map = new HashMap<>();
		int id = 0;
		int max = 0;
		for(int i = 0; i < tree.length; i++) {
			map.put(tree[i], map.getOrDefault(tree[i], 0) + 1);
			while(map.keySet().size() > 2) {
				map.put(tree[id], map.get(tree[id]) -1 );
				if(map.get(tree[id]) == 0) {
					map.remove(tree[id]);
				}
				id++;
			}
			max = Math.max(max, i - id + 1);
		}
		return max;
		
		
	}
	
	public static void main(String args[]) {
		
		TotalFruit test = new TotalFruit();
		
		test.totalFruit(new int[] {3,3,3,1,2,1,1,2,3,3,4});



	}

}
