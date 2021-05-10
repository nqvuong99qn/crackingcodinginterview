package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Subsets {

	List<List<Integer>> solution(int[] nums) {

		List<List<Integer>> result = new ArrayList<>();
		find(result, nums, new Stack<>(), 0);
		return result;
	}

	void find(List<List<Integer>> result, int[] nums, Stack<Integer> s, int index) {
		if (index == nums.length) {
			result.add(new ArrayList<>(s));
			return;
		}
		s.push(nums[index]);
		find(result, nums, s, index + 1);
		s.pop();
		find(result, nums, s, index + 1);
	}

	public static void main(String[] args) {

		System.out.println("say hi!!");
		
		Subsets test = new Subsets();

		System.out.println("Expected result: " + test.solution(new int[]{1, 2}));

	}

}
