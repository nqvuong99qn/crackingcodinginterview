class MyArray{
    constructor(){
        this.length = 0;
        this.data = {};
    }
    get(index){
        return this.data[index];
    }
    push(item){
        this.data[this.length] = item;
        this.length++;
        return this.data;
    }
    pop(){
        const item = this.data[this.length - 1];
        delete this.data[this.length - 1];
        this.length--;
        return item;
    }
    deleteAtIndex(index){
        const item = this.data[index];
        this.shiftItem(index);
        return item;
    }
    shiftItem(index){
        for(let i = index; i < this.length - 1; i++){
            this.data[i] = this.data[i+1];
        }
        delete this.data[this.length-1];
        this.length--;
    }
}

console.log('-------------- Array Implementation -------------')

const arr =  new MyArray();


arr.push(1)
arr.push(2)
arr.push(3)
arr.push(4)

console.log(arr.data, arr.length)

