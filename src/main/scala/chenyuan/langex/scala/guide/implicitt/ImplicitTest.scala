package com.atella.scala.guide.implicitt

import scala.collection.Seq

/**
  * Created by chenyuan on 2018/4/18.
  */

object ImplicitTest extends App {

  implicit def wrapString(s: String) = new Seq[Char] {
    override def length = s.length

    override def apply(idx: Int) = s.charAt(idx)

    override def iterator = s.toCharArray.iterator
  }



}
