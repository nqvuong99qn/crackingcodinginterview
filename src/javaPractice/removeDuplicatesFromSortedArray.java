package javaPractice;
public class removeDuplicatesFromSortedArray {
	
	int removeDuplicates(int[] arr) {
		int result = 1;
		for(int i = 1; i < arr.length; i++) {
			while(arr[i] == arr[i-1]) {
				i++;
				if(i >= arr.length)
					return result;
			}
			arr[result] = arr[i];
			result++;
			
		}
		return result;
	}
	
	// best to use
	// easy to read
	// best perfomance
	int removeDuplicates_v1(int[] arr) {
		int len = arr.length;
		
		int i = 0;
		for(int j = 1; j < len; j++) {
			if(arr[j] != arr[i]) {
				i++;
				arr[i] = arr[j];
			}
		}
		return i + 1;
	}

	public static void main(String[] args) {
		System.out.println("Say hi!!!!");

		removeDuplicatesFromSortedArray solution = new removeDuplicatesFromSortedArray();
		// init data
		int[] arr = new int[7];
		arr[0] = 0;
		arr[1] = 0;
		arr[2] = 1;
		arr[3] = 1;
		arr[4] = 4;
		arr[5] = 4;
		arr[6] = 4;

		//System.out.println("Expected: " + solution.removeDuplicates(arr));
		System.out.println("Expected_v1: " + solution.removeDuplicates_v1(arr));

	}
	

}