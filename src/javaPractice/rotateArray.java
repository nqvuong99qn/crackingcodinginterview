package javaPractice;

public class rotateArray {
	
	public void rotate(int[] nums, int k) {
		int[] arr = new int[nums.length];
		for(int i  = 0; i < nums.length; i++) {
			arr[(i + k) % nums.length] = nums[i];
		}
		for(int i = 0; i < arr.length; i++) {
			nums[i] = arr[i];
		}
		
	}
	
	
	public static void main(String[] args) {
		System.out.println("Say hi!!!!");

		rotateArray solution = new rotateArray();
		// init data
		int[] arr = new int[7];
		arr[0] = 7;
		arr[1] = 6;
		arr[2] = 5;
		arr[3] = 4;
		arr[4] = 3;
		arr[5] = 2;
		arr[6] = 1;

		System.out.println("Expected: ");
		solution.rotate(arr, 3);
	}
}
