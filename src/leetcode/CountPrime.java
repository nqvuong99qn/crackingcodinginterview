package leetcode;

public class CountPrime {
	
	// naive solution
	int countNaive(int n) {
		int count = 0;
		for(int i = 2; i < n; i++) {
			if(isPrime(i)) {
				count++;
			}
		}
		return count;
	}
	boolean isPrime(int n) {
		int i = 2;
		while(i * i < n) {
			if(n % i == 0)
				return false;
		}
		return true;
	}
	
	
	// best solution
	int countBestSol(int n) {
		boolean[] temp = new boolean[n];
		int count = 0;
		for(int i = 2; i < n; i++) {
			if(!temp[i]) {
				count++;
			}
			for(int j = 2; j * i < n; j++) {
				temp[j] = true;
			}
		}
		return count;
	}
	

}
