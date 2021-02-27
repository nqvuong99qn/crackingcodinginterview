package mastercodinginterview;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;

import com.sun.source.tree.Tree;

public class TreeAndGraph {
	
	public class Graph{
		Node[] nodes;
		
		void search(Node root) {

			if(root.child == null) {
				root.visited = true;
				System.out.println(root.data);
				return;
			}
			System.out.println(root.data);
			root.visited = true;
			for(Node node : root.child) {
				if(node.visited == false)
					search(node);
			}
		}
		
		void BFS(Node root) {
			
			LinkedList<Node> q = new LinkedList<>();
		
			root.visited = true;	
			q.add(root);
			while(!q.isEmpty()) {
				Node r = q.remove();
				while(r.child == null) {
					System.out.println(r.data);
					r = q.remove();
					
				}
				System.out.println(r.data);
				for(Node node : r.child) {
					if(node.visited == false) {
						node.visited = true;
						q.add(node);
						
					}
						
				}
				
			}
		}
		
	

	}
	public class Node{
		int data;
		Node[] child;
		boolean visited;
		
		
	}
	
	Node init(int data, boolean b) {
		Node newNode = new Node();
		newNode.data = data;
		newNode.visited = b;
		return newNode;
	}
	Graph init(Node[] nodes) {
		Graph g = new Graph();
		g.nodes = nodes;
		return g;
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		System.out.println("Say hi!!!!");

		// init data
		TreeAndGraph test = new TreeAndGraph();
		
		Node n0 = test.init(0, false);
		Node n1 = test.init(1, false);
		Node n2 = test.init(2, false);
		Node n3 = test.init(3, false);
		Node n4 = test.init(4, false);
		Node n5 = test.init(5, false);
		
		n0.child = new Node[] {n1, n4, n5};
		n1.child = new Node[] {n3, n4};
		n2.child = new Node[] {n1};
		n3.child = new Node[] {n2, n4};
		n4.child = null;
		n5.child = null;
		
		
		Node[] nodes = {n0, n1, n2, n3, n4, n5};
		Graph g = test.init(nodes);
		
		//g.search(n0);
		
		System.out.println("Finish!");
		
		g.BFS(n0);
		

		
	}

}
