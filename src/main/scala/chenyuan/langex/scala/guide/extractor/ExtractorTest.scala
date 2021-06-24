package com.atella.scala.guide.extractor

/**
  * Created by chenyuan on 2018/4/20.
  */
object Email {

  def apply(user: String,domain: String): String = user + "@" + domain

  def unapply(str: String): Option[(String, String)] = {
    val parts = str split "@"
    if (parts.length == 2) Some(parts(0), parts(1))
    else None
  }

}

object Domain { self =>

  def apply(parts: String*): String = {
    val i = self

    parts.reverse.mkString(".")
  }

  def unapplySeq(whole: String): Option[Seq[String]] =
    Some(whole.split("\\.").reverse)
}

object ExtractorTest extends App {

  List("a@a.com", "a", "@aa").foreach {
    case Email(user, domain) => println("Checked")
    case _ => println("Checked failed.")
  }

  List("", "java.com", "java.oracle.org").foreach {
    case Domain(p1, p2) => println(s"$p1, $p2")
    case Domain(p1, p2, p3) => println(s"$p1, $p2, $p3")
    case Domain(_) => println("not matched.")
  }

}
