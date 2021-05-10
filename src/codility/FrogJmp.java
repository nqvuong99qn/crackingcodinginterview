package codility;

public class FrogJmp {
	
	int solution(int X, int Y, int D) {
		if((Y - X) % D != 0) {
			return (Y - X) / D + 1;
		} 
		return (Y - X) / D;
		
	}
	
	
	
	public static void main(String[] args) {
		
		System.out.println("Say hi!!");
		
		FrogJmp test = new FrogJmp();
		
		test.solution(1, 4, 5);
		
		
	}

}
