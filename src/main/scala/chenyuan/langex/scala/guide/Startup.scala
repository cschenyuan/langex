package com.atella.scala.guide

import org.apache.commons.lang.StringUtils

/**
  * Created by chenyuan on 2018/4/9.
  */
object Startup {

  def testArray(): Unit = {
    val arr1 = new Array[String](3)
    val arr2 = Array(1, 2, 3)
  }

  def testList(): Unit = {
    val list1 = List(1,2,3)
    val list2 = List(4,5)
    val list3 = list1 :: list2
  }

  def testTuple(): Unit = {
    val t1 = Tuple2("cy", 2)
  }

  def main(args: Array[String]):Unit = {

    val s = ""
    val replaceRegex = ("[" + 2.toChar.toString + 3.toChar.toString + "]{1,}").r
    val splitTmpStr = StringUtils.splitPreserveAllTokens(replaceRegex.replaceAllIn(s, ""), "\t")
    val keyList = List(0).map(splitTmpStr)
//    val keyList = List("", "b")
//    println(keyList)
    println(splitTmpStr.mkString("[\"", "\", \"", "\"]"))
    if (keyList.exists(str => StringUtils.isBlank(str) || "null".equals(str.toLowerCase))) {
      throw new RuntimeException(s"映射版本 ${splitTmpStr.mkString("[\"", "\", \"", "\"]")} key为空")
    }
  }

}
