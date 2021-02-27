package leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;


public class LRUCache {
	
	int size;
	Map<Integer, Integer> map;
	
	public LRUCache(int size) {
		this.size = size;
		this.map = new LinkedHashMap<>();
	}
	
	int get(int key) {
		if(map.containsKey(key)) {
			int value = map.remove(key);
			map.put(key, value);
			return value;
		}
		return -1;
	}
	
	void put(int key, int value) {
		if(map.containsKey(key)) {
			map.remove(key);
		}
		else if(map.size() >= size) {
			map.remove(map.keySet().iterator().next());
		}
		map.put(key, value);
		
	}
	
	
	public static void main(String args[]) {
		
		
		System.out.println("sayhi !!!");
		
		LRUCache test = new LRUCache(2);
		
		test.put(2, 1);
		test.put(1, 2);
		test.put(3, 3);
		
		
		
		
		

//		map.put(1, 1);
//		Set<Integer> a = map.entrySet();
		
		
		
		
	}
}
