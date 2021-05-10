package mock;

public class LRUCache {
	
	
	
	public class Node{
		int val;
		Node pre;
		Node next; 
		public Node(int data) {
			this.val = data;
		}
	}
	public class DoubleLL{
		Node head;
		
		void push(int val) {
			Node newNode = new Node(val);
			// check head
			newNode.next = head;
			newNode.pre = null;
			if(head != null) {
				head.pre = newNode;
			}
			head = newNode;
		}
		
		void print() {
			Node curr = head;
			while(curr != null) {
				System.out.print(curr.val + "-->");
				curr = curr.next;
			}
			
		}
	}
	
	public static void main(String args[]) {
		
		System.out.println("Say hi!!!");
		
		LRUCache test = new LRUCache();
		
		DoubleLL ll = test.new DoubleLL();
		
		ll.push(1);
		ll.push(2);
		ll.push(3);
		ll.push(4);
		ll.push(5);
		
		ll.print();
		
		
	}

}
