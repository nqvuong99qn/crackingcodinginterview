package javaPractice;

public class PlusOne {
	
	public int[] plus_1(int[] degits) {
		
		// check special case
		// two cases:
		// 		9, 99, 999, ,,,,
		// 12, 34, 54,.....
		
		int len = degits.length;
		
		for(int i = len - 1; i >= 0; i--) {
			if(degits[i] < 9) {
				degits[i]++;
				return degits;
			}
			degits[i] = 0;
			
		}
		int[] result = new int[len + 1];
		result[0] = 1;
		
		return result;
	}
	
	
	public static void main(String args[] ) {
		System.out.println("Say hi !!!");
		
//		int[] r1 = {4, 2, 3};
//		
//		
//		PlusOne solution = new PlusOne();
//		solution.plus_1(r1);
		
		System.out.println("Expected: " );
		
		int[] r1 = new int[]{1, 2, 3};
		
		int[] r2 = new int[4];
		
		System.out.println("Expected: " + r2[3]);
		
		
	}

}
