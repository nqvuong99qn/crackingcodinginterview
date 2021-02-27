package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class mock {
	
	public class ListNode{
		int val;
		ListNode next;
		ListNode(){}
		ListNode(int x){
			this.val = x;
		}
		ListNode(int x, ListNode next){
			this.val = x;
			this.next = next;
		}
		
		
	}
	
	int reverse(int x) {
		if(x == 0) return 0;
		int result = 0;
		while( x > 0) {
			result = result * 10 + x % 10;
			if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
				return 0;
			}
			x /= 10;
		}
		return result;			
	}
	
	ListNode mergeTwoList(ListNode l1, ListNode l2) {
		
		
		ListNode result = new ListNode(0);
		
		ListNode temp = result;
		while(l1 != null && l2 != null) {
			//compare
			if(l1.val >= l2.val) {
				temp.next = new ListNode(l2.val);
				l2 = l2.next;
			}
			else {
				temp.next = new ListNode(l1.val);
				l1 = l1.next;
			}
			temp = temp.next;
		}
		while(l1 != null) {
			temp.next = new ListNode(l1.val);
			l1 = l1.next;
		}
		while(l2 != null) {
			temp.next = new ListNode(l2.val);
			l2 = l2.next;
		}
		return result.next;
	}
	
	
	// naive solution
	int mySqrt(int x) {
		if (x == 0)
			return 0;
		int left = 1;
		int right = x;
		while(left < right) {
			int mid = left + (right - left) / 2;
			if(mid <= x / mid && (mid+1) > x / (mid + 1)) {
				return mid;
			}
			else if(mid > x/mid) {
				right = mid;
			}
			else {
				left = mid + 1;
			}
		}
		return left;
	}
	boolean isAnagram(String s, String t) {
		if(s.length() != t.length()) {
			return false;
		}
		int[] map = new int[256];
		for(int i = 0; i < s.length(); i++) {
			map[s.charAt(i)]++;
			map[t.charAt(i)]--;
		}
		for(int c : map) {
			if(c != 0)
				return false;
		}
		return true;
	}
	
	int missingNumber(int[] nums) {
		int sum  = 0;
		int len = nums.length;
		for(int c : nums) sum +=c;
		return (len +1)*len / 2 - sum;
	}
	
	
	int majorEle(int[] nums) {
		int len = nums.length;
		if(len == 1) {
			return nums[0];
		}
		
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int c : nums) {
			if(map.containsKey(c)) {
				map.put(c, map.get(c)+1);
			}
			if(map.containsKey(c) && map.get(c) > len/2) {
				return c;
			}
			else map.put(c, 1);
		}
		return -1;

		
	}
	
	ListNode interSector(ListNode headA, ListNode headB) {
		
		Set<ListNode> set = new HashSet<>();
		while(headA != null) {
			set.add(headA);
			headA = headA.next;
		}
		while(headB != null) {
			if(set.contains(headB))
				return headB;
			headB = headB.next;
		}
		return null;
	}
	
	int[] runningSum(int[] nums) {
		
		int[] result = new int[nums.length];
		result[0] = nums[0];
		for(int i = 1; i < nums.length; i++) {
			result[i] = result [i] + result[i-1];
		}
		return result;
		
	}
	
	int[] minOperations(String boxes) {
		int len = boxes.length();
		int[] left = new int[len];
		int[] right = new int[len];
		int[] result = new int[len];
		
		int count = boxes.charAt(0) - '0';
		for(int i = 1; i < len; i++) {
			left[i] = left[i-1] + count;
			count += boxes.charAt(i) - '0';
		}
		count = boxes.charAt(len-1) - '0';
		for(int i = len-2; i >= 0; i--) {
			right[i] = left[i+1] + count;
			count += boxes.charAt(i) - '0';
		}
		for(int i = 0; i < len; i++) {
			result[i] = left[i] + right[i];
		}
		return result;
	}
	Comparator<String> comp = new Comparator<String>(){
	    @Override
	    public int compare(String str1, String str2){
	        String s1 = str1 + str2;
			String s2 = str2 + str1;
			return s2.compareTo(s1); // reverse order here, so we can do append() later
	    }
     };
	
	String largestNumber(int[] nums) {
		
		String[] strs = new String[nums.length];
		int i = 0;
		for(int c : nums) {
			strs[i++] = String.valueOf(c);
		}
		Arrays.sort(strs, comp);
		String result = new String();
		for(String c : strs) {
			result += c;
		}
		return result;
		
	}
	
	
	int solution(int[] A) {
		
		
		Set<Integer> set = new HashSet<>();
		for(int i : A) {
			if(!set.contains(Math.abs(i)))
				set.add(Math.abs(i));
		}
		return set.size();
		
	}
	
	int solution1(int[] A) {
		Arrays.sort(A);
		int left = 0;
		int right = A.length - 1;
		if(A[left] >= 0) {
			return 2 * A[left];
		}
		if(A[right] <=0) {
			return -2 * A[right];
		}
		
		int min = Integer.MAX_VALUE;
		while(left <= right) {
			int check = A[left] + A[right];
			if(min < Math.abs(check)) {
				min = Math.abs(check);
			}
			if(min == 0) {
				return 0;
			}
			if(check < 0) {
				left++;
			}
			else right--;
		}
		return min;
		
	}
	
// naive solution
	int[] solution3(int[] A) {
		
		int len = A.length;
		if(len == 1) {
			return new int[] {1};
		}
		int[] result = new int[len];
		for(int i = 0; i < len; i++) {
			for(int j = i + 1; j < len; j++) {
				if(A[i] % A[j] != 0) {
					result[i]++;
				}
				if(A[j] % A[i] != 0) {
					result[j]++;
				}
			}
		}
		return result;
	}
	
	ListNode removeNthFromEnd(ListNode head, int n) {
		
		// check input
		if(head == null || head.next == null) {
			return null;
		}
		ListNode result = new ListNode(0);
		result.next = head;
		ListNode temp = head;
		int len = 0;
		while(temp != null) {
			len++;
			temp = temp.next;
		}
		int check = len - n;
		ListNode temp2 = result;
		while(check > 1) {
			temp2 = temp2.next;
		}
		temp2.next = temp2.next.next;
		return result.next;
		
	}
	
	List<List<Integer>> fourSum(int[] nums, int target){
		
		if(nums.length < 4) {
			return null;
		}
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums);
		Map<Integer, List<Integer>> map = new HashMap<>();
		List<Integer> item = new ArrayList<>();
		for(int i = 0; i < nums.length; i++) {
			for(int j = i + 1; j < nums.length; j++) {
				int temp = nums[i] + nums[j];
				item.add(nums[i]);
				item.add(nums[j]);
				if(!map.containsKey(target - temp)) {
					
				}
			}
		}
		
		
		
		
		
		return null;
	}

	

	
	
		
	
	
	
	
	
	public static void main(String[] args) {
		
		System.out.println("Say hi!!");
		
		
		
		
		mock test = new mock();
		
		test.isAnagram("anagram", "nagaram");
		
		test.largestNumber(new int[] {1, 3, 30, 34, 9, 5});
		
		
		test.solution3(new int[] {3, 1, 2, 3, 6});
		
		
		
		
		
		
		
	}

}
