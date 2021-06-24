package com.atella.scala.guide.implicitt

/**
  * Created by chenyuan on 2018/4/19.
  */
object ImplicitParamTest2 {

  // Defines the View Bounds
  def maxList[T <% Ordered[T]](elements: List[T]): T =
    elements match {
      case List() =>
        throw new IllegalArgumentException("empty list")
      case List(x) => x
      case x :: rest =>
        val maxRest = maxList(rest)
        if (x > maxRest) x
        else maxRest
    }

  // Replace View Bounds with Implicit Parameter
  def maxList1[T](elements: List[T])(
    implicit converter: T => Ordered[T]): T =
    elements match {
      case List() =>
        throw new IllegalArgumentException("empty list")
      case List(x) => x
      case x :: rest =>
        val maxRest = maxList(rest)
        if (x > maxRest) x
        else maxRest
    }

}
