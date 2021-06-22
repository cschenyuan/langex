package com.atella.scala.guide.control

import java.io.{File, FileNotFoundException, FileReader, IOException}

/**
  * Created by chenyuan on 2018/4/10.
  */
object ExceptionCaptureTest {

  def test(): Unit = {
    val reader = new FileReader("App.scala")
    try {
      // io codes
    } catch {
      case ex : FileNotFoundException => println(ex.getMessage)
      case ex : IOException => ex.printStackTrace()
    } finally {
      reader.close()
    }
  }

}
