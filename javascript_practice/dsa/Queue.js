class Node{
    constructor(data){
        this.data = data;
        this.next = null;
    }
}

class Queue{
    constructor(){
        this.head = null;
    }
    enQueue(data){
        if(this.head == null){
            this.head = new Node(data);
            return;
        }
        let curr = this.head;
        while(curr.next != null){
            curr = curr.next;
        }
        curr.next = new Node(data);
    }
    deQueue(){
        if(this.head == null){
            return;
        }
        let returnNode = this.head;
        this.head= returnNode.next;
        return returnNode.data;
    }
    contains(data){
        let curr = this.head;
        while(curr != null){
            if(curr.data == data){
                return true;
            }
            curr = curr.next;
        }
        return false;
    }
}