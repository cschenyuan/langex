package com.atella.scala.guide.casematch

/**
  * Created by chenyuan on 2018/4/12.
  */
object PartialFunctionTest {

  val filterInt: PartialFunction[Any, Boolean] = {
    case e: Int => true
    case _ => false
  }

  def main(args: Array[String]): Unit = {
    println(List(1, 2, "3").filter(filterInt))
    val p = (e: Int) => e > 0
    println(List(1, 2, "3").filter(e => true).collect({
      case e: Int if p(e) => "Int"
    }).mkString(",")
    )
    Map(1 -> 2).collect({
      case t if t._1.toString.toInt > 0 =>
        println()
        t._1
    })
  }
}
