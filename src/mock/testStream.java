package mock;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class testStream {
	
	
	long time(List<Integer> list) {
		long start = System.currentTimeMillis();
		for(int i = 0; i < list.size(); i++) {
			list.set(i, list.get(0) + i);
		}
		long end = System.currentTimeMillis();
		return end - start;
	}
	
	
	long timeStream(List<Integer> list) {
		long start = System.currentTimeMillis();
		list.stream().map(item -> item + 1).toArray();
		long end = System.currentTimeMillis();
		return end - start;
	} 
	
	
	
	
	public static void main(String[] args) {
		
		System.out.println("say hi!!!");
		
		int[] arr = new int[20000000];
		List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList()); 

		testStream test = new testStream();
		long time = test.timeStream(list);
		System.out.println((new SimpleDateFormat("mm:ss:SSS")).format(new Date(time)));
		
		
		
		
		
	}

}
