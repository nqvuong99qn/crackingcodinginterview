package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class GroupAnagrams {
	
	List<List<String>> solution(String[] strings){
		
		Arrays.sort(strings);
		Map<String, List<String>> map = new HashMap<>();
		
		for(String s : strings) {
			
			char[] temp = s.toCharArray();
			Arrays.sort(temp);
			String key = String.valueOf(temp);
			
			if(!map.containsKey(key)) {
				map.put(key, new ArrayList<String>());
			}
			map.get(key).add(s);
		}
		
		return new ArrayList<List<String>>(map.values());
	}
	
	
	
	

	public static void main(String[] args) {

		System.out.println("say hi!!");

		GroupAnagrams test = new GroupAnagrams();

		String[] strings = {"ate", "eta", "ban", "abn"};
		System.out.println("Expected Result: " + test.solution(strings).toString());

	}

}
