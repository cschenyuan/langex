package com.atella.scala.guide.abstractobj

/**
  * Created by chenyuan on 2018/4/17.
  */

trait Abstract {
  type T
  def transform(x: T): T
  val initial: T
  var current: T
}

class Concrete extends Abstract {
  type T = String
  def transform(x: String) = x + x
  val initial = "hi"
  var current = initial

  def print() = println(s"$initial")
}

trait AbstractTime {
  def hour: Int
  def hour_= (x: Int)
}

class Hour extends {
  var hour = 1
} with AbstractTime

object AbstractTest extends App {
}
