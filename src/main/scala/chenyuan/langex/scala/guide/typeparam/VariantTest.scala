package com.atella.scala.guide.typeparam

import scala.collection.immutable.HashSet

/**
  * Created by chenyuan on 2018/4/13.
  */

class Cell[+T, -U](v: T, p: U) {

  private[this] var value = v
  private[this] var param = p

  /**
    * 返回值类型是协变的或不变的
    * 因为不可能生产出子类类型的值
    */
  def get = new Cell(value, param)

  /**
    * 参数类型是逆变或不变的
    * 因为函数不能消费父类类型的值
    */
  def set[M >: T, N <: U](e : Cell[M, N]) {  }

  def apply(p : U): T = { value }
}

object VariantTest {

  def main(args: Array[String]): Unit = {
    val c1 = new Cell[String, Set[String]]("abc", Set())
    c1.set(new Cell(AnyRef, HashSet()))
    val v : AnyRef = c1.get
    val c2: Cell[Any, HashSet[String]] = c1
  }

}
