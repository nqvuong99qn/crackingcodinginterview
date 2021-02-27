package codility;

public class BinarySearch {

	int minMaxDivision(int K, int M, int A[]) {

		int min = 0;
		int max = 0;
		int result = 0;
		for (int c : A) {
			min = Math.max(c, min);
			max += c;
		}
		while (min <= max) {

			// using mid = min + max / 2;
			int mid = (min + max) / 2;

			// using check divisable
			if (checkDivisable(mid, K, A)) {
				result = mid;
				max = mid - 1;
			} else {
				min = mid + 1;
			}
		}
		return result;
	}

	boolean checkDivisable(int mid, int K, int[] A) {
		int numofBlock = K;
		int tempSum = 0;
		for(int i = 0; i < A.length; i++) {
			tempSum += A[i];
			if(tempSum > mid) {
				numofBlock--;
				tempSum = A[i];
			}
			if(numofBlock == 0) {
				return false;
			}
		}
		return true;
	}

}
