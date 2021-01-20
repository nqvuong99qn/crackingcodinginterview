package javaPractice;

import java.util.ArrayList;
import java.util.List;

public class shortestDis {

	List<String> strings;

	public shortestDis(List<String> strings) {
		this.strings = strings;
	}

	public int shorestDistance(String a, String b) {
		// a , b are the same
		if (a.equals(b)) {
			return 0;
		}

		// a, b are the same
		if(a.equals(b))
			return 0;
		//  check existence
		if(!strings.contains(a) || !strings.contains(b)) {
			return 0;
		}

		int ida = -1;
		int idb = -1;
		int result = 1000000; //  infinity
		for (int i = 0; i < strings.size(); i++) {
			if (strings.get(i).equals(a)) {
				if(idb == -1) {
					ida = i;
				}
				else if(Math.abs(i - idb) < result) {
					result = Math.abs(i - idb);
					ida = i;
				}
			}
			else if (strings.get(i).equals(b)) {
				if(ida == -1) {
					idb = i;
				}
				else if(Math.abs(i - ida) < result) {
					result = Math.abs(i - ida);
					idb = i;
				}
			}
		}
		return result;
	}

	public static void main(String args[]) {

		// test
		// init data
		List<String> strings = new ArrayList<>();
		strings.add("a");
		strings.add("b");
		strings.add("c");
		strings.add("b");
		strings.add("b");
		shortestDis test = new shortestDis(strings);

		System.out.println("Say hi!!!");
		System.out.println("Expected: " + test.shorestDistance("b", "a"));
		
	}

}
