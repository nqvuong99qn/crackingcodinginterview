package mastercodinginterview;

public class BST {
	
	Node head;
	
	public class Node{
		int data;
		Node left;
		Node right;
		
		Node(int data){
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	
	void add(int data) {
		Node newNode = new Node(data);
		if(head == null) {
			head = newNode;
		}
		else {
			Node curr = head;
			Node temp = null;
			while(curr != null) {
				temp = curr;
				if(curr.data < data) {
					curr = curr.right;
				}
				else curr = curr.left;
			}
			if(temp.data > data)
				temp.left = newNode;
			else temp.right = newNode;
		}
	}
	
	void printInOrder(Node head) {
		if(head != null) {
			printInOrder(head.left);
			System.out.print(head.data + "-->");
			printInOrder(head.right);
		}
		
	}
	
	void printPreOrder(Node head) {
		if(head != null) {
			System.out.print(head.data + "-->");
			printInOrder(head.left);
			printInOrder(head.right);
		}
		
	}
	
	void printPostOrder(Node head) {
		if(head != null) {
			printInOrder(head.left);
			printInOrder(head.right);
			System.out.print(head.data + "-->");
		}
		
	}
	
	
	public static void main(String[] args) {
		System.out.println("Say hi!!!!");
		
		BST test = new BST();
		
		test.add(9);
		test.add(6);
		test.add(7);	
		test.add(12);
		test.add(11);
		
		System.out.println("In Order: ");
		test.printInOrder(test.head);
		System.out.println();
		System.out.println("Pre Order: ");
		test.printPreOrder(test.head);
		System.out.println();
		System.out.println("Post Order: ");
		test.printPostOrder(test.head);
		
		
	}
	
	
	

}
