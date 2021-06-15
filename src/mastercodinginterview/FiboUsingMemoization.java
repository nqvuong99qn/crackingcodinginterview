package mastercodinginterview;

import java.util.HashMap;
import java.util.Map;

public class FiboUsingMemoization {

	Map<Integer, Integer> map = new HashMap<>();

	int count = 0;

	int fibo(int n) {
		count++;
		if (n < 2) {
			return n;
		}
		return fibo(n - 1) + fibo(n - 2);
	}

	int fiboMaster(int n) {
		count++;
		if (map.containsKey(n))
			return map.get(n);
		else {
			if (n < 2)
				return n;
			else {
				map.put(n, fiboMaster(n - 1) + fiboMaster(n - 2));
				return map.get(n);
			}
		}
	}

	public static void main(String[] args) {
		System.out.println("Say hi!!");

		FiboUsingMemoization test = new FiboUsingMemoization();

		System.out.println("Expected result: " + test.fiboMaster(10) + " count: " + test.count);
		System.out.println("Expected result: " + test.fibo(10) + " count: " + test.count);

	}

}
