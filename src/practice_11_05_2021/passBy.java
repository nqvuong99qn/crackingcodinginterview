package practice_11_05_2021;

import java.util.Arrays;

public class passBy {
	
	
	static int[] checkPassByValue(int[] arr) {
		arr[0]++;
		return arr;
	}
	
	public static void main(String args[]) {
		
		System.out.println("say hi!!!");
		
		int[] curr = {5};
		System.out.println(Arrays.toString(curr));
		System.out.println(Arrays.toString(passBy.checkPassByValue(curr)));
		System.out.println(Arrays.toString(curr));
		
	
	}

}
