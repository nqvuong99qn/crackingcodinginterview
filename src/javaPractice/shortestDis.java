package javaPractice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
		//  check existence
		if(!strings.contains(a) || !strings.contains(b)) {
			return -1;
		}

		int ida = -1;
		int idb = -1;
		int result = Integer.MAX_VALUE; 
		for (int i = 0; i < strings.size(); i++) {
			if (strings.get(i).equals(a)) {
				if(idb != -1 ) {
					result = Math.min(result, Math.abs(idb - i));
				}
				ida = i;
			}
			else if (strings.get(i).equals(b)) {
				if(ida != -1 ) {
					result = Math.min(result, Math.abs(i - ida));
				}
				idb = i;
			}
		}
		return result;
	}
	
	public class KMSDD{
		Node head;
		public class Node{
			int val;
			Node next;
			
			public Node(int data) {
				this.val = data;
			}
		}
		void addFirst(int val) {
			Node newNode = new Node(val);
			if(head == null) {
				head = newNode;
			}
			else {
				newNode.next = head;
				head = newNode;
			}
		}
		
		List<List<Integer>> findPairSumEqualK(int k){	
			List<List<Integer>> result = new ArrayList<>();
			Set<Integer> set = new HashSet<>();
			Node curr = head;
			while(curr != null) {
				set.add(curr.val);
				curr = curr.next;
			}
			if( k % 2 == 0 && set.contains(k / 2)) {
				set.remove(k/2);
			}
			curr = head;
			while(curr != null) {
				if(set.contains(k - curr.val)){
					List<Integer> temp = new ArrayList<>();
					temp.add(curr.val);
					temp.add(k - curr.val);
					result.add(temp);
					set.remove(k-curr.val);
					set.remove(curr.val);
				}
				curr = curr.next;
			}
			return result;
		}
	}

	public static void main(String args[]) {

		// test
		// init data
		List<String> strings = new ArrayList<>();
		strings.add("a");
		strings.add("b");
		strings.add("c");
		strings.add("d");
		strings.add("a");
		shortestDis test = new shortestDis(strings);
		
		KMSDD ll = test.new KMSDD();
		ll.addFirst(1);
		ll.addFirst(2);
		ll.addFirst(3);
		ll.addFirst(4);
		ll.addFirst(5);
		
		ll.findPairSumEqualK(5);

		System.out.println("Say hi!!!");
		System.out.println("Expected: " + test.shorestDistance("a", "d"));
		
	}

}
