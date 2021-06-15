package practice_23_05_2021;

public class BinarySearch {
	
	
	/**
	 * This class should be instantiated
	 */
	private BinarySearch() {}
	
	
	/**
	 * Return index of the specified key in  the specified array
	 * @param a array of integers, must be stored in ascending order
	 * @param key the search key
	 * @return index of key in array {@code a} if present; {@code -1} otherwise
	 */
	public static int indexOf(int[] arr, int key) {
		int lo = 0;
		int hi = arr.length - 1;
		while(lo < hi) {
			int mid = lo + (hi - lo) / 2;
			if(arr[mid] > key) {
				hi = mid - 1;
			}
			else if(arr[mid] < key) {
				lo = mid + 1;
			}
			else return mid;
		}
		return -1;
	}
	
	
	@Deprecated
	public static int rank(int key, int[] a) {
		return indexOf(a, key);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

    public static void main(String args[]) {
        System.out.println("ahihi");
    }

}