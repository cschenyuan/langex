package com.atella.scala.guide.control

import java.io.{File, PrintWriter}

/**
  * Created by chenyuan on 2018/4/11.
  */
object ImproveControl {

  def fileWriter(file: File)(op: PrintWriter => Unit): Unit = {
    val writer = new PrintWriter(file)
    try {
      op(writer)
    } finally {
      writer.close()
    }
  }

  def test(): Unit = {
    val file = new File("console.log")
    fileWriter(file) {
      writer => writer.println(new java.util.Date)
    }
  }

}
