'use strict';

console.log('Longest consecutive number in given array!');

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

function longestConsecutiveNumber(arr){
    const q = new Queue();
    arr.forEach(element => {
        q.enQueue(element);
    });
    let result = 0;
    arr.forEach(element => {
       if(!q.contains(element-1)){
           let currMax = 1;
           while(q.contains(element+1)){
               currMax++;
               element++;
           }
           result = Math.max(result, currMax);
       }
    });
    return result;
}

console.log(longestConsecutiveNumber([1, 2, 234, 333]))






