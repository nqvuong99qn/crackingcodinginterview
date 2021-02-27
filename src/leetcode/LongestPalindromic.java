package leetcode;

public class LongestPalindromic {

	// naive solution
	String solution(String s) {
		// check input
		if(s.length() == 0 || s == null) {
			return "";
		}
	
		String result = "";
		for(int i = 0; i < s.length(); i++) {
			for(int j = i + 1; j < s.length(); j++) {
				if (isPalindrom(s.substring(i, j)) && j - i > result.length() ) {
					result = s.substring(i, j);
				}
			}
		}
		return  result;
	}
	boolean isPalindrom(String s) {
		int i = 0;
		int j = s.length() -1;
		while(i < j) {
			if(s.charAt(i++) != s.charAt(j--))
				return false;
		}
		return true;
	}
	
	
	//best solution
	String solution2(String s) {
		String max = "";
		for(int i = 0; i < s.length(); i++) {
			String s1 = extend(s, i, i);
			String s2 = extend(s, i, i + 1);
			if(s1.length() > max.length()) max = s1;
			if(s2.length() > max.length()) max = s2;
		}
		return max;
	}
	String extend(String s, int i, int j) {
		for(;i >= 0 && j < s.length();i--, j++) {
			if(s.charAt(i) != s.charAt(j)) break;
		}
		return s.substring(i+1, j);
	}
	

	void reverseWord(char[] c, int left, int right) {
		while(left < right) {
			char temp = c[left];
			c[left++] = c[right];
			c[right--] = temp;
		}
	}

	String reverseWords(String s) {
		char[] c = s.toCharArray();
		int left = 0;
		int right = 0;
		for(;right < c.length; right++) {
			if(c[right] == ' ') {
				reverseWord(c, left, right - 1);
				left = right + 1;
			}
		}
		reverseWord(c, left, right -1);
		return new String(c);
		
	}
	
	String interpret(String s) {
		
		int i = 0;
		String result = "";
		if(s.contains("()")) {
			result = s.replace("()", "o");
			
		}
		if(s.contains("(al)")) {
			result = result.replace("(al)", "al");
		}
		return result;
					
	}
	public static void main(String[] args) {

		System.out.println("say hi!!");
		
		LongestPalindromic test = new LongestPalindromic();
		
		System.out.println("Expected result: " + test.solution("121213"));
		
		test.interpret("G()()()()(al)");



	}

}
