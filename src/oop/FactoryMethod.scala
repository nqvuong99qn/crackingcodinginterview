/*
Factory Method

 */

trait Button {
  def f2(): String
  def f1(): String
}

abstract class Dialog {
  def render(): Unit = {
    val button = createButton()
    println(button.f1() + button.f2())
  }

  def createButton(): Button
}

class WindowDialog extends Dialog {
  override def createButton(): Button = new WindowButton
}

class HtmlDialog extends Dialog {
  override def createButton(): Button = new HtmlButton
}

class HtmlButton extends Button {
  override def f2(): String = "f2 logic html"
  override def f1(): String = "f1 logic html"

}

class WindowButton extends Button {
  override def f2(): String = "f2 logic window"
  override def f1(): String = "f1 logic window"

}

object Test {
  def main(args: Array[String]): Unit = {
    val a = new WindowDialog()
    a.render()
  }
}
