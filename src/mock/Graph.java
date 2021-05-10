package mock;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Graph {
	Node root;
	Node[] child;
	
	
	public static class Node{
		int val;
		Node[] child;
		boolean visited;
		public Node(int data) {
			this.val = data;	
			this.visited = false;
			this.child = null;
		}
	}
	void DFS() {
		if(root == null)
			return;
		Stack<Node> s = new Stack<>();
		s.push(root);
		root.visited = true;
		while(!s.isEmpty()) {
			Node currNode = s.pop();
			System.out.println(currNode.val);
			if(currNode.child != null) {
//				Arrays.sort(currNode.child, new Comparator<Node>() {
//					public int compare(Node n1, Node n2) {
//						return n1.val > n2.val ? 1 : -1;
//					}
//				});
				for(Node item : currNode.child) {
					if(item.visited == false) {
						item.visited = true;
						s.push(item);
					}
				}
			}
			
		}
	}
	
	
	public static void main(String args[]) {
		
		System.out.println("Say hi!!");
		
		Node n0 = new Node(0);
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		
		n0.child = new Node[] {n1, n4, n5};
		n1.child = new Node[] {n3, n4};
		n2.child = new Node[] {n2};
		n3.child = new Node[] {n2, n4};
		
		Graph g = new Graph();
		g.root = n0;
		g.DFS();
	}


	private static Node Node(int i) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
