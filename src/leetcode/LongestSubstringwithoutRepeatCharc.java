package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class LongestSubstringwithoutRepeatCharc {

	int lengof(String s) {
		
		int result = 0;
		Queue<Character> q = new LinkedList<>();
		
		for(char item : s.toCharArray()) {
			while(q.contains(item)) {
				q.poll();
			}
			q.offer(item);
			result = Math.max(result, q.size());
		}
		return result;
	}
	
	
	int lengOfUsingSet(String s) {
		
		Set<Character> set = new HashSet<>();
		int count = 0;
		int max = 0;
		for(int i = 0; i < s.length(); i++) {
			if(set.contains(s.charAt(i))) {
				count = 1;
				set.removeAll(set);
			}
			else {
				set.add(s.charAt(i));
				count++;
				max = Math.max(max, count);
			}
		}
		
		return max;
	}

	public static void main(String args[]) {

		LongestSubstringwithoutRepeatCharc test = new LongestSubstringwithoutRepeatCharc();

		test.lengOfUsingSet("abcade");

	}

}
