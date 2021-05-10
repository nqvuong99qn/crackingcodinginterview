package leetcode;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import leetcode.ValidateBST.TreeNode;


public class mock {

	public class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int x) {
			this.val = x;
		}

		ListNode(int x, ListNode next) {
			this.val = x;
			this.next = next;
		}

	}

	int reverse(int x) {
		if (x == 0)
			return 0;
		int result = 0;
		while (x > 0) {
			result = result * 10 + x % 10;
			if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
				return 0;
			}
			x /= 10;
		}
		return result;
	}

	ListNode mergeTwoList(ListNode l1, ListNode l2) {

		ListNode result = new ListNode(0);

		ListNode temp = result;
		while (l1 != null && l2 != null) {
			// compare
			if (l1.val >= l2.val) {
				temp.next = new ListNode(l2.val);
				l2 = l2.next;
			} else {
				temp.next = new ListNode(l1.val);
				l1 = l1.next;
			}
			temp = temp.next;
		}
		while (l1 != null) {
			temp.next = new ListNode(l1.val);
			l1 = l1.next;
		}
		while (l2 != null) {
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
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (mid <= x / mid && (mid + 1) > x / (mid + 1)) {
				return mid;
			} else if (mid > x / mid) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		return left;
	}

	boolean isAnagram(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		int[] map = new int[256];
		for (int i = 0; i < s.length(); i++) {
			map[s.charAt(i)]++;
			map[t.charAt(i)]--;
		}
		for (int c : map) {
			if (c != 0)
				return false;
		}
		return true;
	}

	int missingNumber(int[] nums) {
		int sum = 0;
		int len = nums.length;
		for (int c : nums)
			sum += c;
		return (len + 1) * len / 2 - sum;
	}

	int majorEle(int[] nums) {
		int len = nums.length;
		if (len == 1) {
			return nums[0];
		}

		Map<Integer, Integer> map = new HashMap<>();

		for (int c : nums) {
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			}
			if (map.containsKey(c) && map.get(c) > len / 2) {
				return c;
			} else
				map.put(c, 1);
		}
		return -1;

	}

	ListNode interSector(ListNode headA, ListNode headB) {

		Set<ListNode> set = new HashSet<>();
		while (headA != null) {
			set.add(headA);
			headA = headA.next;
		}
		while (headB != null) {
			if (set.contains(headB))
				return headB;
			headB = headB.next;
		}
		return null;
	}

	int[] runningSum(int[] nums) {

		int[] result = new int[nums.length];
		result[0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			result[i] = result[i] + result[i - 1];
		}
		return result;

	}

	int[] minOperations(String boxes) {
		int len = boxes.length();
		int[] left = new int[len];
		int[] right = new int[len];
		int[] result = new int[len];

		int count = boxes.charAt(0) - '0';
		for (int i = 1; i < len; i++) {
			left[i] = left[i - 1] + count;
			count += boxes.charAt(i) - '0';
		}
		count = boxes.charAt(len - 1) - '0';
		for (int i = len - 2; i >= 0; i--) {
			right[i] = left[i + 1] + count;
			count += boxes.charAt(i) - '0';
		}
		for (int i = 0; i < len; i++) {
			result[i] = left[i] + right[i];
		}
		return result;
	}

	Comparator<String> comp=new Comparator<String>(){@Override public int compare(String str1,String str2){String s1=str1+str2;String s2=str2+str1;return s2.compareTo(s1); // reverse
																																											// order
																																											// here,
																																											// so
																																											// we
																																											// can
																																											// do
																																											// append()
																																											// later
	}};

	String largestNumber(int[] nums) {

		String[] strs = new String[nums.length];
		int i = 0;
		for (int c : nums) {
			strs[i++] = String.valueOf(c);
		}
		Arrays.sort(strs, comp);
		String result = new String();
		for (String c : strs) {
			result += c;
		}
		return result;

	}

	int solution(int[] A) {

		Set<Integer> set = new HashSet<>();
		for (int i : A) {
			if (!set.contains(Math.abs(i)))
				set.add(Math.abs(i));
		}
		return set.size();

	}

	int solution1(int[] A) {
		Arrays.sort(A);
		int left = 0;
		int right = A.length - 1;
		if (A[left] >= 0) {
			return 2 * A[left];
		}
		if (A[right] <= 0) {
			return -2 * A[right];
		}

		int min = Integer.MAX_VALUE;
		while (left <= right) {
			int check = A[left] + A[right];
			if (min < Math.abs(check)) {
				min = Math.abs(check);
			}
			if (min == 0) {
				return 0;
			}
			if (check < 0) {
				left++;
			} else
				right--;
		}
		return min;

	}

// naive solution
	int[] solution3(int[] A) {

		int len = A.length;
		if (len == 1) {
			return new int[] { 1 };
		}
		int[] result = new int[len];
		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j < len; j++) {
				if (A[i] % A[j] != 0) {
					result[i]++;
				}
				if (A[j] % A[i] != 0) {
					result[j]++;
				}
			}
		}
		return result;
	}

	ListNode removeNthFromEnd(ListNode head, int n) {

		// check input
		if (head == null || head.next == null) {
			return null;
		}
		ListNode result = new ListNode(0);
		result.next = head;
		ListNode temp = head;
		int len = 0;
		while (temp != null) {
			len++;
			temp = temp.next;
		}
		int check = len - n;
		ListNode temp2 = result;
		while (check > 1) {
			temp2 = temp2.next;
		}
		temp2.next = temp2.next.next;
		return result.next;

	}

	List<List<Integer>> fourSum(int[] nums, int target) {

		if (nums.length < 4) {
			return null;
		}
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums);
		Map<Integer, List<Integer>> map = new HashMap<>();
		List<Integer> item = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				int temp = nums[i] + nums[j];
				item.add(nums[i]);
				item.add(nums[j]);
				if (!map.containsKey(target - temp)) {

				}
			}
		}

		return null;
	}

	int addDigits(int nums) {

		int temp = 0;
		while (nums >= 10) {
			while (nums > 0) {
				temp += nums % 10;
				nums /= 10;
			}
			nums = temp;
			temp = 0;
		}
		return nums;
	}

	// majority element
	int majorElement(int[] nums) {
		int len = nums.length;

		if (len == 1) {
			return nums[0];
		}
		Map<Integer, Integer> map = new HashMap<>();
		for (int item : nums) {
			if (map.containsKey(item)) {
				if (map.get(item) + 1 > len / 2) {
					return item;
				} else
					map.put(item, map.get(item) + 1);
			} else
				map.put(item, 1);
		}
		return -1;
	}

	ListNode addTwoNumber(ListNode l1, ListNode l2) {

		if (l1 == null)
			return l2;
		if (l2 == null) {
			return l1;
		}

		ListNode result = new ListNode(0);
		ListNode temp = result;

		ListNode curr1 = l1;
		ListNode curr2 = l2;

		int carry = 0;
		while (curr1 != null || curr2 != null) {
			int x = curr1 != null ? curr1.val : 0;
			int y = curr2 != null ? curr2.val : 0;
			int digit = x + y + carry;
			temp.next = new ListNode(digit % 10);
			temp = temp.next;
			carry = digit / 10;
			if (curr1 != null)
				curr1 = curr1.next;
			if (curr2 != null)
				curr2 = curr2.next;
		}
		if (carry != 0) {
			temp.next = new ListNode(carry);
		}
		return result.next;

	}

	boolean ContainDuplicate(int[] nums) {

		if (nums == null | nums.length == 0) {
			return false;
		}
		Set<Integer> set = new HashSet<>();
		for (int item : nums) {
			if (set.contains(item))
				return true;
			set.add(item);
		}
		return false;
	}

	List<List<String>> groupAna(String[] strs) {

		Map<String, List<String>> map = new HashMap<>();
		for (String str : strs) {
			char[] c = str.toCharArray();
			Arrays.sort(c);
			String key = String.valueOf(c);
			if (!map.containsKey(key)) {
				map.put(key, new ArrayList<String>());
			}
			map.get(key).add(str);
		}
		return new ArrayList<>(map.values());

	}

	// naive solution
	int findKthLargest(int[] nums, int k) {
		Arrays.sort(nums);
		return nums[nums.length - k];
	}

	// using head
	int findKthLargest1(int[] nums, int k) {

		PriorityQueue<Integer> q = new PriorityQueue<>();
		for (int i = 0; i < nums.length; i++) {
			if (i >= k) {
				if (nums[i] > q.peek()) {
					q.poll();
					q.add(nums[i]);
				}
			} else
				q.add(nums[i]);
		}
		return q.peek();
	}

	// using partition of quickSort

	int findKthLargest2(int[] nums, int k) {
		int left = 0;
		int right = nums.length - 1;
		int index = nums.length - k;

		while (left < right) {
			int pivot = partition(nums, left, right);
			if (pivot > index) {
				right = pivot - 1;
			} else if (pivot < index) {
				left = pivot + 1;
			} else
				return nums[pivot];
		}
		return nums[left];
	}

	int partition(int[] nums, int left, int right) {
		int pivot = left;
		while (left <= right) {
			while (left <= right && nums[left] <= nums[pivot])
				left++;
			while (left <= right && nums[right] > nums[pivot])
				right--;
			if (left > right)
				break;
			swap(nums, left, right);
		}
		swap(nums, right, pivot);
		return right;
	}

	void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	// longest palindrome substring
	int count = 0;

	String longestPalindromeSubString(String s) {

		int len = s.length();
		if (len == 1) {
			return s;
		}
		String result = "";
		for (int i = 0; i < len; i++) {
			String result1 = extend(s, i, i);
			String result2 = extend(s, i, i + 1);
			result = result1.length() < result2.length() ? result1 : result2;
		}
		return result;
	}

	String extend(String s, int left, int right) {
		for (; left >= 0 && right < s.length(); left--, right++) {
			if (s.charAt(left) != s.charAt(right))
				break;
			if (left != right)
				count++;
		}
		return s.substring(left + 1, right);
	}

	public class minStack {
		public class Node {
			int val;
			int min;
			Node next;

			public Node(int x) {
				this.val = x;
				this.min = x;
			}

		}

		Node head;

		public minStack() {

		}

		void push(int x) {
			if (head == null) {
				head = new Node(x);
			} else {
				Node newNode = new Node(x);
				newNode.min = Math.min(x, head.min);
				newNode.next = head;
				head = newNode;
			}
		}

		void pop() {
			head = head.next;
		}

		int top() {
			return head.val;
		}

		int getMin() {
			return head.min;
		}
	}

	int maxProduct(int[] nums) {
		int max = Integer.MIN_VALUE;
		int len = nums.length;
		for (int i = 1; i < len; i++) {
			max = Math.max(max, nums[i] * nums[i - 1]);
		}
		return max;

	}

	ListNode reverseLL(ListNode head) {

		ListNode pre = null;
		ListNode curr = head;
		ListNode next = null;

		while (curr != null) {
			next = curr.next;
			curr.next = pre;
			pre = curr;
			curr = next;
		}
		return pre;
	}

	void rotate(int[][] matrix) {

	}

	boolean isValidBST(TreeNode root) {
		if (root == null) {
			return true;
		}
		return validBSTRecursion(root, Integer.MIN_VALUE, Integer.MAX_VALUE);

	}

	boolean validBSTRecursion(TreeNode root, int min, int max) {
		if (root == null) {
			return true;
		} else if (root.data >= max || root.data <= min) {
			return false;
		}
		return validBSTRecursion(root.left, min, root.data) && validBSTRecursion(root.right, root.data, max);

	}

	int countVowelMix(String str) {
		char[] c = str.toCharArray();
		int[] vowel = new int[128];
		int[] consonant = new int[128];
		int numVowel = 0;
		int numConsonant = 0;
		for (int i = 0; i < str.length(); i++) {
			if (isVowel(str.charAt(i))) {
				numVowel++;
				vowel[str.charAt(i) - '0']++;
			} else {
				numConsonant++;
				consonant[str.charAt(i) - '0']++;
			}
		}
		int check = numConsonant - numVowel;
		if (check != 0 && check != 1) {
			return 0;
		}
		int temp = 1;
		for (int i = 0; i < vowel.length; i++) {
			if (vowel[i] > 1) {
				temp = temp * factorial(vowel[i]);
			}
			if (consonant[i] > 1) {
				temp = temp * factorial(consonant[i]);
			}
		}
		return factorial(numConsonant) * factorial(numVowel) / temp;
	}

	boolean isVowel(char c) {
		if (c == 'u' || c == 'e' || c == 'o' || c == 'a' || c == 'i') {
			return true;
		}
		return false;
	}

	int factorial(int n) {
		int result = 1;
		while (n != 1) {
			result *= n;
			n--;
		}
		return result;
	}

	int solution111(int[] A) {
		int result = 0;
		int[] temp = new int[A.length - 1];
		temp[0] = A[0] + A[1];
		for (int i = 1; i < A.length - 1; i++) {
			temp[i] = A[i] + A[i + 1];
			if (temp[i] == temp[i - 1]) {
				temp[i] = -1;
			}
		}
		Map<Integer, Integer> map = new HashMap<>();
		for (int item : temp) {
			if (map.containsKey(item)) {
				map.put(item, map.get(item) + 1);
			} else {
				map.put(item, 1);
			}
		}
		map.put(-1, 0);

		for (int i : map.values()) {

			result = Math.max(result, i);
		}
		return result;

	}

	int binaryGap(int N) {

		char[] c = Integer.toBinaryString(N).toCharArray();
		int len = c.length;
		int current = -1;
		int longest = 0;

		for (int i = 0; i < len; i++) {
			if (c[i] == '1') {
				if (current > longest) {
					longest = current;
					if (longest > len - i)
						break;
				}
				current = 0;
			} else {
				current++;
			}
		}
		return longest;
	}

	int solution12(int[] A) {

		Set<Integer> set = new HashSet<>();
		for (int item : A) {
			if (set.contains(item)) {
				set.remove(item);
			} else
				set.add(item);
		}
		int result = 0;
		for (int item : set) {
			result = item;
		}
		return result;
	}

	public class BST {
		Node head;

		public class Node {
			long data;
			Node left;
			Node right;

			Node(long arr) {
				this.data = arr;
				this.left = null;
				this.right = null;
			}
		}

		Node insert(long[] arr, Node root, int i) {
			if (i < arr.length) {
				Node temp = new Node(arr[i]);
				root = temp;
				root.left = insert(arr, root.left, 2 * i + 1);

				// insert right child
				root.right = insert(arr, root.right, 2 * i + 2);
			}
			return root;
		}

		long sum(Node head) {
			if (head == null) {
				return 0;
			}
			return head.data + sum(head.left) + sum(head.right);
		}

		String solution(long[] arr) {
			// Type your solution here
			head = insert(arr, head, 0);

			long left = sum(head.left);
			long right = sum(head.right);

			return left < right ? "Right" : "Left";
		}

	}

	public String solution(long[] arr) {
		// Type your solution here
		BST bst = null;
		bst.head = bst.insert(arr, bst.head, 0);

		long left = bst.sum(bst.head.left);
		long right = bst.sum(bst.head.right);

		return left < right ? "Right" : "Left";
	}

	int countSubStringpalindrome(String s) {
		if (s.length() == 1) {
			return 1;
		}
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			int v1 = extend(s, i, i, 0);
			int v2 = extend(s, i, i + 1, 0);

			count += v1 + v2;
		}
		return count;
	}

	int extend(String s, int left, int right, int count) {
		int i = left;
		int j = right;
		for (; i >= 0 && j < s.length(); i--, j++) {
			if (s.charAt(i) != s.charAt(j)) {
				break;
			}
			count++;
		}
		return count;
	}

	String brackket(String angles) {

		Queue<Character> q = new LinkedList<>();
		for (int i = 0; i < angles.length(); i++) {
			q.add(angles.charAt(i));
		}
		String result = "";
		int temp = 0;
		char pre = '0';
		while (!q.isEmpty()) {
			char curr = q.poll();
			if (curr == '>') {
				if (pre == '0') {
					result += "<>";
				} else {
					result += '>';

					temp--;
				}

			} else if (curr == '<') {
				result += '<';
				pre = '<';
				temp++;
			}

		}
		while (temp > 0) {
			result += '>';
			temp--;
		}
		return result;
	}

	long[] s(double[] prices) {

		long[] result = new long[prices.length];
		double[] temp = new double[prices.length];
		for (int i = 0; i < prices.length; i++) {
			temp[i] = prices[i] - (int) prices[i];
		}
		double s = 0;
		for (int i = 0; i < prices.length; i++) {
			if (Math.abs(s - temp[i]) <= 0.5) {
				s = s - temp[i];
				result[i] = (long) Math.ceil(prices[i]);
			} else {
				s = s + 1 - temp[i];
				result[i] = (long) Math.floor(prices[i]);
			}
		}
		return result;

	}

	boolean validateStackSequence(int[] pushed, int[] popped) {

		if (pushed.length != popped.length) {
			return false;
		}
		Stack<Integer> s = new Stack<>();

		int i = 0;
		int j = 0;
		int len = pushed.length;
		while (i < len && j < len) {

			if (pushed[i] != popped[j]) {
				s.add(pushed[i++]);
			} else {
				i++;
				j++;
			}
			if (s.peek() == popped[j]) {
				s.pop();
				j++;
			}

		}
		while (j < len) {
			if (s.pop() != popped[j++]) {
				return false;
			}
		}
		return true;
	}

	public int validateStackSequences(ArrayList<Integer> pushed, ArrayList<Integer> popped) {
		// write your awesome code here

		if (pushed.size() != popped.size()) {
			return 0;
		}
		Stack<Integer> s = new Stack<>();
		int i = 0;
		int j = 0;
		int len = pushed.size();
		while (i < len && j < len) {
			if (pushed.get(i) != popped.get(j)) {
				s.add(pushed.get(i));
				i++;
			} else {
				i++;
				j++;
			}
			if (s.peek() == popped.get(j)) {
				s.pop();
				j++;
			}
		}
		while (j < len) {
			if (s.pop() != popped.get(j)) {
				return 0;
			}
			j++;
		}

		return 1;

	}

	int largestElementUsingtwoPointer(ArrayList<Integer> arr) {
		int left = 1;
		int right = arr.size() - 1;
		int result = arr.get(0);
		while (left <= right) {
			result = Math.max(result, Math.max(arr.get(left++), arr.get(right--)));
		}
		return result;
	}

	public ArrayList<Integer> findingMinMax(ArrayList<Integer> arr) {
		// write your awesome code here
		int max = arr.get(0) < arr.get(1) ? arr.get(1) : arr.get(0);
		int min = arr.get(0) > arr.get(1) ? arr.get(1) : arr.get(0);

		for (int i = 2; i < arr.size(); i++) {
			max = Math.max(max, arr.get(i));
			min = Math.min(min, arr.get(i));
		}
		ArrayList<Integer> result = new ArrayList<>();
		result.add(max);
		result.add(min);
		return result;
	}

	public ArrayList<ArrayList<Integer>> minimumAbsDifference(ArrayList<Integer> arr) {
		// write your awesome code here
		arr.sort(null);
		int[] sum = new int[arr.size() - 1];
		for (int i = 1; i < arr.size(); i++) {
			sum[i] = arr.get(i) - arr.get(i - 1);
		}
		int minSum = Integer.MAX_VALUE;
		for (int item : sum) {
			minSum = Math.min(minSum, item);
		}
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		for (int i = 0; i < sum.length; i++) {
			if (sum[i] == minSum) {
				ArrayList<Integer> temp = new ArrayList<>();
				temp.add(arr.get(i));
				temp.add(arr.get(i + 1));
				result.add(temp);
			}
		}
		return result;
	}

	int romanToInt(String s) {
		Map<Character, Integer> map = new HashMap<>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		int result = 0;
		for (int i = 0; i < s.length() - 1; i++) {
			if (map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
				result -= map.get(s.charAt(i));
			} else {
				result += map.get(s.charAt(i));
			}
		}
		return result + map.get(s.charAt(s.length() - 1));
	}

	boolean isValid(String s) {

		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < s.length(); i++) {

			if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
				stack.push(s.charAt(i));
			} else if (s.charAt(i) == ')' && !stack.isEmpty() && stack.peek() == '(') {
				stack.pop();
			} else if (s.charAt(i) == '}' && !stack.isEmpty() && stack.peek() == '{') {
				stack.pop();
			} else if (s.charAt(i) == ']' && !stack.isEmpty() && stack.peek() == '[') {
				stack.pop();
			} else {
				return false;
			}

		}
		return stack.isEmpty();

	}

	int removeElement(int[] nums, int val) {
		int len = nums.length;
		int j = 0;
		for (int i = 0; i < len; i++) {
			if (nums[i] != val) {
				nums[j] = nums[i];
				j++;
			}
		}
		return 1;
	}

	public ListNode deleteDuplicates(ListNode head) {

		ListNode curr = head;
		ListNode pre = curr;
		while (curr != null) {

			while (curr.val == curr.next.val && curr.next != null) {
				curr = curr.next;
			}
			pre.next = curr.next;
			pre = pre.next;
			curr = curr.next;
		}
		return head;
	}

	public void merge(int[] nums1, int m, int[] nums2, int n) {

		int i = m - 1;
		int j = n - 1;
		int k = m + n - 1;
		while (i >= 0 && j >= 0) {
			nums1[k--] = nums2[j] > nums1[i] ? nums2[j--] : nums1[i--];
		}
		while (j >= 0) {
			nums1[k--] = nums2[j--];
		}
	}

	int searchInsert(int[] nums, int target) {

		for (int i = 0; i < nums.length; i++) {
			if (target <= nums[i]) {
				return i;
			} else if (target > nums[i]) {
				i++;
			}
		}
		return nums.length;

	}

	int lengthofLasword(String s) {

		int len = s.length();

		if (len == 0) {
			return 0;
		}
		int count = 0;

		// delele all space of right string
		int temp = len;
		while (temp > 0) {
			if (s.charAt(temp - 1) == ' ') {
				temp--;
			} else
				break;
		}
		while (temp >= 0) {
			if (s.charAt(temp - 1) != ' ') {
				temp--;
				count++;
			}
		}
		return count;

	}

	boolean isHappy(int n) {

		while (n >= 7) {
			int temp = 0;
			while (n > 0) {
				temp += Math.pow(n % 10, 2);
				n /= 10;
			}
			n = temp;
		}
		return n == 1;
	}

	public ListNode removeElements(ListNode head, int val) {

		if (head == null) {
			return null;
		}
		if (head.next == null) {
			if (head.val == val) {
				return null;
			} else
				return head;
		}

		ListNode curr = head;
		ListNode pre = head;

		while (curr != null) {
			if (curr.val == val) {
				pre.next = curr.next;
			} else {
				pre = curr;
			}
			curr = curr.next;
		}
		if (pre.val == val) {
			pre = null;
		}
		return head;

	}

	public int addDigitsa(int num) {
		while (num >= 10) {
			int temp = 0;
			while (num > 0) {
				temp += num % 10;
				num /= 10;
			}
			num = temp;
		}
		return num;

	}

	public String addStrings(String num1, String num2) {
		StringBuilder sb = new StringBuilder();
		int i = num1.length() - 1;
		int j = num2.length() - 1;
		int carry = 0;
		while (i >= 0 || j >= 0) {
			int x = i < 0 ? 0 : num1.charAt(i) - '0';
			int y = j < 0 ? 0 : num2.charAt(j) - '0';
			int digit = carry + x + y;
			sb.append(digit % 10);
			if (i >= 0)
				i--;
			if (j >= 0)
				j--;
			carry = digit / 10;
		}
		if (carry > 0) {
			sb.append(carry);
		}
		return sb.reverse().toString();

	}

	Map<Integer, Integer> map = new HashMap<>();

	// no dp
	int fib(int n) {
		if (n < 2) {
			return n;
		}
		return fib(n - 1) + fib(n - 2);
	}

	// using dp for fibo
	int fibDP(int n) {
		if (map.containsKey(n)) {
			return map.get(n);
		} else {
			if (n < 2) {
				return n;
			} else {
				map.put(n, fib(n - 1) + fib(n - 2));
				return map.get(n);
			}
		}

	}

	// problem
	/*
	 * find max number of distinct values in array <= length /2
	 */
	int distributeCandy(int[] candyType) {

		Set<Integer> set = new HashSet<>();
		for (int i : candyType) {
			set.add(i);
		}
		if (set.size() > candyType.length / 2) {
			return candyType.length / 2;
		}
		return set.size();
	}

	public int[] relativeSortArray(int[] arr1, int[] arr2) {
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < arr1.length; i++) {
			if (map.containsKey(arr1[i])) {
				map.put(arr1[i], map.get(arr1[i]) + 1);
			} else
				map.put(arr1[i], 1);
		}
		int[] result = new int[arr1.length];
		int id = 0;
		for (int i = 0; i < arr2.length; i++) {
			int temp = map.get(arr2[i]);
			while (temp > 0) {
				result[id++] = arr2[i];
				temp--;
			}
			map.remove(arr2[i]);
		}
		int[] temp = new int[result.length - id];
		int index = 0;
		for (int item : map.keySet()) {
			int check = map.get(item);
			while (check > 0) {
				temp[index++] = item;
				check--;
			}

		}
		index = 0;
		Arrays.sort(temp);
		while (id < result.length) {
			result[id++] = temp[index++];
		}
		return result;

	}

	public boolean rotateString(String A, String B) {

		// check input
		if (A.length() != B.length()) {
			return false;
		}
		if (A.length() == 0 && B.length() == 0) {
			return true;
		}

		// find a character of A in B
		// character only appear once
		char check = A.charAt(A.length() - 1);
		int temp = 0;
		for (int i = B.length() - 1; i >= 0; i--) {
			if (B.charAt(i) == check) {
				temp = i;
				break;
			}
		}
		temp = A.length() - 1 - temp;
		// check
		for (int i = A.length() - 1; i >= 0; i--) {
			if (i - temp >= 0) {
				if (A.charAt(i) != B.charAt(i - temp)) {
					return false;
				}
			} else if (A.charAt(i) != B.charAt(i - 1 + B.length() - 1)) {
				return false;
			}
		}
		return true;
	}

	public List<Integer> majorityElement(int[] nums) {
		int check = nums.length / 3;
		// using map
		Map<Integer, Integer> map = new HashMap<>();
		for (int item : nums) {
			if (map.containsKey(item)) {
				map.put(item, map.get(item) + 1);
			} else
				map.put(item, 1);
		}
		List<Integer> result = new ArrayList<>();
		for (int item : map.keySet()) {
			if (map.get(item) > check) {
				result.add(item);
			}
		}
		return result;
	}

	int maxMinDivision(int K, int M, int[] A) {

		int max = 0;
		for (int i : A) {
			max += i;
		}
		int min = 0;
		int result = 0;
		while (min <= max) {
			int mid = (min + max) / 2;
			if (checkDivisable(mid, K, A)) {
				result = mid;
				max = mid - 1;
			} else {
				min = mid + 1;
			}
		}
		return result;
	}

	boolean checkDivisable(int mid, int numBlocks, int[] A) {
		int k = numBlocks;
		int tempSum = 0;
		for (int i = 0; i < A.length; i++) {
			tempSum += A[i];
			if (tempSum > mid) {
				k--;
				tempSum = A[i];
			}
			if (k == 0) {
				return false;
			}
		}
		return true;
	}

	int countSubString(String s) {
		int count = 0;
		// check input
		for (int i = 0; i < s.length(); i++) {
			int n1 = extendd(s, i, i, 0);
			int n2 = extendd(s, i, i + 1, 0);
			count += n1 + n2;
		}
		return count;
	}

	int extendd(String s, int left, int right, int count) {
		for (; left >= 0 && right < s.length(); left--, right++) {
			if (s.charAt(left) != s.charAt(right))
				break;
			count++;
		}
		return count;
	}

	int partitionN(int[] arr, int left, int right) {
		int pivot = left;
		int i = left + 1;
		int j = right;
		while (true) {
			while (i <= right && arr[i] < arr[pivot]) i++;
			while (j >= left && arr[j] > arr[pivot]) j--;
			if (i >= j) break;
			
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
		}
		
		int temp = arr[pivot];
		arr[pivot]=arr[j];
		arr[j] = temp;
		return j;	
	}

	void quickSort(int[] arr, int left, int right) {
		
		
		
		if (left < right) {
			int partition = partitionN(arr, left, right);
			quickSort(arr, left, partition - 1);
			quickSort(arr, partition+1, right);
		}
	}
	
	// implement queue
	
	public class Node{
		Node next;
		int data;
		public Node(int val) {
			this.data = val;
			this.next = null;			
		}
	}
	public class Q{
		Node head;
		int size;
		public Q() {
			
		}
		void enQ(int data) {
			Node newNode = new Node(data);
			if(head == null) {
				head = newNode;
				size++;
			}
			else {
				Node curr = head;
				while(curr.next != null) {
					curr = curr.next;
				}
				curr.next = newNode;
				size++;
			}
		}
		int deQ() throws Exception {
			if(head == null) {
				throw new Exception("Q is Empty");
			}
			int val = head.data;
			head = head.next;
			return val;
		}
		int getSize() {
			return this.size;
		}
		
		void printQ() {
			Node curr = head;
			while(curr != null) {
				System.out.print(curr.data + "-->");
				curr = curr.next;
			}
		}
	}

	public static void main(String[] args) throws Exception {

		System.out.println("Say hi!!" + Math.ceil(1.0));
		mock test = new mock();
		
		
		
		

	}

}