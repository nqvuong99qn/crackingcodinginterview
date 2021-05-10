package mastercodinginterview;

import java.util.Arrays;

public class MergeSort {
		
	void merge(int[] arr, int l, int m, int r) {
		// create temp array
		int[] temp = new int[r - l + 1];
		int i = l;
		int j = m + 1;
		int k = 0;
		
		while(i <= m && j <= r) {
			if(arr[i] <= arr[j]) {
				temp[k++] = arr[i++];
			}
			else {
				temp[k++] = arr[j++];
			}
		}
		while(i <= m) {
			temp[k++] = arr[i++];
		}
		while(j <= r) {
			temp[k++] = arr[j++];
		}
		for(i = l; i <= r; i++) {
			arr[i] = temp[i-l];	
		}
	}
	void sort(int[] arr, int l, int r) {
		if(l < r) {
			int m = (l + r) / 2;
			sort(arr, l, m);
			sort(arr, m + 1, r);
			merge(arr, l, m, r);
		}
	}
	
	public static void main(String[] args) {
		
		int[] arr = { 51,1,1,1,1,1, 4, 2, 7, 8};
		
		MergeSort sort = new MergeSort();
		
		sort.sort(arr, 0, arr.length-1);
		
		System.out.println(Arrays.toString(arr));
		

		
		System.out.println("Say hi!!!!!!!!");
		
		
		
	}

}
