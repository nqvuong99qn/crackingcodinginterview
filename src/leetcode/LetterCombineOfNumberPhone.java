package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mastercodinginterview.ArraysSection;

public class LetterCombineOfNumberPhone {
	
	Map<Character, List<Character>> map = new HashMap<>();
	
	
	
	

	List<String> solution(String number){
		//create map
		map.put('0', new ArrayList<>('0'));
		map.put('1', new ArrayList<>('1'));
		map.put('2', new ArrayList<>(Arrays.asList('a', 'b', 'c')));
		map.put('3', new ArrayList<>(Arrays.asList('d', 'e', 'f')));
		map.put('4', new ArrayList<>(Arrays.asList('g', 'h', 'i')));
		map.put('5', new ArrayList<>(Arrays.asList('j', 'k', 'l')));
		map.put('6', new ArrayList<>(Arrays.asList('m', 'n', 'o')));
		map.put('7', new ArrayList<>(Arrays.asList('p', 'q', 'r', 's')));
		map.put('8', new ArrayList<>(Arrays.asList('t', 'u', 'v')));
		map.put('9', new ArrayList<>(Arrays.asList('w', 'x', 'y', 'z')));
		
		
		List<String> result = new ArrayList<>();
		if(number.length() == 0 || number == null) {
			return result;
		}
		String[] mapping = { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		
		find(result, number, "", 0, mapping);
		
		return result;
	
	}
	void find(List<String> result, String number, String curr, int index, String[] mapping) {
		if(index == number.length()) {
			result.add(curr);
			return;
		}
		String letters = mapping[number.charAt(index) - '0'];
		for(int i = 0; i < letters.length(); i++) {
			find(result, number, curr + letters.charAt(i), index + 1, mapping);
		}
	}
	
	
	
	
	
	public static void main(String[] args) {

		System.out.println("say hi!!");

		LetterCombineOfNumberPhone test = new LetterCombineOfNumberPhone();
				
		System.out.println("Expected Result: " + test.solution("234").toString());

	}

}
