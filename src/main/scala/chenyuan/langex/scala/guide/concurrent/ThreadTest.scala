package com.atella.scala.guide.concurrent

/**
  * Created by chenyuan on 2018/4/20.
  */
object ThreadTest extends App {

  val t1 = new Thread("thread-1") {
    override def run(): Unit = println("thread-1 running")
  }

  val t2 = new Thread("thread-2") {
    override def run(): Unit = println("thread-2 running")
  }

  for (e <- Array(1,2,3))
    if (e % 2 ==0)


  t1.start()
  t2.start()

  t1.join()
  t2.join()

}
