import scala.annotation.newMain
trait List {
  def append(value: Int): Unit
  def prepend(value: Int): Unit
  def delete(value: Int): Unit
  def print(): Unit

}

case class LinkedList() extends List {
  var head: Node = _

  def append(value: Int): Unit = {
    head match
      case null => {
        head = new Node(value, null)
      }
      case  _ => {
        val newNode = new Node(value, null)
        var last = head
        while(last.next != null){
          last = last.next
        }
        last.next = newNode
      }
    
  }
  def delete(value: Int): Unit = ???
  def prepend(value: Int): Unit = ???
  def print(): Unit = {
    var temp = head
    while(temp.next != null){
      println(temp.value)
      temp = temp.next
    }  
    println(temp.value)
  }

}

class Node(var value: Int, var next: Node) {
  def getData: Int = this.value
  def getNext: Node = this.next

}

object Test {
  def main(args: Array[String]) = {
    val ll = LinkedList()

    ll.append(1)
    ll.append(2)

    ll.print()
    println("Say hi!!!")
  }
}
