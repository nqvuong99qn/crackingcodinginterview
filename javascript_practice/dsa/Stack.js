
/* 
    This code is implemented by myself.
    @nqvuong99qn
    @jackingnevadie
*/

console.log('Implementing Stack')

class Node{
    constructor(data){
        this.data = data;
        this.next = null;
    }
}

class Stack{
    constructor(){
        this.head = null;
        this.length = 0;
    }

    push(data){
        // check head
        if(this.head == null){
            this.head = new Node(data);
            this.length++;
            return;
        }
        let newNode = new Node(data);
        newNode.next = this.head;
        this.head = newNode;
        this.length++;
    }

    pop(){
        // check head
        if(this.head == null){
            throw new Error("Stack is null");
        }
        let resultNode = this.head;
        this.head = this.head.next;
        return resultNode.data;
    }

    top(){
        if(this.head == null){
            throw new Error("Stack is null");
        }
        return this.head.data;
    }
    contains(data){
        if(this.head == null){
            return false;
        }
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