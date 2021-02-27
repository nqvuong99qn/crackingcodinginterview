package leetcode;

public class ReverserWord {
	String solution(String s) {
		String[] words = s.trim().split("\\s+");
		String result = "";
		for(int i = words.length - 1; i > 0; i--) {
			result += words[i] + " ";
		}
		return result + words[0];
	}

	public static void main(String[] args) {

		System.out.println("say hi!!");

		ReverserWord test = new ReverserWord();

		System.out.println("Expected result: " + test.solution("Bob hit a ball, the hit BALL flew far after it was hit."));
		
		String s = "Bob hit a ball, the hit BALL flew far after it was hit.";
		String[] strings = s.split(s);
		

	}

}
