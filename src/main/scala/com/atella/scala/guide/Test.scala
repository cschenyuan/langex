package com.atella.scala.guide

/**
  * Created by chenyuan on 2018/10/26.
  */
object Test {

  def main(args: Array[String]): Unit = {
    val list1 = List(1,2,3)
    val list2 = List(4,5)
    val list3 = list1 ::: list2
    list3.foreach(println)
  }

}
