case class Node(data: Int, var next: Option[Node] = None)

trait LL {
  def addFirst(value: Int): Unit
//   def addLast(value: Int): Unit
//   def deleteFirst(value: Int): Unit
//   def deteleLast(value: Int): Unit
  def show(): Unit
}

class LinkedList(var head: Option[Node] = None) extends LL {

  override def addFirst(value: Int): Unit = {
    var newNode = Node(value)
    if (head.isEmpty) {
      head = Some(newNode)
    } else {
      newNode.next = head
      head = Some(newNode)
    }
  }

  override def show(): Unit = {
    var currNode = head
    while (!currNode.get.next.isEmpty) {
      println(currNode.get.data)
      currNode = currNode.get.next
    }
  }
}

object Test {
  def main(args: Array[String]) = {
    val ll = new LinkedList()
    ll.addFirst(1)
    ll.addFirst(2)
    ll.addFirst(3)

    ll.show()
    println(ll.head.toString())

  }
}
