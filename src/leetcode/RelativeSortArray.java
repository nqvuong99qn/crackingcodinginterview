package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RelativeSortArray {
	
	int[] solution(int[] arr1, int[] arr2) {
		
		Map<Integer, Integer> map = new HashMap<>();
		for(int item : arr1) {
			if(map.containsKey(item)) {
				map.put(item, map.get(item) + 1);
			}
			else map.put(item, 1);
		}
		//
		int[] result = new int[arr1.length];
		int id = 0;
		for(int item : arr2) {
			int check = map.get(item);
			while(check > 0) {
				result[id++] = item;
				check--;
			}
			map.remove(item);
		}
		
		// additional array
		int[] temp = new int[arr1.length  - id];
		int idTemp = 0;
		for(int item : map.keySet()) {
			int check = map.get(item);
			while(check > 0) {
				temp[idTemp++] = item;
				check--;
			}
		}
		//sort temp
		Arrays.sort(temp);
		// combine to result
		idTemp = 0;
		while(id < arr1.length) {
			result[id++] = temp[idTemp++];
		}
		return result;
	}

}
