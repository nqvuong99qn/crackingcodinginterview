package codility;

import java.util.HashSet;
import java.util.Set;

public class PrefixSums {
	int CountDiv(int A, int B, int K) {
		
		if(A % K != 0) {
			return B/K - A/K;
		}
		return B/K - A/K + 1;
	}
	
	
	
	// need to review !!!
	
	int[] GenomicRangeQuery(String S, int[] P, int[] Q) {
		int[] result = new int[P.length];
		
		int[] A = new int[S.length() + 1];
		int[] C = new int[S.length() + 1];
		int[] G = new int[S.length() + 1];
		int[] T = new int[S.length() + 1];
		
		for (int i = 0; i < S.length(); i++) {
            if(S.charAt(i) == 'A')
            {
                A[i+1] = A[i]+1;
                C[i+1] = C[i];
                G[i+1] = G[i];
                T[i+1] = T[i];
            }
            else if(S.charAt(i) == 'C')
            {
                A[i+1] = A[i];
                C[i+1] = C[i]+1;
                G[i+1] = G[i];
                T[i+1] = T[i];
            }
            else if(S.charAt(i) == 'G')
            {
                A[i+1] = A[i];
                C[i+1] = C[i];
                G[i+1] = G[i]+1;
                T[i+1] = T[i];
            }
            else if(S.charAt(i) == 'T')
            {
                A[i+1] = A[i];
                C[i+1] = C[i];
                G[i+1] = G[i];
                T[i+1] = T[i]+1;
            }
        }

        // to handle the queries
        int num_of_query = P.length; // or Q.length
        for (int i = 0; i < num_of_query; i++) {
            int a = A[ Q[i] + 1] - A[ P[i] ]; // num of 'a' between P and Q
            int c = C[ Q[i] + 1] - C[ P[i] ]; // num of 'c' between P and Q
            int g = G[ Q[i] + 1] - G[ P[i] ]; // num of 'g' between P and Q
            
            if(a > 0){ // there is 'a'
                result[i] = 1;
            }
            else if(c > 0){ // there is 'c'
                result[i] = 2;
            }
            else if(g > 0){ // there is 'g'
                result[i] =3;
            }
            else{ // there is only 'T'
                result[i] =4;
            }
        }

        return result;
	}
	
	int MinAvgTwoSlice(int[] A) {
		
		// trick
		// min average slice has length of 2 or 3
		float min = Integer.MAX_VALUE;
		int result = 0;
		for(int i = 0; i < A.length - 2; i++) {
			float avg2 = (float)(A[i] + A[i + 1]) / 2;
			float avg3 = (float)(A[i] + A[i + 1] + A[i + 2]) / 3;
			
			float currMin = Math.min(avg2, avg3);
			if(currMin < min) {
				min = currMin;
				result = i;
			}
		}
		// handle for final case
		float avg2final = (A[A.length - 2] + A[A.length - 1])/2;
		if(avg2final < min) {
			result = A.length - 2;
		}
		return result;
	}
	
	
	// best solution
	int PassingCars(int[] A) {
		int numEast = 0;
		int result = 0;
		for(int i = 0; i < A.length; i++) {
			if(A[i] == 0) {
				numEast++;
			}
			if(A[i] == 1) {
				result = result + numEast;
			}
		}
		return result;	
	}
	
	int test1(int[] A) {
		
		Set<Integer> set = new HashSet<>();
		
		int result = 0;
		for(int i = 0; i < A.length; i++) {
			if(!set.contains(A[i])) {
				result = i;
			}
		}
		return result;
		
	}
	
	
	public static void main(String[] args) {
		System.out.println("say hi!!");
		
		
		PrefixSums test = new PrefixSums();
		test.MinAvgTwoSlice(new int[] {4, 2, 2, 5, 1, 5, 8});
		
		
	}
	
	
			

}
