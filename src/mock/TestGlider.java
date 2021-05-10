package mock;

import java.io.*;
import java.util.*;


import java.math.*;

public class TestGlider {
	
	int sum(int a, int b) {
		return a + b;
	}
	
	public static void main(String args[]) throws IOException{
		
		TestGlider test = new TestGlider();
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new FileWriter(System.getProperty("OUTPUT_FILE_PATH")));
		
		// read single number
		int singleNum = Integer.parseInt(reader.readLine().trim());
		
		// read list number
		String[] listStr = reader.readLine().replaceAll("\\s+$", "").split(" ");
		
		// write result
		for(String item : listStr) {
			writer.write(item + " ");
		}
		writer.newLine();
		writer.close();
		reader.close();
	}

}
