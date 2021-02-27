package leetcode;

import java.util.Arrays;

public class ThreeSumSmaller {
	
	int solution(int[] arr, int target) {
		
		int len = arr.length;
		int count = 0;
		Arrays.sort(arr);
		for(int i = 0; i < len - 2; i++) {
			int left = i + 1;
			int right = len - 1;
			
			while(left < right) {
				if(arr[i] + arr[left] + arr[right] < target) {
					count += right - left;
					left++;
				}
				else {
					right--;
				}
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		System.out.println("Say hi!!!");
		
		ThreeSumSmaller test = new ThreeSumSmaller();
		
		int[] arr = {1, 2, 4, 5};
		int result = test.solution(arr, 9);
		System.out.println("Expected result:" + result);
	}

}
