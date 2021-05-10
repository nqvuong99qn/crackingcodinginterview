package javaPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import mastercodinginterview.ArraysSection;

public class test {

	int solution4(int[] A) {

		int len = A.length;

		Set<Integer> set = new HashSet<>();

		Arrays.sort(A);

		set.add(A[0]);
		for (int i = 1; i < len; i++) {
			if (set.contains(A[i]))
				set.remove(A[i]);
			else if (set.isEmpty()) {
				set.add(A[i]);
			} else
				return set.stream().findFirst().get();
		}
		return set.stream().findFirst().get();

	}

	int solution2(int[] A) {

		int len = A.length;
		Arrays.sort(A);
		for (int i = 1; i < len; i++) {
			if (A[i] - A[i - 1] != 1) {
				return A[i - 1] + 1;
			}
		}
		return 1;

	}

	int solution3(int[] A) {

		int len = A.length;

		Set set = new HashSet<>();
		for (int a : A) {
			if (a > 0)
				set.add(a);
		}
		for (int i = 1; i <= len + 1; i++) {
			if (!set.contains(i)) {
				return i;
			}
		}
		return 1;

	}

	int findMissingInteger(int[] A) {

		// using set
		Set set = new HashSet<>();
		for (int a : A) {
			set.add(a);
		}
		for (int i = 1; i <= A.length + 1; i++) {
			if (!set.contains(i))
				return i;
		}
		return 0;
	}

	int DistinctInArray(int[] A) {

		Map<Integer, Integer> map = new HashMap<>();

		Set set = new HashSet<>();

		for (int c : A) {
			set.add(c);
		}

		return (int) set.stream().count();

	}

	int maxProductOfThree(int[] A) {

		Arrays.sort(A);
		int len = A.length;
		int maxPos = A[len - 1];
		int secondMaxPos = A[len - 2];
		int thirdMaxPos = A[len - 3];

		int maxNeg = A[0];
		int secondMaxNeg = A[1];

		return maxPos * secondMaxPos * thirdMaxPos > maxPos * maxNeg * secondMaxNeg
				? maxPos * secondMaxPos * thirdMaxPos
				: maxPos * maxNeg * secondMaxNeg;

	}

	int triangle(int[] A) {

		int len = A.length;
		Arrays.sort(A);

		for (int i = 2; i < len; i++) {
			int p = A[i - 2];
			int q = A[i - 1];
			int r = A[i];

			if (p + q <= r) {
				continue;
			}
			if (r + p <= q) {
				continue;
			}
			if (q + r <= p) {
				continue;
			}
			return 1;
		}
		return 0;
	}

	List<List<String>> groupAnagrams(String[] strs) {

		if (strs.length == 0)
			return null;

		Arrays.sort(strs);
		int len = strs.length;
		Map<String, List<String>> map = new HashMap<>();

		for (int i = 0; i < len; i++) {
			char[] temp = strs[i].toCharArray();
			Arrays.sort(temp);
			String key = String.valueOf(temp);
			if (!map.containsKey(key)) {
				map.put(key, new ArrayList<>());
			}
			map.get(key).add(strs[i]);
		}

		return new ArrayList<>(map.values());

	}

	List<List<Integer>> threeSum(int[] nums) {

		if (nums == null || nums.length == 0) {
			return new ArrayList<>();
		}
		List<List<Integer>> result = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			int left = i + 1;
			int right = nums.length - 1;
			while (left < right) {
				int check = nums[i] - nums[left] - nums[right];
				if (check == 0) {
					List<Integer> temp = new ArrayList<>();
					temp.add(nums[i]);
					temp.add(nums[left]);
					temp.add(nums[right]);
					result.add(new ArrayList<>(temp));
					right--;
					left++;

				} else if (check > 0) {
					right--;
				} else
					left++;
			}

		}
		return result;
	}

	int bestTimeToBuyStock(int[] prices) {

		// check input
		if (prices == null || prices.length < 2)
			return 0;

		int max = 0;
		int minP = prices[0];
		int len = prices.length;
		for (int i = 1; i < len; i++) {
			if (prices[i] > minP)
				max = Math.max(max, prices[i] - minP);
			else {
				minP = prices[i];
			}
		}
		return max != 0 ? max : 0;
	}

	String reverseStr(String s, int k) {

		// check input
		if (k == 1 || k == 0)
			return s;

		char[] chars = s.toCharArray();
		if (s.length() < k) {
			int left = 0;
			int right = s.length() - 1;
			while (left < right) {
				char temp = chars[left];
				chars[left++] = chars[right];
				chars[right--] = temp;
			}
			return new String(chars);

		}

		for (int i = 0; i < s.length(); i += 2 * k) {
			int left = i;
			int right = left + k - 1;
			while (left < right) {
				char temp = chars[left];
				chars[left++] = chars[right];
				chars[right--] = temp;
			}
		}
		return new String(chars);
	}

	int lengthOfLongestSubstring(String s) {

		int len = s.length();
		// map
		int[] map = new int[256];
		Arrays.fill(map, -1);
		int id = 0;
		int max = 0;
		for (int i = 0; i < len; i++) {
			if (map[s.charAt(i)] >= id) {
				i = s.charAt(i) + 1;
			}
			map[s.charAt(i)] = i;
			max = Math.max(max, i - id + 1);
		}
		// return max;

		int[] charMap = new int[256];
		Arrays.fill(charMap, -1);
		int i = 0, maxLen = 0;
		for (int j = 0; j < s.length(); j++) {
			if (charMap[s.charAt(j)] >= i) {
				i = charMap[s.charAt(j)] + 1;
			}
			charMap[s.charAt(j)] = j;
			maxLen = Math.max(j - i + 1, maxLen);
		}
		return maxLen;

	}

	String longestPalindrome(String s) {
		String result = "";
		for (int i = 0; i < s.length(); i++) {
			for (int j = i + 1; j < s.length(); j++) {
				if (isPalindrome(s.substring(i, j)) && j - i > result.length()) {
					result = s.substring(i, j);
				}
			}
		}
		return result;
	}

	boolean isPalindrome(String s) {
		int i = 0;
		int j = s.length() - 1;
		while (i < j) {
			if (s.charAt(i) != s.charAt(j))
				return false;
		}
		return true;
	}

	String addBinary(String a, String b) {
		StringBuilder result = new StringBuilder();
		int carry = 0;
		int i = a.length() - 1;
		int j = b.length() - 1;
		while (i >= 0 || j >= 0) {
			int sum = carry;
			if (i >= 0)
				sum += a.charAt(i--) - '0';
			if (j >= 0)
				sum += b.charAt(j--) - '0';

			result.append(sum % 2);
			carry = sum / 2;
		}
		if (carry != 0) {
			result.append(carry);
		}
		return result.reverse().toString();
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			this.val = x;
		}
	}

	public List<List<Integer>> levelOrder(TreeNode root) {

		List<List<Integer>> result = new ArrayList<>();
		// check input
		if (root == null) {
			return result;
		}

		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		result.add(new ArrayList<>(root.val));

		while (!q.isEmpty()) {
			TreeNode currNode = q.remove();
			Queue<TreeNode> currQ = new LinkedList<>();
			List<Integer> level = new ArrayList<>();

			while (!q.isEmpty()) {
				if (currNode.left != null) {
					level.add(currNode.left.val);
					currQ.add(currNode.left);
				}
				if (currNode.right != null) {
					level.add(currNode.right.val);
					currQ.add(currNode.right);
				}
			}
			if (level.size() > 0) {
				result.add(level);

			}
			q = currQ;
		}
		return result;
	}

	// binarygap

	// convert N to binary
	int DecimalToBinary(int N) {

		String binary = Integer.toBinaryString(N);
		int longest = 0;
		int current = -1;
		for (int i = 0; i < binary.length(); i++) {
			if (binary.charAt(i) - '0' == 1) {
				if (current > longest) {
					longest = current;
					if (longest > binary.length() - i) {
						break;
					}
				}
				current = 0;
			} else {
				current++;
			}
		}
		return longest;

	}

	int solution(int[] A) {

		Set<Integer> set = new HashSet<>();

		for (int c : A) {
			if (c > 0) {
				set.add(c);
			}
		}
		for (int i = 0; i <= A.length + 1; i++) {
			if (!set.contains(i))
				return i;
		}
		return 1;
	}

	int solution3(int[] A, int[] B) {
		int result = 0;
		for (int i = 1; i < A.length; i++) {
			if (A[i] <= A[i - 1]) {
				if (A[i] <= B[i - 1] || A[i - 1] >= B[i])
					return -1;
				int temp = A[i];
				A[i] = B[i];
				B[i] = temp;
				result++;
			}
		}
		return result;
	}

	int solution5(int[] A) {
		Arrays.sort(A);
		int left = 0;
		int right = A.length - 1;
		if(A[0] >= 0) {
			return A[0] + A[1];
		}
		if(A[right] <=0) {
			return Math.abs(A[right] + A[right-1]);
		}
		int min = Integer.MAX_VALUE;
		int sum = 0;
		while(left < right) {
			sum = A[right] + A[left];
			if(Math.abs(sum) < min) {
				min = Math.abs(sum);
			}
			if(min == 0)
				break;
			if(sum < 0) {
				left++;
			}
			else {
				right--;
			}
		}
		return min;

	}
	
	boolean isPalindrome(int x) {
		
		// check input
		if(x < 0)
			return false;
		
		int temp = x; 
		int reverse = 0;
		while(temp > 0) {
			reverse = reverse * 10 + temp % 10;
			temp /= 10;
		}
		return x == reverse;
	}
	
	// quick sort
	
	void quickSort(int[] arr, int l, int r) {
		if(l < r) {
			int parti = partition(arr, l, r);
			quickSort(arr, l, parti - 1);
			quickSort(arr, parti + 1, r);
		}
	}
	
	void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	int partition(int arr[], int l, int r) {
		
		int pivot = arr[l];
		int left = l + 1;
		int right = r;
		while(true) {
			while(left <= r && arr[left] < pivot) left++;
			while(right >= l && arr[right] > pivot) right--;
			if(left >= right) break;
			swap(arr, left, right);
			left++;
			right--;	
		}
		swap(arr, l, right);
		return right;
	}


	public static void main(String args[]) {
		System.out.println("Say hi!!");

		test a = new test();

		String ahi = "abcd";
		
		a.isPalindrome(121);

		a.addBinary("11", "1");

		a.DecimalToBinary(9);

		int[] arr = {5,5,7,3,1,2,3,6,7,8,56,34};
		a.quickSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));

	}

}
