package javaPractice;

public class PlusOne {
	
	public int[] plus_1(int[] degits) {
		
		// convert to decimal
		int len = degits.length;
		int temp = 0;
		for(int i = 0; i < len; i++) {
			temp = (int) (temp + degits[i] * Math.pow(10, len - i -1));
		}
		
		// plus one
		temp++;
		
		
		// check the number of digit after plus
		if(temp == (10^(len))){
			len++;
			int[] arr = new int[len];
			arr[0] = 1;
			for(int i = 1; i < len; i++) {
				arr[i] = 0;
			}	
			return arr;
		}
		else {
			int id = len;
			while(temp > 0) {
				degits[id-1] = temp % 10;
				temp /= 10;
				id--;
			}
			
			return degits;
			
		}
		
		
	}
	
	
	public static void main(String args[] ) {
		System.out.println("Say hi !!!");
		
		int[] r1 = {4, 2, 3};
		
		
		PlusOne solution = new PlusOne();
		solution.plus_1(r1);
		
		System.out.println("Expected: " );
		
	}

}
