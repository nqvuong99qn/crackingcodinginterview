package mock;

public class MergeLL {
	
	
	public class Node{
		Node next;
		int val;
		public Node(int data) {
			this.val = data;
		}
	}
	public class LL{
		Node head;
		void push(int data) {
			Node newNode = new Node(data);
			newNode.next = head;
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
	
	LL merge(LL l1, LL l2) {
		LL result = new LL();
		
		
		
		
		
		return result;
	}

	
	
	public static void main(String args[]) {
		System.out.println("say hi");
		
		MergeLL test = new MergeLL();
		LL l1 = test.new LL();
		LL l2 = test.new LL();
		
		l1.push(4);
		l1.push(2);
		l1.push(3);
		l1.push(1);
		l1.push(5);
		
		l2.push(2);
		l2.push(3);
		l2.push(6);
		l2.push(5);
		l2.push(1);
		
		l1.print();
		System.out.println();
		l2.print();
		
	
		
		
	}
}
