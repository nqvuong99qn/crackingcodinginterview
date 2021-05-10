package mock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class mockLeetcode {

	// naive
	int[] twoSum(int[] nums, int target) {
		int len = nums.length;
		for (int i = 0; i < len; i++) {
			for (int j = i; j < len; j++) {
				if (nums[i] + nums[j] == target) {
					return new int[] { i, j };
				}
			}
		}
		return null;
	}

	// better
	int[] twoSumBetter(int[] nums, int target) {
		int len = nums.length;

		// two pointer
		Arrays.sort(nums);
		int left = 0;
		int right = len - 1;
		while (left < right) {
			int check = nums[left] + nums[right] - target;
			if (check == 0) {
				return new int[] { left, right };
			} else if (check > 0) {
				right--;
			} else {
				left++;
			}
		}
		return null;
	}

	// best solution
	int[] twoSumBest(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(target - nums[i])) {
				return new int[] { i, map.get(target - nums[i]) };
			} else
				map.put(nums[i], i);
		}
		return null;
	}

	// add two number
	public class ListNode {
		int val;
		ListNode next;

		ListNode() {

		}

		ListNode(int data) {
			this.val = data;
		}
	}

	ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode result = new ListNode(0);
		ListNode curr = result;

		int carry = 0;
		while (l1 != null || l1 != null) {
			int x = l1 != null ? 0 : l1.val;
			int y = l2 != null ? 0 : l2.val;
			int digit = carry + x + y;
			curr.next = new ListNode(digit % 10);
			curr = curr.next;
			carry /= 10;
			if (l1 != null)
				l1 = l1.next;
			if (l2 != null)
				l2 = l2.next;
		}
		if (carry != 0) {
			curr.next = new ListNode(carry);
		}
		return result.next;
	}

	// naive sol
	boolean check(String s) {
		return true;
	}

	int longestSubStringWithoutRepeatNaive(String s) {
		int max = 0;
		for (int i = 0; i < s.length(); i++) {
			for (int j = i; j < s.length(); j++) {
				if (check(s.substring(i, j))) {
					max = Math.max(max, j - 1 - i);
				}
			}
		}
		return max;
	}

	// best solution
	int longestSubStringWithoutRepeatBest(String s) {
		int max = 0;
		Queue<Character> q = new LinkedList<>();
		for (int i = 0; i < s.length(); i++) {
			while (q.contains(s.charAt(i))) {
				q.poll();
			}
			q.add(s.charAt(i));
			max = Math.max(max, q.size());
		}
		return max;
	}

	int houseRob(int[] nums) {

		if (nums.length == 0) {
			return 0;
		}
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		dp[1] = Math.max(nums[0], nums[1]);
		for (int i = 2; i < nums.length; i++) {
			dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
		}
		return dp[nums.length - 1];
	}

	// naive
	List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		if (nums.length < 2) {
			return result;
		}
		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 2; i++) {
			if (i > 0 && nums[i] == nums[i - 1])
				continue;
			int left = i + 1;
			int right = nums.length;
			while (left < right) {
				int var = nums[left] + nums[right] + nums[i];
				if (var == 0) {
					List<Integer> temp = new ArrayList<>();
					temp.add(nums[i]);
					temp.add(nums[left]);
					temp.add(nums[right]);
					result.add(temp);
					left++;
					right--;

					while (left < right && nums[left] == nums[left - 1])
						left++;
					while (right > left && nums[right] == nums[right + 1])
						right--;
				} else if (var > 0) {
					right--;
				} else
					left++;
			}
		}
		return result;
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
	}

	List<List<Integer>> levelOrder(TreeNode root) {

		List<List<Integer>> result = new ArrayList<>();
		// check input
		if (root == null) {
			return result;
		}
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		// first level
		result.add(new ArrayList<>(root.val));
		while (!q.isEmpty()) {
			Queue<TreeNode> curr = new LinkedList<>();
			List<Integer> temp = new ArrayList<>();
			while (!q.isEmpty()) {
				TreeNode currNode = q.poll();
				if (currNode.left != null) {
					curr.add(currNode.left);
					temp.add(currNode.left.val);
				}
				if (currNode.right != null) {
					curr.add(currNode.right);
					temp.add(currNode.right.val);
				}
			}
			if (temp.size() > 0)
				result.add(temp);
			q = curr;
		}
		return result;
	}

	List<String> binaryTreePath(TreeNode root) {
		List<String> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		getPath(new String(), root, result);
		return result;
	}

	void getPath(String currString, TreeNode root, List<String> result) {
		if (root.left == null && root.right == null) {
			result.add(currString + root.val);
		}
		if (root.left != null) {
			getPath(currString + root.left.val + "->", root.left, result);
		}
		if (root.right != null) {
			getPath(currString + root.right.val + "->", root.right, result);
		}
	}

	// naive
	int subArraySum(int[] nums, int k) {
		int len = nums.length;
		int sum = 0;
		int count = 0;
		for (int i = 0; i < len; i++) {
			for (int j = i; j < len; j++) {
				sum += nums[j];
				if (sum == k)
					count++;
			}
			sum = 0;
		}
		return count;
	}

	// implement Tree and BFS DFS
	public class Tree {
		Node[] nodes;

		public class Node {
			Node[] child;
			int val;
			boolean visited;

			public Node(int data) {
				this.val = data;
				this.visited = false;
			}
		}

		void DFS(Node root) {
			if (root == null) {
				return;
			}
			if (root.child == null) {
				root.visited = true;
				System.out.println(root.val);
				return;
			}
			System.out.println(root.val);
			root.visited = true;
			for (Node item : root.child) {
				if (item.visited == false) {
					item.visited = true;
					DFS(item);
				}
			}
		}
	}
	double findSquareRoot(int n) {
		final double E = 0.00001;
		double left = 0;
		double right = n;
		
		while(left < right) {
			double mid = (left + right) / 2;
			if(Math.abs(n-mid*mid) < E) {
				return mid;
			}
			else if(mid > n / mid) {
				right = mid;
			}
			else left = mid;
		}
		return left;
	}
	
	public int mostWater(ArrayList<Integer> arr) {
		// write your awesome code here
        // naive solution
        int max = 0;
        int left = 0;
        int right = arr.size() - 1;
        while(left < right) {
        	int temp = (right - left) * Math.min(arr.get(left), arr.get(right));
        	max = Math.max(max, temp);
        	if(arr.get(left) >= arr.get(right)) right--;
        	else left++;
        }
        return max;

    }	
	
	public int removeDuplicates(ArrayList<Integer> arr) {
		Set<Integer> set = new HashSet<Integer>();
		for(int item : arr) {
			set.add(item);
		}
		arr = new ArrayList<Integer>();
		int id = 0;
		for(int item : set) {
			arr.add(item);
		}
		return arr.size();
    }	
	
	 ListNode detectAndRemoveLoop(ListNode head) {
		 
		 if(head == null)
			 return head;
		 ListNode slow = head;
		 ListNode fast = head;
		 
		 while(fast != null && fast.next != null) {
			 slow = slow.next;
			 fast = fast.next.next;
			 if(slow == fast)
				 break;
		 }
		 ListNode temp = head;
		 while(temp != slow.next) {
			 temp = temp.next;
			 slow = slow.next;
		 }
		 slow.next = null;
		 return head;
		        
	 }
	 
	 List<List<Integer>> fourSum(int[] nums, int target){
		 List<List<Integer>> result = new ArrayList<List<Integer>>();
		 if(nums.length < 4)
			 return result;
		 // sort arrays
		 Arrays.sort(nums);
		 int len = nums.length;
		 for(int i = 0; i < len -3; i++) {
			 if(i > 0 && nums[i] == nums[i-1]) continue;
			 for(int j = i+1; j < len - 2; j++) {
				 if(j > i+1 && nums[j] == nums[j-1]) continue;
				 int left = j + 1;
				 int right = len - 1;
				 while(left < right) {
					 List<Integer> temp = new ArrayList<Integer>();
					 int check = nums[i] + nums[j] + nums[left] + nums[right] - target;
					 if(check == 0) {
						 temp.add(nums[i]);
						 temp.add(nums[j]);
						 temp.add(nums[left]);
						 temp.add(nums[right]);
						 result.add(temp);
						 while(left < right && nums[left] == nums[left-1]) left++;
						 while(right > left && nums[right] == nums[right+1]) right--;
						 left++;
						 right--;
					 }
					 else if( check > 0) {
						 right--;
					 }
					 else left++;
				 }
			 }
		 }
		 return result;
	 }
	 
	 
	 List<List<Integer>> fourSumV1(int[] nums, int target){
		 List<List<Integer>> result = new ArrayList<List<Integer>>();
		 if(nums.length < 4 || nums == null)
			 return result;
		 return kSum(nums, target,  0, 4); 
	 }
	 List<List<Integer>> kSum(int[] nums, int target, int index, int K){
		 List<List<Integer>> result = new ArrayList<List<Integer>>();
		 if(index > nums.length - 1)
			 return result;
		 if(K == 2) {
			 int left = index;
			 int right = nums.length - 1;
			 while(left < right) {
				 List<Integer> temp = new ArrayList<Integer>();
				 int check = nums[left] + nums[right] - target;
				 if(check == 0) {
					 temp.add(nums[left]);
					 temp.add(nums[right]);
					 result.add(temp);
					 // avoid duplicate
					 while(left < right && nums[left] == nums[left+1]) left++;
					 while(left < right && nums[right] == nums[right-1]) right--;
					 left++;
					 right--;
				 }
				 else if(check > 0) {
					 right--;
				 }
				 else left++;
			 }
			 
			 // two pointer here
		 }
		 else {
			 for(int i = index; i < nums.length - K + 1; i++) {
				 List<List<Integer>> temp = kSum(nums, target - nums[i], index + 1, K - 1);
				 if(temp != null) {
					 for(List<Integer> item : temp) {
						 item.add(nums[i]);
					 }
					 result.addAll(temp);
				 }
				 // avoid duplicated
				 while(i < nums.length - 1 && nums[i] == nums[i+1]) i++;

			 }
			 
		 }
		 return result;
		 
	 }
	 
	 int maxArea(int[] height) {
		 // naive

		 int max = 0;
		 
//		 for(int i = 0; i < height.length - 1; i++) {
//			 for(int j = i + 1; j < height.length; j++) {
//				 max = Math.max(max, (j- i) * Math.min(height[i], height[j]));
//			 }
//		 }
//		 return max;       
		 
		 //two pointer
			 int left = 0;
			 int right = height.length - 1;
			 while(left < right) {
				 max = Math.max(max, (right - left) * Math.min(height[left], height[right]));
				 if(height[left] <= height[right]) {
					 left++;
				 }
				 else right--;
			 }
			 return max;
		 
	 }
	
	public static void main(String[] args) {	

		System.out.println("Say hi!!!");
		
		mockLeetcode test = new mockLeetcode();
		
		
		
		test.fourSum(new int[]{1,0,-1,0,-2,2},0);
		
		
		
		
	

	}
}
