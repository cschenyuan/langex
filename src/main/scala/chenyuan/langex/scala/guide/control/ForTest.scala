package com.atella.scala.guide.control

import java.io.File

/**
  * Created by chenyuan on 2018/4/10.
  */
object ForTest {

  def testYield(): Unit = {
    val files = new File(".").listFiles()
    def scalaFiles =
      for (
        file <- files
        if file.getName.endsWith(".scala")
      ) yield {
        file
      }
    scalaFiles
  }
}
