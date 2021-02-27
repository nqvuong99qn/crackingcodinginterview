package leetcode;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
	
	List<Integer> solution(int[][] matrix){
		
		List<Integer> result = new ArrayList<>();

		// check input
		if(matrix.length == 0 || matrix == null) {
			return result;
		}
		
		int colStart = 0;
		int rowStart = 0;
		int colEnd = matrix[0].length - 1;
		int rowEnd = matrix.length - 1;
		
		while(rowStart <= rowEnd && colStart <= colEnd) {
			
			for(int i = colStart; i <= colEnd; i++) {
				result.add(matrix[rowStart][i]);
			}
			rowStart++;
			for(int i = rowStart; i <= rowEnd; i++) {
				result.add(matrix[i][colEnd]);
			}
			colEnd--;
			for(int i = colEnd; i >= colStart; i--) {
				result.add(matrix[rowEnd][i]);
			}
			rowEnd--;
			for(int i = rowEnd; i >= rowStart; i--) {
				result.add(matrix[i][colStart]);
			}
			colStart++;
		}
		
		
		
		
		
		
		
		return result;
	}
	
	
	
	public static void main(String[] args) {

		System.out.println("say hi!!");

		SpiralMatrix test = new SpiralMatrix();

		int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		System.out.println("Expected result: " + test.solution(matrix));

	}


}
