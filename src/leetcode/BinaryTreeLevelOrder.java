package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrder {
	
	public class TreeNode{
		int data;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){
			this.data = x;
		}
	}
	public class Solution{
		
		List<List<Integer>> find(TreeNode root){
			
			
			// check null
			if(root == null) {
				return null;
			}
			
			List<List<Integer>> result = new ArrayList<>();
			List<Integer> rootList = new ArrayList<>();
			rootList.add(root.data);
			result.add(rootList);
			
			Queue<TreeNode> q = new LinkedList<>();
			q.add(root);
			
			while(!q.isEmpty()) {
				
				Queue<TreeNode> currQ = new LinkedList<>();
				List<Integer> tempList = new ArrayList<>();
				
				while(!q.isEmpty()) {
					TreeNode t = q.remove();
					if(t.left != null) {
						tempList.add(t.left.data);
						currQ.add(t.left);
					}
					if(t.right != null) {
						tempList.add(t.right.data);
						currQ.add(t.right);
					}
						
				}
				if(tempList.size() > 0)
					result.add(tempList);
				q = currQ;
			}
			return result;
		}
		
		
	}
	
	
	
	public static void main(String[] args) {
		
		System.out.println("Say hi!!!");
		
		BinaryTreeLevelOrder test = new BinaryTreeLevelOrder();
		Solution s = test.new Solution();
		
		TreeNode n1 = test.new TreeNode(3);
		TreeNode n2 = test.new TreeNode(6);
		TreeNode n3 = test.new TreeNode(20);
		TreeNode n4 = test.new TreeNode(15);
		TreeNode n5 = test.new TreeNode(7);
		
		n1.left = n2;
		n1.right = n3;
		n3.left = n4;
		n3.right = n5;
		
		List<List<Integer>> result = s.find(n1);
		
		System.out.println("Expected result: " + result.toString());
		
		
		
		
		
	}

}
