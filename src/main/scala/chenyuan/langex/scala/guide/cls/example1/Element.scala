package com.atella.scala.guide.cls.example1

/**
  * Created by chenyuan on 2018/4/11.
  */
abstract class Element {

  def contents: Array[String]

  def height: Int = contents.length

  def width: Int = if(height == 0) 0 else contents(0).length
}

object Element {

  def elem(array: Array[String]) : Element = {
    new ArrayElement(array)
  }

  def elem(str : String) : Element = {
    new LineElement(str)
  }

  def elem(ch : Char, width: Int, height: Int) : Element = {
    new UniformElement(ch, width, height)
  }
}
