package mastercodinginterview;

import java.util.Arrays;

public class QuickSort {
	

		
	int partition(int[] arr, int l, int r) {
		
		int pivot = arr[r];
		int left = l;
		int right = r - 1;
		while(true) {
			while(left <= r && arr[left] < pivot) {
				left++;
			}
			while(right >= l && arr[right] > pivot) {
				right--;
			}
			if(left >= right)
				break;
			// swap 
			int temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			left++;
			right--;
		}
		int temp = arr[r];
		arr[r] = arr[left];
		arr[left] = temp;
		return left;
		
	}
	
	void quickSort(int[] arr, int l, int r ) {
		if(l < r) {
			int p = partition(arr,  l, r);
			quickSort(arr, l, p-1);
			quickSort(arr, p+1, r);
		}
		
	}
	
	
	
	
	
	public static void main(String[] args) {
		System.out.println("Say hi!!!!");
		
		int[] arr = {5, 4, 2, 3 ,6};
		
		QuickSort sort = new QuickSort();
		sort.quickSort(arr, 0, 4);
		System.out.println(Arrays.toString(arr));
		
		
	}

}
