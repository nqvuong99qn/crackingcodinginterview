class Node{
    constructor(value, next=null){
        this.data = value;
        this.next = next;
    }
}

class LinkedList{
    constructor(){
        this.head = null;
        this.length = 0;
    }
    addToHead(data){
        let newNode = new Node(data);
        newNode.next = this.head;
        this.head = newNode;
        this.length++;
        return this.head;
    }
    addToTail(data){
        let newNode = new Node(data);
        let curr = this.head;
        while(curr.next != null){
            curr = curr.next;
        }
        curr.next = newNode;
        this.length++;
        return this.head;
    }
    deleteAtHead(){
        this.head = this.head.next;
        this.length--;
        return this.head;
    }
    deleteAtTail(){
        let curr = this.head;
        let previous = this.head;
        while(curr.next != null){
            previous = curr;
            curr = curr.next;
        }
        previous.next = null;
        this.length--;
        return this.head;
    }

    deleteViaValue(value){

        let curr = this.head;
        let previous = null;
        if(curr != null && curr.data == value){
            this.head = null;
            return this.head;
        }
        while(curr != null && curr.data != value){
            previous = curr;
            curr = curr.next;
        }
        if(curr == null){
            throw new Error("Nothing to delete");
        }
        previous.next = curr.next;
        return this.head;
    }
}



const ll = new LinkedList()


ll.addToHead(1)
ll.addToHead(2)
ll.addToTail(3)
ll.deleteViaValue(3)

console.log(ll)