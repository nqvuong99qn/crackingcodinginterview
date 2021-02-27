package leetcode;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharInString {
	
	int solution(String s) {
		
		Map<Character, Integer> map = new HashMap<>();
		
		
		int[] a;
	
		
		int len = s.length();
		for(int i = 0; i < len; i++) {
			if(map.containsKey(s.charAt(i))) {
				map.put(s.charAt(i), -1);
			}
			else map.put(s.charAt(i), i);
		}
		
		int minIndex = Integer.MAX_VALUE;
		for(char item : map.keySet()) {
			if(map.get(item) >  -1 && map.get(item) < minIndex){
				minIndex = map.get(item);
			}
		}
		return minIndex == Long.MAX_VALUE ? -1 : minIndex;
	}
	
	
	
	
	

	public static void main(String[] args) {

		System.out.println("say hi!!");
		
		FirstUniqueCharInString test = new FirstUniqueCharInString();
		

		System.out.println("Expected Result: " + test.solution("loveleetcode"));

	}
}
