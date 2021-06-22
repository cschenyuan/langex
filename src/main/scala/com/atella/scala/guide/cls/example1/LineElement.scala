package com.atella.scala.guide.cls.example1

/**
  * Created by chenyuan on 2018/4/11.
  */
class LineElement(s: String) extends Element {

  override def contents: Array[String] = Array(s)

  override def height: Int = 1

  override def width: Int = s.length

}
