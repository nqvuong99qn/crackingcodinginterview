package leetcode;

public class AddDigits {
	int solution(int num) {
		
		while(num >= 10) {	
			int temp = 0;
		
			while(num > 0) {
				temp += num % 10;
				num /= 10;
			}
			num = temp;
		}
		return num;
	}
	
	
	public static void main(String args[]) {
		
		System.out.println("Say hi!!");
		
		AddDigits test = new AddDigits();
		System.out.println("Expected result: " + test.solution(67));
		
		
		
		
	}
}
