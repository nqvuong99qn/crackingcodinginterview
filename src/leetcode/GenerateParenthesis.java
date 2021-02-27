package leetcode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
	public List<String> generate(int n){
		List<String> result = new ArrayList<>();
		generateRecursion(result, "", 0, 0, n);
		return result;
	}
	void generateRecursion(List<String> result, String curr, int open, int close, int n) {
		if(curr.length() == n * 2) {
			result.add(curr);
			return;
		}
		
		if(open < n) {
			generateRecursion(result, curr + "(", open+1, close, n);
		}
		if(close < open) {
			generateRecursion(result, curr + ")", open, close+1, n);
		}
	}

}
