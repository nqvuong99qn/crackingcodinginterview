package leetcode;

public class ValidateBST {
	
	public class TreeNode{
		int data;
		TreeNode left;
		TreeNode right;
		TreeNode(int data){
			this.data = data;
		}
	}
	// using recursion
	public class Solution{
		
		boolean isBST(TreeNode root) {
			
			//check null
			if(root == null) {
				return true;
			}
			else return ValidateBST(root, Long.MAX_VALUE, Long.MIN_VALUE);
		}
		boolean ValidateBST(TreeNode root, long maxValue, long minValue) {
			
			if(root == null) {
				return true;
			}
			else if(root.data >= maxValue || root.data <= minValue) {
				return false;
			}
			else {
				return ValidateBST(root.left, root.data, minValue) && 
						ValidateBST(root.right, maxValue, root.data);
			}
		}
					
	}
	
	
	
	

	public static void main(String[] args) {

		System.out.println("say hi!!");
		
		ValidateBST test = new ValidateBST();
		Solution s = test.new Solution();
		
		TreeNode n1 = test.new TreeNode(1);
		TreeNode n2 = test.new TreeNode(2);
		TreeNode n3 = test.new TreeNode(3);
		n2.left = n3;
		n2.right = n1;
		
		System.out.println("Expected Result: " + s.isBST(n2));

		

	}

}
