package com.atella.scala.guide.cls.example1

/**
  * Created by chenyuan on 2018/4/11.
  */
class UniformElement(char: Char,
                     override val width: Int,
                     override val height: Int
                    ) extends Element {

  private val line = char.toString * width

  def contents = Array.fill(height)(line)

}

