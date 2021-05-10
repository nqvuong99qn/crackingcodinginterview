package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import leetcode.BinaryTreePath.TreeNode;

public class CountNumberOfTeam {
	public int numTeams(int[] rating) {

		int len = rating.length;
		int count = 0;

		// naive solution
//		 for(int i = 0; i < len - 2; i++) {
//			 for(int j = i + 1; j < len - 1; j++) {
//				 for(int k = j + 1; k < len; k++) {
//					 if(rating[i] < rating[j] && rating[j] < rating[j]) {
//						 count++;
//					 }
//					 if(rating[i] > rating[j] && rating[j] > rating[j]) {
//						 count++;
//					 }
//				 }
//			 }
//		 }

		// best solution

		for (int i = 0; i < len; i++) {
			int leftSmaller = 0;
			int leftLarger = 0;
			int rightSmaller = 0;
			int rightLarger = 0;
			for (int j = 0; j < i; j++) {
				if (rating[j] < rating[i]) {
					leftSmaller++;
				}
				if (rating[j] > rating[i]) {
					leftLarger++;
				}
			}
			for (int k = i + 1; k < len; k++) {
				if (rating[k] < rating[i]) {
					rightSmaller++;
				}
				if (rating[k] > rating[i]) {
					rightLarger++;
				}
			}
			count += leftSmaller * rightLarger + leftLarger * rightSmaller;
		}
		return count;
	}

	

}
