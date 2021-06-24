package com.atella.scala.guide.func

/**
  * Created by chenyuan on 2018/4/10.
  */
object FunctionTest {

  def testPlaceHolder(): Unit = {
    val sum = (_: Int) + (_:Int)
    println(sum(1, 2))
  }

}
