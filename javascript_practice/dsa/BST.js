class Node{
    constructor(data, left, right){
        this.data = data;
        this.left = left;
        this.right = right;
    }
}

class BTS{
    constructor(){
        this.root = null;
    }

    add(value){
        if(this.root == null){
            this.root = new Node(value);
            return;
        }
        let curr = this.root;
        let prev = null;
        while(curr != null){
            prev = curr;
            if(value > curr.data){
                curr = curr.right;
            }
            else{
                curr = curr.left;
            }
        }
        if(value > prev.data){
            prev.right= new Node(value);
        }
        else{
            prev.left = new Node(value);
        }
    }

    delete(key){

    }

    search(key){

    }
}


const bst = new BTS()

bst.add(1)
bst.add(2)
bst.add(3)
bst.add(4)

console.log(bst)
