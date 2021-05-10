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
	
	boolean hasPathSum(TreeNode root, int targetSum) {
		if(root == null)
			return false;
		
		if(root.left == null && root.right == null && targetSum - root.val == 0)
			return true;
		return hasPathSum(root.left, targetSum - root.val) ||
				hasPathSum(root.right, targetSum - root.val);
					
	}
	
	
	
	
	
	public static void main(String args[]) {
		System.out.println("shihi");
		
		
		BinaryTreePath test = new BinaryTreePath();
		
		TreeNode n5 = test.new TreeNode(5);
		TreeNode n4 = test.new TreeNode(4);
		TreeNode n8 = test.new TreeNode(8);
		TreeNode n11 = test.new TreeNode(11);
		TreeNode n13 = test.new TreeNode(13);
		TreeNode n3 = test.new TreeNode(3);
		TreeNode n7 = test.new TreeNode(7);
		TreeNode n2 = test.new TreeNode(2);
		TreeNode n1 = test.new TreeNode(1);
		
		n5.left = n4;
		n5.right = n8;
		n4.left = n11;
		n11.left = n7;
		n11.right = n2;
		n8.left = n13;
		n8.right = n4;
		n4.right = n1;
		
		
		test.hasPathSum(n5, 22);
		
		
		
	}

}
