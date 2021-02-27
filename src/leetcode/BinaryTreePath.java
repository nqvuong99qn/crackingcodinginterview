package leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePath {
	
	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){
			this.val = x;
		}
	}
	
	// using recursion
	List<String> solution(TreeNode root){

		List<String> result = new ArrayList<>();
		if(root == null) {
			return result;
		}
		getPath(new String(), root, result);
		return result;
	}
	void getPath(String currString, TreeNode root, List<String> result) {
		if(root.left == null && root.right == null) {
			result.add(currString+ root.val);
		}
		if(root.left != null) {
			getPath(currString + root.val + "-->", root.left, result);
		}
		if(root.right != null) {
			getPath(currString + root.val + "-->", root.right, result);
		}

	}

}
