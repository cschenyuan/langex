package com.atella.scala.guide.implicitt

/**
  * Created by chenyuan on 2018/4/19.
  */
class PreferredPrompt(val preference: String)

object JoesPrefs {
  implicit val prompt = new PreferredPrompt("yuan> ")
  implicit val ads = "You need some Spark."
}

object Greeter {

  def greet(name: String)(implicit prompt: PreferredPrompt,ads: String): Unit = {
    println(s"Welcome $name. ")
    println(prompt.preference)
    println(s"##### $ads")
  }

}

object ImplicitParamTest extends App {

  import JoesPrefs._
  Greeter.greet("Yuan")

}
