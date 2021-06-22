package com.atella.scala.guide.control

import java.io.File

/**
  * Created by chenyuan on 2018/4/10.
  */
object FileMatcher {

  private val files = new File(".").listFiles()

  private def filesMatching(query: String,
                    mather: (String) => Boolean) = {
    for (file <- files if mather(file.getName))
      yield file.getName
  }

  // query is the free variable
  def filesEnding(query: String) {
    filesMatching(query, _.endsWith(query))
  }

  def filesContaining(query: String) {
    filesMatching(query, _.contains(query))
  }

  def filesRegex(regex: String): Array[String] = {
    filesMatching(regex, _.matches(regex))
  }

}
