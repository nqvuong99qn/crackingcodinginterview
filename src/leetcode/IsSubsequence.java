package leetcode;

public class IsSubsequence {
	
	boolean isSubsequence(String s, String t) {
		if(s.length() > t.length()) {
			return false;
		}
		int id = 0;
		char[] s_ = s.toCharArray();
		char[] t_ = t.toCharArray();
		
		int lenS = s.length();
		int lenT = t.length();
		
		int i = 0;
		int j = 0;
		while(i < lenS && j < lenT) {
			if(s_[i] == t_[j]) {
				i++;
				j++;
			}
			else {
				j++;
			}
		}
		return i == lenS ? true : false;
	}
	
	public static void main(String[] args) {
		
		System.out.println("Say hi!!!!");
		
		IsSubsequence test = new IsSubsequence();
		
		test.isSubsequence("aec", "abce");
		
		
	}
	
	

}
