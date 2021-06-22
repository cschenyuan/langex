package com.atella.scala.guide.trt

import scala.collection.mutable.ArrayBuffer

/**
  * Created by chenyuan on 2018/4/11.
  */
abstract class IntQueue {
  def get(): Int
  def put(x: Int)
}

trait Doubling extends IntQueue {
  abstract override def put(x: Int): Unit = {
    println("doubling")
    super.put(x * 2)
  }
}

trait Increasing extends IntQueue {
  abstract override def put(x: Int): Unit = {
    println("increasing")
    super.put(x + 1)
  }
}

trait Filtering extends IntQueue {
  abstract override def put(x: Int): Unit = {
    println("filtering")
    if (x >= 0)
      super.put(x)
  }
}

class BasicIntQueue extends IntQueue {
  private val queue = new ArrayBuffer[Int]
  override def get(): Int = queue.remove(0)
  override def put(x: Int): Unit = queue += x
}

object StackableMod {

  def main(args: Array[String]): Unit = {
    val queue = new BasicIntQueue with Increasing with Filtering with Doubling
    queue.put(-1)
    queue.put(0)
    queue.put(1)
    println(queue.get())
    println(queue.get())
  }

}
